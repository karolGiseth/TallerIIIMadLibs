package com.uan.talleriiimadlibs
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.main_activity.*
import java.util.*


class Main: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        initComponents()
    }

    fun initComponents(){
        actionButton()
        readDescription()
    }

    fun actionButton(){
        getStartedButton.setOnClickListener {
            val Start = Intent(this, StartActivity::class.java)
            startActivity(Start)
        }
    }

    fun readDescription(){

        val scanner = Scanner(resources.openRawResource(R.raw.description))

        var desctext = ""
        while (scanner.hasNextLine()){
            val line = scanner.nextLine()
            desctext += line
        }
        descriptionText.setText(desctext )
        scanner.close()
    }
}