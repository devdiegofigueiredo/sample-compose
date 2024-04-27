package com.android.examplecompose.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.android.examplecompose.ui.theme.ExampleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppBar(title = { Text(text = "AppBar") })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: @Composable() () -> Unit) {
    val context = LocalContext.current.applicationContext

    Column {
        TopAppBar(
            title = title,
            actions = {
                IconButton(onClick = { Toast.makeText(context, "Add", Toast.LENGTH_LONG).show() }) {
                    Icon(Icons.Filled.Add, null)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.DarkGray,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExampleComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            AppBar(title = { Text(text = "AppBar") })
        }
    }
}