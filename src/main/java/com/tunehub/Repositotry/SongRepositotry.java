package com.tunehub.Repositotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.Entity.Song;

public interface SongRepositotry extends JpaRepository<Song, Integer> {

	public Song findByName(String name);

}
