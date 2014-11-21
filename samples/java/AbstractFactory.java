package samples.java;

abstract class DatabaseFactory{
	abstract SQLFactory getSQLFactory(String type);
	abstract NoSQLFactory getNoSQLFactory(String type);
}
interface SQLFactory{
	 String getQuery(String dbType, String queryType, String[] tablenames,String[] parameters);
}
interface NoSQLFactory{
	String getQuery(String dbType, String queryType, String[] tablenames,String[] parameters); 
}

class OracleFactory implements SQLFactory{


	
}
