package com.example.arria;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Song.class, version = 1, exportSchema = false)
public abstract class SongsDB extends RoomDatabase {
    public abstract SongDao songDao();
    public static final String DATABASE_NAME = "databases/songs.db";
    public static SongsDB instance;

    public static SongsDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), SongsDB.class, "songs.db")
                    .allowMainThreadQueries() //можно будет делать запросы на мейн потоки
                    .createFromAsset(DATABASE_NAME)
                    .build();
        }
        return instance;
    }
}
