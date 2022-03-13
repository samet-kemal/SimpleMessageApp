package com.samet.simplemessageapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

public class Adapter : BaseAdapter {
     var userList:List<Model>
     var context:Context
     var activity:Activity

    constructor(userList: List<Model>, context: Context,activity: Activity) : super() {
        this.userList = userList
        this.context = context
        this.activity=activity
    }


    override fun getCount(): Int {
        return userList.size

    }

    override fun getItem(p0: Int): Any {
        return userList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
return 0   }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {

        var view:View?=LayoutInflater.from(context).inflate(R.layout.message_list_layout,p2,false)

        if (view !=null ){
            var messageContent:EditText = view!!.findViewById(R.id.messsageContentText)
            var buttonSend:Button = view.findViewById(R.id.sendMessageButton)
            var phoneText:TextView=view.findViewById(R.id.phoneText)
            var nameText:TextView=view.findViewById(R.id.nameText)

            phoneText.text = userList[p0].phoneNumber
            var phonenumber:String=userList[p0].phoneNumber
            nameText.text = userList[p0].name

            buttonSend.setOnClickListener {
                var  messageContent:String = messageContent.text.toString()

                var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+phonenumber))
                intent.putExtra("sms_body",messageContent)
                activity.startActivity(intent)


            }





            return view

        }

        return p1



    }
}