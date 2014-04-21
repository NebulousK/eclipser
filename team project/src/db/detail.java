package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class detail {
	static handphone a = new handphone();
	public static handphone getdb(String name) {
		try {
			PreparedStatement stmt = null;
			mysql g = new mysql();
			Connection con = g.connect();
			String sql = "select * from detail where name=?";		
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			a.setName(rs.getString("name"));
			a.setView(rs.getString("view"));
			rs.close();
			stmt.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	public static String[]  pic(String name){
		int i=0;
		handphone b = new handphone();
		String pic[] = new String[4];
		try {
			PreparedStatement stmt = null;
			mysql g = new mysql();
			Connection con = g.connect();
			String sql = "select * from image where name=?";		
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			//System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			b.setImage(rs.getString("image"));
			b.setImage2(rs.getString("image2"));
			b.setImage3(rs.getString("image3"));
			b.setImage4(rs.getString("image4"));
			rs.close();
			stmt.close();
			pic[0] = b.getImage();
			pic[1] = b.getImage2();
			pic[2] = b.getImage3();
			pic[3] = b.getImage4();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pic;
	}
}
