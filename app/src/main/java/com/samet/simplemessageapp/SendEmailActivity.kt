package com.samet.simplemessageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class SendEmailActivity : AppCompatActivity() {

    lateinit var emailSubjectText:EditText
    lateinit var emailContentText:EditText
    lateinit var emailAddressText:EditText
    lateinit var sendButton:Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_email)

        Initialize()
        EmailSend()


    }


    fun EmailSend(){
        sendButton.setOnClickListener {

            Toast.makeText(applicationContext,"Click",Toast.LENGTH_SHORT).show()

            try {
                var content:String=emailContentText.text.toString()
                var address:String=emailAddressText.text.toString()
                var subjectontent:String=emailSubjectText.text.toString()

                val intent= Intent(Intent.ACTION_SEND)
                intent.setType("message/rfcB22")
                intent.putExtra(Intent.EXTRA_EMAIL,address)
                intent.putExtra(Intent.EXTRA_SUBJECT,subjectontent)
                intent.putExtra(Intent.EXTRA_TEXT,content)
                startActivity(Intent.createChooser(intent,"Please Send Your Email"))
            }catch (e:Exception){
                System.out.println(e.printStackTrace())
            }
        }

    }





    fun Initialize(){
        emailAddressText=findViewById(R.id.emailAddressEditText)
        emailContentText=findViewById(R.id.emailContentEditText)
        emailSubjectText=findViewById(R.id.emailSubjectEditText)
        sendButton=findViewById(R.id.sendEmail)

    }
}