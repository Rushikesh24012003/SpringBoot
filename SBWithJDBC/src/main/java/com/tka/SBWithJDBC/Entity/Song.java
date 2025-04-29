package com.tka.SBWithJDBC.Entity;

public class Song {
	private int id;
	private String songname;
	private String singer;
	public Song(int id, String songname, String singer) {
		super();
		this.id = id;
		this.songname = songname;
		this.singer = singer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", songname=" + songname + ", singer=" + singer + "]";
	}
	public Song() {
		super();
	}
	
	
}
