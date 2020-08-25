package com.example.arria;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface SongDao {
    @Query("SELECT *FROM songs WHERE id = :songId")
    Song getSongById(int songId);
}
