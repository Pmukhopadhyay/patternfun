class ObjectBuilder
	id : -1
	header : ""
	body : ""
	footer : ""
	type : ""
	
	getId : () ->
		return this.id
	setId : (id) ->
		this.id = id
	getHeader : () ->
		return this.header
	setHeader : (header) ->
		this.header = header
	getBody : () ->
		return this.body
	setBody : (body) ->
		this.body = body
	getFooter : () ->
		return this.footer
	setFooter : (footer) ->
		this.footer = footer
	getType : () ->
		return this.type
	setType : (type) ->
		this.type = type
	printPageData : () ->
		console.log "Id=#{this.id}|header=#{this.header}|body=#{this.body}" 
	
class ObjectDirector 
	construct : (objectBuilder,type,parameters...) ->
		objectBuilder.setType(type)
		this.buildObjectData(objectBuilder,parameters.length,parameters)
		objectBuilder.printPageData()
	buildObjectData : (builder,length,parameters) ->
		console.log parameters
		if length is 1
		   builder.setId(parameters)
		else if length is 2 
		   console.log "inside length 2"
		   i = 0
		   for param in parameters
		     console.log "for loop....#{param}"
		     if i is 0  
		     	builder.setId(param)
		     else builder.setHeader(param)
		     i++
		else if length  is 3
		   i = 0
		   for param in parameters
		     if i is 0  
		     	builder.setId(param)
		     else if i is 1 
		     	builder.setHeader(param)
		     else if i is 2
		     	builder.setBody(param)
		     i++
		    
class HomePage extends ObjectBuilder
	constructor : () ->
		console.log "This is HomePage.."
		
class LandingPage extends ObjectBuilder
	constructor : () ->
		console.log "This is LandingPage..."

class BuilderPattern 
	main : () ->
		ObjectDirector director = new ObjectDirector()
		director.construct(new HomePage(),"HomePage","1","HomePage Header","HomePage Body")
		director.construct(new LandingPage(),"LandingPage","2","LandingPage Header")

new BuilderPattern().main()