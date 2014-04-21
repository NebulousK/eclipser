package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql {
	    static Connection connect() {
		Connection con = null;
		Statement stmt;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.168.10.112:3306/scott?dbname?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
			//String url = "jdbc:mysql://127.0.0.1:3306/scott";
			con = DriverManager.getConnection(url, "scott", "tiger");
			//System.out.println("얄루.");
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("sql맛감");
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
			System.out.println("클래스 없다");
		}
		return con;
	}
	    public static void main(String[] args) {
			connect();
		}
}
