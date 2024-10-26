package com.example.button

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    private lateinit var textView_random: TextView
    private lateinit var textview_label: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        textView_random = findViewById(R.id.textView_random)
        textview_label = findViewById(R.id.textview_label)

        showRandomNumber()
    }

    companion object{
        const val TOTAL_COUNT = "total_count"
    }

    @SuppressLint("SetTextI18n")
    fun showRandomNumber(){
        val count :Int = intent.getIntExtra(TOTAL_COUNT, 0)
        val random : Random = Random(0)
        var randomInt :Int = 0
        if(count > 0){
            randomInt = random.nextInt(count+1)
        }
        textView_random.text = Integer.toString(randomInt)
        textview_label.text = getString(R.string.random_heading, count)
    }
}