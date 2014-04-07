package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class view {
	public ArrayList view(String tel, String os, String broad, String color, String dis, double mem, double cpu, int camera, int bettery){
		ArrayList<handphone> datas = new ArrayList<handphone>();
		String sql = "select * from handphone where telecom=? or telecom1 =? or telecom2=? and os=? and broad=? and color=? or color2=? or color3=? or color4=? and dis=? and mem>=? and cpu>=? and camera>=? and bettery>=?";
	try {
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, tel);
		stmt.setString(2, tel);
		stmt.setString(3, tel);
		stmt.setString(4, os);
		stmt.setString(5, broad);
		stmt.setString(6, color);
		stmt.setString(7, color);
		stmt.setString(8, color);
		stmt.setString(9, color);
		stmt.setString(10, dis);
		stmt.setDouble(11, mem);
		stmt.setDouble(12, cpu);
		stmt.setInt(13, camera);
		stmt.setInt(14, bettery);
		//System.out.println(stmt); //확인용
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			handphone a = new handphone();
			a.setTelecom(rs.getString("telecom"));
			a.setOs(rs.getString("os"));
			a.setBroad(rs.getString("broad"));
			a.setColor(rs.getString("color"));
			a.setColor2(rs.getString("color2"));
			a.setColor3(rs.getString("color3"));
			a.setColor4(rs.getString("color4"));
			a.setDis(rs.getString("dis"));
			a.setMem(rs.getDouble("mem"));
			a.setCpu(rs.getDouble("cpu"));
			a.setImage(rs.getString("image"));
			a.setName(rs.getString("name"));
			a.setPrice(rs.getInt("price"));
			datas.add(a);
		}
		rs.close();
		stmt.close();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return datas;
	}
}


