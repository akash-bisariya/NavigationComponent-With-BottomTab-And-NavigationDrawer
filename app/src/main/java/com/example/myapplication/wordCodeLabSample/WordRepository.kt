package com.example.myapplication.wordCodeLabSample

import androidx.lifecycle.LiveData
import com.example.myapplication.wordCodeLabSample.Word
import com.example.myapplication.wordCodeLabSample.WordDao

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }

}