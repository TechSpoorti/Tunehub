
package com.tunehub.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tunehub.Entity.Song;
import com.tunehub.Entity.Users;
import com.tunehub.Services.SongService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class SongController {
	@Autowired
	SongService service;

	@PostMapping("/addSong")

	public String addSong(@ModelAttribute Song song) {
		boolean song_status = service.exitsSongName(song.getName());
		if (song_status == false) {
		service.addSong(song);
		System.out.println("Song is added.");
		}else {
			System.out.println("song is already there.");}
		return "adminHome";
	}

	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		List<Song> songList=service.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "displaySongs";
	}
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		boolean premiumUser=false;
		if(premiumUser==true) {
			List<Song> songList=service.fetchAllSongs();
			model.addAttribute("songs", songList);
			return "displaySong";
			
		}else {
		
		return "makePayment";
	}}

}

	
		
	