package com.tunehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tunehub.Entity.PlayList;
import com.tunehub.Entity.Song;
import com.tunehub.Services.PlaylistService;
import com.tunehub.Services.SongService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	@Autowired
	PlaylistService playService;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return  "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute PlayList playlist) {
		
		playService.addPlaylist(playlist);
		List<Song> songList=songService.getSongs();
		for(Song s:songList) {
			s.getPlaylist().add(playlist);
			songService.updateSong(s);
		}
		return "adminHome";
	}
	@GetMapping("/viewPlaylist")
	public String viewPlaylist(Model model) {
		List<PlayList> allPlayList=playService.fetchAllPlaylists();
		model.addAttribute("allPlayList", allPlayList);
		return "displayplaylist";
	}
	
	
	

}
