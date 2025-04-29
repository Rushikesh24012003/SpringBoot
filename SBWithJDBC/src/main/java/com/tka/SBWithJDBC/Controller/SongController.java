package com.tka.SBWithJDBC.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.SBWithJDBC.Entity.Song;
import com.tka.SBWithJDBC.Service.SongService;

@RestController
public class SongController {
	SongService service = new SongService();
	
	@PostMapping("/addSong")
	void addSong(@RequestBody Song song){
		service.addSong(song);
	}
	
	@PutMapping("/updateSong")
	void updateSong(@RequestBody Song song){
		service.updateSong(song);
	}
	
	@DeleteMapping("/deleteSong/{id}")
	void updateSong(@PathVariable int id){
		service.deleteSong(id);
	}
}
