package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class contect {
	Connection connect() {
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("dy.");
		}
		catch(SQLException e){
			System.out.println("sql 맛감");
		}
		catch(ClassNotFoundException e){
			System.out.println("클래스 없다");
		}
		return con;
	}
}