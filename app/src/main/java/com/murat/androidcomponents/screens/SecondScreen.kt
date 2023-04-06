package com.murat.androidcomponents.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.murat.androidcomponents.services.CountService
import com.murat.androidcomponents.ui.theme.AndroidComponentsTheme

@Composable
fun SecondScreen() {

    val context= LocalContext.current
    val activity = if (context is Activity) context else null
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Activity screen")
        Button(onClick = {
           activity?.finish()
        }
        ) {
            Text(text = "Go to First Activity")
        }
        Row(modifier = Modifier.padding(top = 10.dp)) {
            
            Button(onClick = {
                activity?.startService(Intent(context,CountService::class.java))
            }) {
                Text(text = "start service")
            }

            Button(onClick = {
                activity?.stopService(Intent(context,CountService::class.java))
            }) {
                Text(text = "stop service")
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview(){
    AndroidComponentsTheme {
        SecondScreen()

    }
}