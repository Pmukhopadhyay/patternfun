#include<iostream.h>
#include <stdarg.h>

using namespace std;

class ObjectBuilder{
private:
	String id;
	String header;
	String body;
	String footer;
	String type;
public:
	void printObjectData();
};

class ObjectDirector{
public:
	void construct(ObjectBuilder builder,String type,)
};
