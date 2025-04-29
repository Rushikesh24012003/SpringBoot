package com.tka.SBWithJDBC.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.tka.SBWithJDBC.Entity.Song;

public class SongDao {
	private static final String url = "jdbc:mysql://localhost:3306/song";
	private static final String username = "root";
	private static final String password = "root";
	private PreparedStatement pstmt = null;
	private String sql = null;
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public int addSong(Song song) {
		int row = 0 ;
		 sql = "insert into song values(?,?,?)";
		 try {
			 pstmt = getConnection().prepareStatement(sql);
			 pstmt.setInt(1, song.getId());
			 pstmt.setString(2, song.getSongname());
			 pstmt.setString(3, song.getSinger());
			 row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return row;
	}
	
	public int updateSong(Song song) {
		int row = 0 ;
		 sql = "Update song set songname=? , singer=? where id=?";
		 try {
			 pstmt = getConnection().prepareStatement(sql);
			 pstmt.setString(1, song.getSongname());
			 pstmt.setString(2, song.getSinger());
			 pstmt.setInt(3, song.getId());
			 row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return row;
	}
	
	public int deleteSong(int id) {
		int row = 0 ;
		 sql = "delete from song where id=?";
		 try {
			 pstmt = getConnection().prepareStatement(sql);
			 pstmt.setInt(1, id);
			 row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return row;
	}
}
