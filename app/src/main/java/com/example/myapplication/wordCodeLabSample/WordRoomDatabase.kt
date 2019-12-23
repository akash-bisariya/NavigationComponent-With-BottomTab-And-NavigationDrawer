package com.example.myapplication.wordCodeLabSample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Word::class],version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object{

        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {

            val instance =
                INSTANCE
            if(instance!=null){
                return instance
            }
            synchronized(this){
                val instance11 = Room.databaseBuilder(context.applicationContext,
                    WordRoomDatabase::class.java,"word_database").build()
                INSTANCE = instance11
                return instance11
            }

        }

    }

}