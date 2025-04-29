package com.tka.SBWithJDBC.Service;

import com.tka.SBWithJDBC.Dao.SongDao;
import com.tka.SBWithJDBC.Entity.Song;

public class SongService {
	 SongDao dao = new SongDao();
	 
	 public void addSong(Song song) {
		 if(dao.addSong(song)>0) {
			 System.out.println("data inserted sucessfully!!.");
		 }else {
			 System.out.println("Song not inserted.");
		 }
	 }
	 
	 public void updateSong(Song song) {
		 if(dao.updateSong(song)>0) {
			 System.out.println("data updated sucessfully!!.");
		 }else {
			 System.out.println("Song not updated.");
		 }
	 }
	 
	 public void deleteSong(int id) {
		 if(dao.deleteSong(id)>0) {
			 System.out.println("data deleted sucessfully!!.");
		 }else {
			 System.out.println("Song not deleted.");
		 }
	 }

}
