package com.example.myapplication.wordCodeLabSample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.wordCodeLabSample.Word
import com.example.myapplication.wordCodeLabSample.WordRepository
import com.example.myapplication.wordCodeLabSample.WordRoomDatabase
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val wordRepository: WordRepository

    var allWords:LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        wordRepository =
            WordRepository(wordsDao)
        allWords = wordRepository.allWords
    }


    fun insert(word: Word) = viewModelScope.launch {
        wordRepository.insert(word)
    }


}