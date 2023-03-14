package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textviewDataIntent: TextView
    private lateinit var gobackbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textviewDataIntent = findViewById(R.id.textViewData)
        gobackbutton = findViewById(R.id.buttonGoback)
        gobackbutton.setOnClickListener {

            val intent = intent  //sending data back from activity 2 to 1
            intent.putExtra(Constants.INTENT_MESSAGE2_KEY, "Hello from the 2nd activity")
            intent.putExtra(Constants.INTENT_MESSAGE_KEY, "WOW!")

            setResult(Constants.RESULT_CODE, intent)
            finish()

        }
        val data =
            intent.extras  //getting the extras from the 1st activity (getting data from activity 1

        data?.let {  //if the data is not null execute this code
            val message = data.getString(Constants.INTENT_MESSAGE_KEY)
            val message2 = data.getString(Constants.INTENT_MESSAGE2_KEY)
            val number = data.getDouble(Constants.INTENT_DATA_NUMBER)

            textviewDataIntent.text = message + "\n" + message2 + "\n" + number

        }
    }
}
