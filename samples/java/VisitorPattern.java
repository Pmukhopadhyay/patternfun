package samples.java;

import java.util.ArrayList;
import java.util.List;

/*
 * Def: It helps to apply multiple operations on core classes without changing the code
 * of the core classes by "visit"-ing those classes. So we can apply new algorithms
 * without changing core classes code.
 * Major methods : accept() / visit()
 */

//visitor interface
interface VisitorOperation{
	void visit(DummyComponents component);
}

class FirstConcreteVisitorOperation implements VisitorOperation {
	@Override
	public void visit(DummyComponents obj) {
		// TODO Auto-generated method stub
		System.out.println("From FirstConcreteVisitorOperation: printing >> " + obj.getId());
	}
}

//visitor component object type
interface DummyComponents{
	void accept(VisitorOperation op);
	String getId();
}

//first concrete sub visitor object
class FirstConcreteSubObject implements DummyComponents{
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	FirstConcreteSubObject(){
		this.setId("First#1");
	}
	@Override
	public void accept(VisitorOperation op) {
		// TODO Auto-generated method stub
		op.visit(this);
	}
}

//second concrete sub visitor object
class SecondConcreteSubObject implements DummyComponents{
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	SecondConcreteSubObject(){
		this.setId("Second#2");
	}
	@Override
	public void accept(VisitorOperation op) {
		// TODO Auto-generated method stub
		op.visit(this);
	}	
}

class VisitorObjectHolder{
	List<DummyComponents> visitorObjectHolder = new ArrayList<DummyComponents> ();
	
	//keeping access default
	VisitorObjectHolder(){
		visitorObjectHolder.add(new FirstConcreteSubObject());
		visitorObjectHolder.add(new SecondConcreteSubObject());
	}
	public void testVisitorOperationOnVisitorComponents(List<VisitorOperation> operations){ 
		for(DummyComponents component : visitorObjectHolder){
			for(VisitorOperation op : operations){
				component.accept(op);
			}
		}
	}
}

//main class to test the visitor pattern design
public class VisitorPattern{
	public static void main(String args[]){
		VisitorObjectHolder objHolder = new VisitorObjectHolder();
		List<VisitorOperation> operations = new ArrayList<VisitorOperation>();
		operations.add(new FirstConcreteVisitorOperation());
		objHolder.testVisitorOperationOnVisitorComponents(operations);
	}
}