package samples.java;

import java.util.ArrayList;
import java.util.List;

abstract class DatabaseFactory{
	abstract String getQuery(String queryType, List<String> tablenames,List<String> parameters);
}

class OracleFactory extends DatabaseFactory{
	@Override
	public String getQuery(String queryType,List<String> tablenames, List<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}
}
class MySQLFactory  extends DatabaseFactory{
	@Override
	public String getQuery(String queryType,List<String> tableNames, List<String> parameters) {
		if(queryType.equals("select")){
		 return "select * from "  + tableNames.get(0) + " where " + parameters.get(0) + "=" + parameters.get(1);
		}else{
			return "not yet implemented";
		}
	}
}
class MongoDBFactory  extends DatabaseFactory{
	@Override
	public String getQuery(String queryType,List<String> tableNames, List<String> parameters) {
		if(queryType.equals("select")){
			return "db." + tableNames.get(0) + ".find({"  + parameters.get(0) + " : " + parameters.get(1) + "})";
		}else{
			return "not yet implemented";
		}
	}
}
class CouchDBFactory  extends DatabaseFactory{
	@Override
	public String getQuery(String queryType,List<String> tablenames, List<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}
}
class FactoryProducer{
	public static DatabaseFactory getDBFactory(String type,String dbName) throws Exception{
		if(type.equals("SQL") && dbName.equals("Oracle")){
			return new OracleFactory();
		}else if(type.equals("SQL") && dbName.equals("MySQL")){
			return new MySQLFactory();
		}else if(type.equals("NoSQL") && dbName.equals("MongoDB")){
			return new MongoDBFactory();
		}else if(type.equals("NoSQL") && dbName.equals("CouchDB")){
			return new CouchDBFactory();
		}
		else{
			throw new Exception("Database Type :"+type+" && " + "dbName: " + dbName + "is not supported");
		}
	}
}
public class AbstractFactory{
	public static void main(String args[]) throws Exception{
		List<String> tableNames = new ArrayList<String>();
		List<String> parameters = new ArrayList<String>();
		tableNames.add("Employee");
		parameters.add("id");
		parameters.add("1");
		String mySQLQuery = FactoryProducer.getDBFactory("SQL", "MySQL").getQuery("select",tableNames,parameters);
		System.out.println("Query : " + mySQLQuery);
		String mongoQuery = FactoryProducer.getDBFactory("NoSQL", "MongoDB").getQuery("select",tableNames,parameters);
		System.out.println("Query : " + mongoQuery);
	}
}