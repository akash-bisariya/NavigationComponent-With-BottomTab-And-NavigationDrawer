package com.example.myapplication

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {


    val allwords:LiveData<List<Word>> = wordDao.getAllWords()

    suspend fun insert(word:Word){
        wordDao.insert(word)
    }

}