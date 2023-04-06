package com.murat.androidcomponents

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.murat.androidcomponents.screens.ContactsScreen
import com.murat.androidcomponents.screens.SecondScreen
import com.murat.androidcomponents.ui.theme.AndroidComponentsTheme

class ContactsActivity: ComponentActivity() {

    companion object{
        const val ARG_NAME = "arg_name"
        fun newIntent(context: Context, name: String): Intent {
            val intent =  Intent(context,ContactsActivity::class.java)
            intent.putExtra(ARG_NAME,name)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent?.extras?.getString(ARG_NAME)
        Log.d("checkData","ContactsActivity: onCreate: argument: name: $name")

        setContent {
            AndroidComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    ContactsScreen()

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("checkData","ContactsActivity: onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checkData","ContactsActivity: onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.d("checkData","ContactsActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("checkData","ContactsActivity: onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d("checkData","ContactsActivity: onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("checkData","ContactsActivity: onRestart")
    }

}