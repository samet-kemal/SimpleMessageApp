package com.samet.simplemessageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userList :List<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FillList()
        Initialize()
    }




    fun FillList(){

        var m1 = Model("User1","+905256326978")
        var m2 = Model("User2","+905256326979")
        var m3 = Model("User3","+905256326980")
        var m4 = Model("User4","+905256326981")
        var m5 = Model("User5","+905256326982")

        userList= listOf(m1,m2,m3,m4,m5)

    }

    fun Initialize(){
        var listView: ListView = findViewById(R.id.message_list)
        var adapter  = Adapter(userList,this,this)
        listView.adapter=adapter

    }



}