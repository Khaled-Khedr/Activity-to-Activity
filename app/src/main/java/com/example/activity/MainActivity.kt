package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var goToButton: Button
    private lateinit var TextViewResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TextViewResult = findViewById(R.id.textView)
        goToButton = findViewById(R.id.button_go_to_act)

        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Constants.RESULT_CODE) {
                    val message = it.data!!.getStringExtra(Constants.INTENT_MESSAGE2_KEY)
                    val message2 = it.data!!.getStringExtra(Constants.INTENT_MESSAGE_KEY)
                    TextViewResult.text = message + "\n" + message2
                }
            }


        goToButton.setOnClickListener {
            //Intent allows us to traverse between activities send data between activities etc
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            //intent got 2 parameters the main activity and the activity u want to go ::class.java
            intent.putExtra(
                Constants.INTENT_MESSAGE_KEY,
                "Hello from 1st activity"
            ) //has a key parameter and the value u gonna pass
            intent.putExtra(Constants.INTENT_MESSAGE2_KEY, "how was your day?")
            intent.putExtra(Constants.INTENT_DATA_NUMBER, 3.14)
            getResult.launch(intent)


            //or an even faster way to send data from activity 1 to 2
            /* Intent(this@MainActivity, SecondActivity::class.java).also {
                 startActivity(it)
             }
              */
        }

    }
}