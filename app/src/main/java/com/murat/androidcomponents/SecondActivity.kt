package com.murat.androidcomponents

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.murat.androidcomponents.receivers.SomeBroadcastReceiver
import com.murat.androidcomponents.screens.SecondScreen
import com.murat.androidcomponents.ui.theme.AndroidComponentsTheme

class SecondActivity: ComponentActivity() {
    companion object{
        const val ARG_NAME = "arg_name"
        fun newIntent(context: Context, name: String): Intent{
           val intent =  Intent(context,SecondActivity::class.java)
            intent.putExtra(ARG_NAME,name)
            return intent
        }
    }
lateinit var receiver: SomeBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent?.extras?.getString(ARG_NAME)
        Log.d("checkData","SecondActivity: onCreate: argument: name: $name")

        receiver = SomeBroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }

        setContent {
            AndroidComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    SecondScreen()

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
         Log.d("checkData","SecondActivity: onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
         Log.d("checkData","SecondActivity: onDestroy")
        unregisterReceiver(receiver)
    }

    override fun onPause() {
        super.onPause()
         Log.d("checkData","SecondActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
         Log.d("checkData","SecondActivity: onStop")
    }

    override fun onResume() {
        super.onResume()
         Log.d("checkData","SecondActivity: onResume")
    }

    override fun onRestart() {
        super.onRestart()
         Log.d("checkData","SecondActivity: onRestart")
    }
}