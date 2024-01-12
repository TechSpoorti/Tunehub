package com.tunehub.Repositotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.Entity.PlayList;

public interface PlaylistRepository  extends JpaRepository<PlayList, Integer>{

}
