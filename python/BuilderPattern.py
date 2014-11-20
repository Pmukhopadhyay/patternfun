class ObjectBuilder:

    def get_id(self):
        return self.__id


    def get_header(self):
        return self.__header


    def get_body(self):
        return self.__body


    def get_footer(self):
        return self.__footer


    def get_type(self):
        return self.__type


    def set_id(self, value):
        self.__id = value


    def set_header(self, value):
        self.__header = value


    def set_body(self, value):
        self.__body = value


    def set_footer(self, value):
        self.__footer = value


    def set_type(self, value):
        self.__type = value


    def del_id(self):
        del self.__id


    def del_header(self):
        del self.__header


    def del_body(self):
        del self.__body


    def del_footer(self):
        del self.__footer


    def del_type(self):
        del self.__type

    def __init(self):
        self.id = -1
        self.header = None
        self.body = None
        self.footer = None
        self.type = None
        id = property(get_id, set_id, del_id, "id's docstring")
        header = property(get_header, set_header, del_header, "header's docstring")
        body = property(get_body, set_body, del_body, "body's docstring")
        footer = property(get_footer, set_footer, del_footer, "footer's docstring")
        type = property(get_type, set_type, del_type, "type's docstring")
    
    def printPageData(self):
        print "The page details :id="+self.get_id()+"|header=" + self.get_header() + "|body=" + self.get_body()
    
class ObjectDirector :
    
    def construct(self,objectBuilder,type,*params):
        objectBuilder.set_type(type)
        self.buildObjectData(objectBuilder,*params)
        objectBuilder.printPageData()
        
    def buildObjectData(self,objectBuilder,*params):
        if(len(params)==1):
           objectBuilder.set_id(params[0])
        elif(len(params)==2):
           objectBuilder.set_id(params[0])
           objectBuilder.set_header(params[1])
        elif(len(params)==3):
           objectBuilder.set_id(params[0])
           objectBuilder.set_header(params[1])
           objectBuilder.set_body(params[2])
        elif(len(params)==4):
           objectBuilder.set_id(params[0])
           objectBuilder.set_header(params[1])
           objectBuilder.set_body(params[2])
           objectBuilder.set_footer(params[3])

class HomePage(ObjectBuilder):
    def __init__(self):
        print "Initializing homepage....."

class LandingPage(ObjectBuilder):
    def __init__(self):
        print "Initializing landingpage....."

class BuilderPattern:
    def main(self):
        director = ObjectDirector()
        director.construct(HomePage(),"HomePage","1","Home Page Header","Home Page Body")
        director.construct(LandingPage(),"LandingPage","2","Landing Page Header","")

BuilderPattern().main()
        