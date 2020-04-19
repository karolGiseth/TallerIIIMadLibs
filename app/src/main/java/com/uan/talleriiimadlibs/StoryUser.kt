package com.uan.talleriiimadlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.story.*

class StoryUser: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.story)

        initComponents()

    }

    fun initComponents() {
        getStory()
        newStoryButton()
        fillTextTitle()
    }

    fun fillTextTitle() {
        nameHistory.setText("YOUR MAD LIB STORY!")
    }

    fun newStoryButton() {
        historyTwo.setOnClickListener {
            finish()
        }
    }

    //extracting the story
    fun getStory() {
        val intent = this.intent.extras
        if (intent != null) {
            val extra = intent.getString("story")
            storyTextView.setText(extra)
        }
    }
}