package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class view {
	public ArrayList<handphone> view(String tel, String os, String broad, String dis, String camera, String bettery, String price){
		ArrayList<handphone> datas = new ArrayList<handphone>();
		int display =0 , display2 = 0 ,cam =0 , cam2 =0 ,bet = 0, bet2= 0 ,pri = 0;
		String sql = null;
		if(dis == "105미만"){display = 105;}
		else if(dis == "105~130"){display = 105; display2 = 130;}
		else if(dis == "130~150"){display = 130; display2 = 150;}
		else if(dis == "150~170"){display = 150; display2 = 170;}
		if(camera == "200 이상"){cam = 200;}
		else if(camera == "200 ~ 300"){cam = 200; cam2=300;}
		else if(camera == "300 ~ 400"){cam = 300; cam2=400;}
		else if(camera == "500 이상"){cam = 500;}
	    if(bettery == "500 ~ 1000"){bet = 500; bet2 = 1000;}
		else if(bettery == "1000 ~ 1500"){bet = 1000; bet2 = 1500;}
		else if(bettery == "1500이상"){bet = 1500;}
		if(price == "400,000 이하"){pri = 400000;}
		else if(price == "500,000 이하"){pri = 500000;}
		else if(price == "600,000 이하"){pri = 600000;}
		else if(price == "700,000 이하"){pri = 700000;}
		else if(price == "800,000 이하"){pri = 800000;}
		else if(price == "900,000 이하"){pri = 900000;}
		else if(price == "1,000,000 이하"){pri = 1000000;}
		if(display2 == 0 && cam2 == 0 && bet2 == 0){
			sql = "select * from handphone where (telecom = ? OR telecom2 = ? OR telecom3 = ?) and os=? and broad=? "
				+ "and dis<? and camera>=? and bettery>=? and price<=?";
		}
		else if(display2 == 0 && cam2 == 0 && bet2 != 0){
			sql = "select * from handphone where (telecom = ? OR telecom2 = ? OR telecom3 = ?) and os=? and broad=? "
					+ "and dis<? and camera>=? and (bettery>=? and bettery<=?) and price<=?";
			}
		else if(display2 == 0 && cam2 != 0 && bet2 == 0){
			sql = "select * from handphone where (telecom = ? OR telecom2 = ? OR telecom3 = ?) and os=? and broad=? "
					+ "and dis<? and (camera>=? and camera<=?) and bettery>=? and price<=?";
			}
		else if(display2 == 0 && cam2 != 0 && bet2 != 0){
			sql = "select * from handphone where (telecom = ? OR telecom2 = ? OR telecom3 = ?) and os=? and broad=? "
					+ "and dis<? and (camera>=? and camera<=?) and (bettery>=? and bettery<=?) and price<=?";
			}
		else if(display2 != 0 && cam2 == 0 && bet2 == 0){
			sql = "select * from handphone where (telecom = ? OR telecom2 = ? OR telecom3 = ?) and os=? and broad=? "
					+ "and (dis>=? and dis<=?) and camera>=? and bettery>=? and price<=?";
			}
		else if(display2 != 0 && cam2 != 0 && bet2 == 0){
			sql = "select * from handphone where (telecom = ? OR telecom2 = ? OR telecom3 = ?) and os=? and broad=? "
					+ "and (dis>=? and dis<=?) and (camera>=? and camera<=?) and bettery>=? and price<=?";
			}
		else if(display2 != 0 && cam2 == 0 && bet2 != 0){
			sql = "select * from handphone where (telecom = ? OR telecom2 = ? OR telecom3 = ?) and os=? and broad=? "
					+ "and (dis>=? and dis<=?) and camera>=? and (bettery>=? and bettery<=?) and price<=?";
			}
		else if(display2 != 0 && cam2 != 0 && bet2 != 0){
			sql = "select * from handphone where (telecom = ? OR telecom2 = ? OR telecom3 = ?) and os=? and broad=? "
					+ "and (dis>=? and dis<=?) and (camera>=? and camera<=?) and (bettery>=? and bettery<=?) and price<=?";
			}
	try {
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		stmt = con.prepareStatement(sql);
		if(display2 == 0 && cam2 == 0 && bet2 == 0){
			stmt.setString(1, tel);
			stmt.setString(2, tel);
			stmt.setString(3, tel);
			stmt.setString(4, os);
			stmt.setString(5, broad);
			stmt.setInt(6, display);
			stmt.setInt(7, cam);
			stmt.setInt(8, bet);
			stmt.setInt(9, pri);
		}
		else if(display2 == 0 && cam2 == 0 && bet2 != 0){
			stmt.setString(1, tel);
			stmt.setString(2, tel);
			stmt.setString(3, tel);
			stmt.setString(4, os);
			stmt.setString(5, broad);
			stmt.setInt(6, display);
			stmt.setInt(7, cam);
			stmt.setInt(8, bet);
			stmt.setInt(9, bet2);
			stmt.setInt(10, pri);
			}
		else if(display2 == 0 && cam2 != 0 && bet2 == 0){
			stmt.setString(1, tel);
			stmt.setString(2, tel);
			stmt.setString(3, tel);
			stmt.setString(4, os);
			stmt.setString(5, broad);
			stmt.setInt(6, display);
			stmt.setInt(7, cam);
			stmt.setInt(8, cam2);
			stmt.setInt(9, bet);
			stmt.setInt(10, pri);
		}
		else if(display2 == 0 && cam2 != 0 && bet2 != 0){
			stmt.setString(1, tel);
			stmt.setString(2, tel);
			stmt.setString(3, tel);
			stmt.setString(4, os);
			stmt.setString(5, broad);
			stmt.setInt(6, display);
			stmt.setInt(7, cam);
			stmt.setInt(8, cam2);
			stmt.setInt(9, bet);
			stmt.setInt(10, bet2);
			stmt.setInt(11, pri);
		}
		else if(display2 != 0 && cam2 == 0 && bet2 == 0){
			stmt.setString(1, tel);
			stmt.setString(2, tel);
			stmt.setString(3, tel);
			stmt.setString(4, os);
			stmt.setString(5, broad);
			stmt.setInt(6, display);
			stmt.setInt(7, display2);
			stmt.setInt(8, cam);
			stmt.setInt(9, bet);
			stmt.setInt(10, pri);
		}
		else if(display2 != 0 && cam2 != 0 && bet2 == 0){
			stmt.setString(1, tel);
			stmt.setString(2, tel);
			stmt.setString(3, tel);
			stmt.setString(4, os);
			stmt.setString(5, broad);
			stmt.setInt(6, display);
			stmt.setInt(7, display2);
			stmt.setInt(8, cam);
			stmt.setInt(9, cam2);
			stmt.setInt(10, bet);
			stmt.setInt(11, pri);
		}
		else if(display2 != 0 && cam2 == 0 && bet2 != 0){
			stmt.setString(1, tel);
			stmt.setString(2, tel);
			stmt.setString(3, tel);
			stmt.setString(4, os);
			stmt.setString(5, broad);
			stmt.setInt(6, display);
			stmt.setInt(7, display2);
			stmt.setInt(8, cam);
			stmt.setInt(9, bet);
			stmt.setInt(10, bet2);
			stmt.setInt(11, pri);
		}
		else if(display2 != 0 && cam2 != 0 && bet2 != 0){
			stmt.setString(1, tel);
			stmt.setString(2, tel);
			stmt.setString(3, tel);
			stmt.setString(4, os);
			stmt.setString(5, broad);
			stmt.setInt(6, display);
			stmt.setInt(7, display2);
			stmt.setInt(8, cam);
			stmt.setInt(9, cam2);
			stmt.setInt(10, bet);
			stmt.setInt(11, bet2);
			stmt.setInt(12, pri);
		}
		//System.out.println(stmt);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			handphone a = new handphone();
			a.setTelecom(rs.getString("telecom"));
			a.setOs(rs.getString("os"));
			a.setBroad(rs.getString("broad"));
			a.setDis(rs.getInt("dis"));
			a.setName(rs.getString("name"));
			a.setPrice(rs.getInt("price"));
			a.setCamera(rs.getInt("camera"));
			a.setBettery(rs.getInt("bettery"));
			datas.add(a);
		}
		rs.close();
		stmt.close();
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return datas;
	}
	
	public static ArrayList<handphone> get(){
		ArrayList<handphone> datas = new ArrayList<handphone>();
	try {
		PreparedStatement stmt = null;
		mysql g = new mysql();
		Connection con = g.connect();
		String sql = "select * from handphone";
		stmt = con.prepareStatement(sql);
		//System.out.println(stmt);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			handphone a = new handphone();
			a.setTelecom(rs.getString("telecom"));
			a.setTelecom2(rs.getString("telecom2"));
			a.setTelecom3(rs.getString("telecom3"));
			a.setOs(rs.getString("os"));
			a.setBroad(rs.getString("broad"));
			a.setDis(rs.getInt("dis"));
			a.setName(rs.getString("name"));
			a.setPrice(rs.getInt("price"));
			a.setCamera(rs.getInt("camera"));
			a.setBettery(rs.getInt("bettery"));
			datas.add(a);
		}
		rs.close();
		stmt.close();
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return datas;
	}
}


