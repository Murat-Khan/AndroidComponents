package com.murat.androidcomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.murat.androidcomponents.screens.FirstScreen
import com.murat.androidcomponents.ui.theme.AndroidComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("checkData","MainActivity: onCreate")
        setContent {
            AndroidComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    FirstScreen()

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
         Log.d("checkData","MainActivity: onStart")

    }

    override fun onResume() {
        super.onResume()
         Log.d("checkData","MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
         Log.d("checkData","MainActivity: onPause")

    }

    override fun onDestroy() {
        super.onDestroy()
         Log.d("checkData","MainActivity: onDestroy")
    }

    override fun onStop() {
        super.onStop()
         Log.d("checkData","MainActivity: onStop")
    }
}

