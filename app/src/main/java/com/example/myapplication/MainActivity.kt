package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_words.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_add_word.setOnClickListener(this)
        val adapter = WordAdapter(this)
        rv_words.layoutManager = LinearLayoutManager(this)
        rv_words.adapter = adapter

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        wordViewModel.allWords.observe(this, Observer { it: List<Word>? ->

            it?.let { adapter.setWords(it) }

        })


    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.btn_add_word) {
            val intent = Intent(this, AddWordActivity::class.java)
            startActivityForResult(intent, 1000)
        }
        if (v.id == R.id.btn_get_words) {

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(AddWordActivity.SAVE_WORD).let {
                val word = Word(it as String)
                wordViewModel.insert(word)


            }
        } else {
            Toast.makeText(
                applicationContext,
                "Not Saved",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
