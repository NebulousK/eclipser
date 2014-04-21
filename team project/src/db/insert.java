package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {
	public static void handphon(String name, String telecom, String telecom2, String telecom3, String os, String broad, int dis, int camera, int bettery, int price){
		try {
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		String sql = "INSERT INTO handphone(name, telecom, telecom2, telecom3, os, broad, dis, camera, bettery, price)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, telecom);
		stmt.setString(3, telecom2);
		stmt.setString(4, telecom3);
		stmt.setString(5, os);
		stmt.setString(6, broad);
		stmt.setInt(7, dis);
		stmt.setInt(8, camera);
		stmt.setInt(9, bettery);
		stmt.setInt(10, price);
		stmt.executeUpdate();
		stmt.close();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void image(String name, String image, String image2,String image3,String image4){
		try {
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		String sql = "INSERT INTO image(name, image, image2, image3, image4) "
				+ "VALUES(?,?,?,?,?)";		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, image);
		stmt.setString(3, image2);
		stmt.setString(4, image3);
		stmt.setString(5, image4);
		stmt.executeUpdate();
		stmt.close();
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}	
	public static void detail(String name, String view){
		try {
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		String sql = "INSERT INTO detail(name, view) "
				+ "VALUES(?,?)";		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, view);
		stmt.executeUpdate();
		stmt.close();
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
