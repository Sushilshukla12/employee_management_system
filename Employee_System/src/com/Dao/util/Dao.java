package com.Dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Dbconnect.util.Dbconnect;
import com.Getset.util.Getset;

public class Dao {
	static Connection con=Dbconnect.connect();
	public static List<Getset>getAllRecords(){
		List<Getset>p=new ArrayList<>();
		try {
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from info");
			while(rs.next()) {
				Getset g=new Getset();
				g.setId(rs.getInt("id"));
				g.setFirst_name(rs.getString("first_name"));
				g.setLast_name(rs.getString("last_name"));
				g.setAge(rs.getInt("age"));
				p.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}
	public static boolean insertRecord(int id, String first_name,String last_name,int age) {
		String sql="insert into info values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, first_name);
			ps.setString(3, last_name);
			ps.setInt(4, age );
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public static Getset searchById(int id) {
		Getset g=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from info where id =?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			g=new Getset();
			rs.next();
			g.setId(rs.getInt("id"));
			g.setFirst_name(rs.getString("first_name"));
			g.setLast_name(rs.getString("last_name"));
			g.setAge(rs.getInt("age"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
		
	}
	public static boolean deleteRecord(int id) {
		String sql = "delete from info where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static  boolean updateRecord(Getset get ) {
		String sql="update info set first_name=?,last_name=?,age=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, get.getFirst_name());
			ps.setString(2, get.getLast_name());
			ps.setInt(3, get.getAge());
			ps.setInt(4, get.getId());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
}


}
