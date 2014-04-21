package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {

	public delete(String name){
		try {
	    PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		String sql = "delete from handphone where name = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.executeUpdate();
		stmt.close();
		sql = "delete from detail where name = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.executeUpdate();
		stmt.close();
		sql = "delete from image where name = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.executeUpdate();
		stmt.close();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
