package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {
	public insert(String tel, String os, String broad, String color, String dis, double mem, double cpu, int camera, int bettery, String image, String name, String color2, String color3, String color4, int price){
		try {
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		String sql = "INSERT INTO handphone(telecom, os, broad, color, dis, mem, cpu, camera, bettery, image, name, color2, color3, color4, price) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, tel);
		stmt.setString(2, os);
		stmt.setString(3, broad);
		stmt.setString(4, color);
		stmt.setString(5, dis);
		stmt.setDouble(6, mem);
		stmt.setDouble(7, cpu);
		stmt.setInt(8, camera);
		stmt.setInt(9, bettery);
		stmt.setString(10, image);
		stmt.setString(11, name);
		stmt.setString(12, color2);
		stmt.setString(13, color3);
		stmt.setString(14, color4);
		stmt.setInt(15, price);
		stmt.executeUpdate();
		stmt.close();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
