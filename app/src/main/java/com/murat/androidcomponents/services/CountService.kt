package com.murat.androidcomponents.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CountService:Service(){
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Сервис запущен", Toast.LENGTH_SHORT).show()
        startCount()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show()
    }

    private fun startCount() {
        GlobalScope.launch {
            for (i in 0 until 20){
                Log.d("checkData", "Service::: startCount:$i")
                delay(1000)
                if (i == 19){
                    stopSelf()
                }

            }
        }
    }
}
