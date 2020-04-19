package com.uan.talleriiimadlibs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.start_activity.*
import java.util.*
class StartActivity : AppCompatActivity() {



    val  myConnector= "<and>"

    val  ownName= "<ownName>"

    val myAdjetives="<adjetive>"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        startAction()
    }

    fun startAction(){

        initButton()

    }

    fun initButton() {

        exitButton.setOnClickListener {
            val intent1 = Intent(this, StoryUser::class.java)
            intent1.putExtra("story", lookForInputsInStory())
            startActivity(intent1)
        }
    }


    fun readStory(): String {
        //scanning files
        val scanner = Scanner(resources.openRawResource(R.raw.story))
        //reading
        var story = ""
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            story += line
        }
        scanner.close()
        return story
    }

    fun lookForInputsInStory(): String {

        val connector1 = myConnectorText.text.toString()
        var adjetive1 = myAdjetiveText.text.toString()
        var ownName1 = myOwnText.text.toString()
        var storyMadLibs = readStory()

        var remplaConnectors = storyMadLibs.replace(myConnector, connector1, true)
        var remplaAdjetives = remplaConnectors.replace(myAdjetives, adjetive1, true)
        var newStory = remplaAdjetives.replace(ownName, ownName1, true)

        return newStory
    }



}
