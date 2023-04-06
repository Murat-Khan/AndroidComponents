package com.murat.androidcomponents.screens

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.provider.ContactsContract
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat

import com.murat.androidcomponents.ui.theme.AndroidComponentsTheme

@Composable
fun ContactsScreen() {
    val context = LocalContext.current
    val activity = if (context is Activity) context else null
    val list = mutableListOf<String>()
    checkPermission(activity = activity, context = context) {
        activity?.let { getContacts(activity).let { list.addAll(it) } }
    }
    Log.d("checkData", "ContactsScreen: ${list.size} ")
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(vertical = 30.dp)
    ) {
        Text(text = "Contacts Activity screen")

        LazyColumn {
            items(list) { contactNum ->
                ContactItems(contactNum = contactNum)

            }
        }
    }
}

@Composable
fun ContactItems(contactNum: String) {

    Text(
        text = contactNum,
        fontSize = 24.sp,
        color = Color.Green,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .background(color = Color.DarkGray)
            .padding(horizontal = 24.dp)

    )
}

fun checkPermission(activity: Activity?, context: Context, success: () -> Unit) {

    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_CONTACTS
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        activity?.let {
            ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.READ_CONTACTS), 1)
        }
    } else {
        success()
    }
}

fun getContacts(activity: Activity?): List<String> {
    val list: MutableList<String> = ArrayList()
    val projection = arrayOf(ContactsContract.Data.DISPLAY_NAME_PRIMARY)
    val cursor = activity?.contentResolver?.query(
        ContactsContract.Data.CONTENT_URI,
        projection,
        null, null, null
    )

    if (cursor != null && cursor.moveToFirst()) {
        for (j in 0 until cursor.count) {
            for (i in 0 until cursor.columnCount) {
                list.add(cursor.getString(i))
                cursor.moveToNext()
            }
        }

        cursor.close()
    }


    return list.toList()
}

@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview() {
    AndroidComponentsTheme {
        ContactsScreen()

    }
}