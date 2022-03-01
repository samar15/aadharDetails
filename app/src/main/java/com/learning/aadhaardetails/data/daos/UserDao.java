package com.learning.aadhaardetails.data.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learning.aadhaardetails.data.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addUser(User user);

    @Query("select * from user where id = :id;")
    User getUserById(Long id);
}
