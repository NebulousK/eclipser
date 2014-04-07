package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {
	public delete(int no){
		try {
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		String sql = "delete form handphone where no =" + no;		
		System.out.println(sql);
		stmt.executeUpdate(sql);
		stmt.close();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
