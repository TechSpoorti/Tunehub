package com.tunehub.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.Entity.PlayList;
import com.tunehub.Repositotry.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	@Autowired
	PlaylistRepository repo;

	@Override
	public void addPlaylist(PlayList playlist) {
		repo.save(playlist);
	}

	@Override
	public List<PlayList> fetchAllPlaylists() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
