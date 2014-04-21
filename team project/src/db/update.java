package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Flame.admin;

import javax.swing.JOptionPane;

public class update {
	static handphone a = new handphone();
	public static handphone getdb(String name) {
		try {
			PreparedStatement stmt = null;
			mysql g = new mysql();
			Connection con = g.connect();
			String sql = "SELECT handphone.name, handphone.telecom , handphone.telecom2, handphone.telecom3, handphone.os,handphone.broad,"
					+ " handphone.dis, handphone.camera,handphone.bettery, handphone.price, detail.view,image.image, image.image2, "
					+ "image.image3,image.image4 FROM handphone, detail, image WHERE handphone.name=detail.name and "
					+ "handphone.name = image.name and handphone.name=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			a.setName(rs.getString("handphone.name"));
			a.setTelecom(rs.getString("handphone.telecom"));
			a.setTelecom2(rs.getString("handphone.telecom2"));
			a.setTelecom3(rs.getString("handphone.telecom3"));
			a.setOs(rs.getString("handphone.os"));
			a.setBroad(rs.getString("handphone.broad"));
			a.setDisplay(rs.getInt("handphone.dis"));
			a.setCamera(rs.getInt("handphone.camera"));
			a.setBettery(rs.getInt("handphone.bettery"));
			a.setPrice(rs.getInt("handphone.price"));
			a.setView(rs.getString("detail.view"));
			a.setImage(rs.getString("image.image"));
			a.setImage2(rs.getString("image.image2"));
			a.setImage3(rs.getString("image.image3"));
			a.setImage4(rs.getString("image.image4"));
			rs.close();
			stmt.close();		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(admin.contentPane,"일치하는 핸드폰이 없습니다.");
		}
		return a;
	}
	
	
	
	public update(String name, String telecom, String telecom2, String telecom3, String os, String broad, int dis, int camera, int bettery, int price, String view, String image, String image2, String image3, String image4 ){
		try {			
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		String sql = "update handphone set name=?, telecom=?, telecom2=?, telecom3=?, os=?, broad=?, dis=?, camera=?, "
				+ "bettery =? ,price=? where name=?";		
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
		stmt.setString(11, name);
		stmt.executeUpdate();
		System.out.println(stmt);
		stmt.close();
		
		sql = "update image set name=?, image=?, image2=?, image3=?, image4=? where name=?";		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, image);
		stmt.setString(3, image2);
		stmt.setString(4, image3);
		stmt.setString(5, image4);
		stmt.setString(6, name);
		stmt.executeUpdate();
		System.out.println(stmt);
		stmt.close();
		
		sql = "update detail set name=?, view=? where name=?";		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, view);
		stmt.setString(3, name);
		stmt.executeUpdate();
		System.out.println(stmt);
		stmt.close();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
