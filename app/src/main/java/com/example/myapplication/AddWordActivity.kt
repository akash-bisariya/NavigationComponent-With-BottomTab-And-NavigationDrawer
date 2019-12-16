package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        btn_save.setOnClickListener {

            if (et_word.text.isNotEmpty()) {
                val replyIntent = Intent()
                replyIntent.putExtra(SAVE_WORD, et_word.text.toString())
                setResult(Activity.RESULT_OK, replyIntent)
                finish()
            }

        }

    }

    companion object {
        const val SAVE_WORD = "com.example.android.wordlistsql.word"
    }
}
