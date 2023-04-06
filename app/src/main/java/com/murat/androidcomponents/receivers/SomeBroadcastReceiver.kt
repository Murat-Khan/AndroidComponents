package com.murat.androidcomponents.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SomeBroadcastReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneMode = intent?.getBooleanExtra("state",false)?:false

        if (isAirplaneMode){
            Log.d("checkData", "Airplane Mode enabled ")
        }else{
            Log.d("checkData", "Airplane Mode disabled")

        }
    }


}