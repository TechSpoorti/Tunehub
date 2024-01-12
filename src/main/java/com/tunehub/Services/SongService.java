package com.tunehub.Services;

import java.util.List;

import com.tunehub.Entity.Song;

public interface SongService {

	public void addSong(Song song);

	public List<Song> fetchAllSongs();

	public boolean exitsSongName(String name);

	//public List<Song> getSongs();

	public void updateSong(Song s);

	public List<Song> getSongs();

}
