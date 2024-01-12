package com.tunehub.Services;

import java.util.List;

import com.tunehub.Entity.PlayList;

public interface PlaylistService {

public	void addPlaylist(PlayList playlist);

public List<PlayList> fetchAllPlaylists();

}
