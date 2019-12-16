package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val wordRepository:WordRepository

    var allWords:LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        wordRepository = WordRepository(wordsDao)
        allWords = wordRepository.allwords
    }


    fun insert(word:Word) = viewModelScope.launch {
        wordRepository.insert(word)
    }


}