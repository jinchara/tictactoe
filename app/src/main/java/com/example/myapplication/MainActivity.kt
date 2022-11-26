package com.example.myapplication


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView

    private lateinit var angarishi1 : TextView
    private lateinit var angarishi2 : TextView
    private var firstscore = 0
    private var secondscore = 0
    private var endGame=0


    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        resetButton.setOnClickListener {
            reset()
        }
    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.resetButton)
        angarishi1 = findViewById(R.id.angarishi1)
        angarishi2= findViewById(R.id.angarishi2)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)


        val resultFirst=intent.extras?.getString("first player")
        val resultSecond=intent.extras?.getString("second player")
        textView1=findViewById<TextView?>(R.id.user1).apply {
            text=resultFirst

        }

        textView2=findViewById<TextView?>(R.id.user2).apply {
            text=resultSecond
        }



    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0

            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9

            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2) {
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.GREEN)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
        if (endGame==0){
            check()
        }
        if (endGame==1){
            activePlayer = 3
        }
    }

    private fun check() {
        var winnerPlayer = 0


        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }


        if (winnerPlayer == 1) {
            Toast.makeText(this, "winner is first player", Toast.LENGTH_SHORT).show()
            firstscore += 1

            angarishi1.text == firstscore.toString()

            endGame=1
        }
        if (winnerPlayer == 2) {
            Toast.makeText(this, "winner is second player", Toast.LENGTH_SHORT).show()
            secondscore += 1
            angarishi2.text.toString().toInt() == secondscore

            endGame=1
        }
        if (firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0){
            Toast.makeText(this,"gaimarjva megobrobam", Toast.LENGTH_SHORT).show()
        }


    }
    private fun reset() {
        button1.text = ""
        button1.setBackgroundColor(Color.CYAN)
        button2.text = ""
        button2.setBackgroundColor(Color.CYAN)
        button3.text = ""
        button3.setBackgroundColor(Color.CYAN)
        button4.text = ""
        button4.setBackgroundColor(Color.CYAN)
        button5.text = ""
        button5.setBackgroundColor(Color.CYAN)
        button6.text = ""
        button6.setBackgroundColor(Color.CYAN)
        button7.text = ""
        button7.setBackgroundColor(Color.CYAN)
        button8.text = ""
        button8.setBackgroundColor(Color.CYAN)
        button9.text = ""
        button9.setBackgroundColor(Color.CYAN)

        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer=1
        endGame=0


        button1.isEnabled=true
        button2.isEnabled=true
        button3.isEnabled=true
        button4.isEnabled=true
        button5.isEnabled=true
        button6.isEnabled=true
        button7.isEnabled=true
        button8.isEnabled=true
        button9.isEnabled=true


    }
}