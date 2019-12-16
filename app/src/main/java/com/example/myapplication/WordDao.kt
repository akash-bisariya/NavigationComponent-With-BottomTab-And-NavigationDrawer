package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word:Word)

    @Query("DELETE From tab_word")
    suspend fun deleteAll()

    @Query("SELECT * From tab_word ORDER BY word ASC")
    fun getAllWords():LiveData<List<Word>>
}