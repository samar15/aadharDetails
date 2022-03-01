package com.learning.myapplication.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.learning.myapplication.data.daos.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
