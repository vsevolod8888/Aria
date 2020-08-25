package com.example.arria;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "songs")
public class Song {
    @NonNull
    @PrimaryKey(autoGenerate = true) //Аннотацией PrimaryKey мы помечаем поле, которое будет ключом в таблице
    @ColumnInfo(name = "ID")
    public int ID;
    @NonNull
    @ColumnInfo(name = "song_name")
    public String songName;
    @NonNull
    @ColumnInfo(name = "file_name")
    public String fileName;

    public String getSongName() {
        return songName;
    }
    public String getFileName(){
        return fileName;
    }
}
