package com.murat.androidcomponents.screens

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.murat.androidcomponents.ContactsActivity
import com.murat.androidcomponents.SecondActivity
import com.murat.androidcomponents.ui.theme.AndroidComponentsTheme

@Composable
fun FirstScreen(){
val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Activity screen")
        Button(onClick = {
            val intent1 =Intent(context, SecondActivity::class.java)
            val intent2 = SecondActivity.newIntent(context = context, name = "Murat")
            context.startActivity(intent2)
        }
        ) {
            Text(text = "Go to Second Activity")

        }

        Button(onClick = {

            val intent2 = ContactsActivity.newIntent(context = context, name = "Murat")
            context.startActivity(intent2)
        }
        ) {
            Text(text = "Go to Contact Activity")

        }

    }
}


@Preview(showBackground = true)
@Composable
fun FirstScreenPreview(){
    AndroidComponentsTheme {
        FirstScreen()
        
    }
}