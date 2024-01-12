package com.tunehub.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.Entity.Song;
import com.tunehub.Repositotry.SongRepositotry;

@Service
public class SongServiceImpl implements SongService {
	@Autowired
	SongRepositotry repo;
	@Override
	public void addSong(Song song) {
		
		repo.save(song);
		
	}
	@Override
	public List<Song> fetchAllSongs() {
		
		return repo.findAll();
	}
	@Override
	public boolean exitsSongName(String name) {
		Song song=repo.findByName(name);
		if(song==null) {
			return false;
		}else {
			return true;
		}
	}
	@Override
	public void updateSong(Song s) {
		repo.save(s);
		
	}
	@Override
	public List<Song> getSongs() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
}
