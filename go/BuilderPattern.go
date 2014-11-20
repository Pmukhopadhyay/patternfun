 package main

import(
	"fmt"
	)
type Page interface{
	getId() string
	setId(id string) 
	getHeader() string
	setHeader(header string)
	getBody() string
	setBody(body string)
	setFooter(footer string)
	getObjType() string
	setType(objType string)
	printPageData()
}
type ObjectBuilder struct{
	id string
	header string
	body string
	footer string
	objType string
}
func(O ObjectBuilder) getId() string{
	return O.id
}
//pass a pointer to struct so that we can modify the data in memory location
func(O *ObjectBuilder) setId(id string){
	O.id = id
}
func(O ObjectBuilder) getHeader() string{
	return O.header
}
func(O *ObjectBuilder) setHeader(header string){
	O.header = header
}
func(O ObjectBuilder) getBody() string{
	return O.body
}
func(O *ObjectBuilder) setBody(body string){
	O.body = body
}
func(O ObjectBuilder) getFooter() string{
	return O.footer
}
func(O *ObjectBuilder) setFooter(footer string){
	O.footer = footer
}
func(O ObjectBuilder) getObjType() string{
	return O.objType
}
func(O *ObjectBuilder) setType(objType string){
	O.objType = objType
}
func(O ObjectBuilder) printPageData(){
	outputString := "From ObjectBuilder##id=" 
	outputString += O.getId()
	outputString += "|Header##"
	outputString += O.getHeader()
	outputString += "|Body##"
	outputString += O.getBody()
	fmt.Println(outputString)
}
type ObjectDirector struct{}
func(O ObjectDirector) construct(builder Page,objType string,parameters ...string){
	builder.setType(objType)
	O.buildObjectData(builder,len(parameters),parameters)
	builder.printPageData()
}
func(O ObjectDirector) buildObjectData(builder Page,length int,parameters []string){
	fmt.Println(parameters)
	if length==1 {
		builder.setId(parameters[0])
	}else if length==2 { 
		fmt.Println("inside length 2")
		i := 0
		for _,param := range(parameters) {
		  fmt.Println("for loop...")
		  if i==0 { 
		     builder.setId(param)
	      } else {
	     	 builder.setHeader(param)
		  }
	      i++
 	   }
	} else if length==3 {
		i := 0
		for _,param := range(parameters) {
		     if i==0 {  
		     	builder.setId(param)
		   	} else if i==1 { 
		     	builder.setHeader(param)
		   	} else if i==2 {
		     	builder.setBody(param)
		   	}
	     i++
       }
   }	
	}//buildObjectData
type HomePage struct{
	ObjectBuilder
} 
type LandingPage struct{
	ObjectBuilder
}
type BuilderPattern struct{}

func main(){
	director := ObjectDirector{}
	director.construct(new(HomePage),"HomePage","1","HomePage Header","HomePage Body")
	director.construct(new(LandingPage),"LandingPage","2","LandingPage Header")
}