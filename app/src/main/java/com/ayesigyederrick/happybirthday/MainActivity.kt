package com.ayesigyederrick.happybirthday

import android.media.Image
import android.os.Bundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayesigyederrick.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithText(name = "Derrick", "All the Best from Cassper")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(name:String, from: String){
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(name = name, from = from)
    }

}

@Composable
fun BirthdayGreetingWithText(name: String, from: String){
    Column {
        Text(text = "Happy Birthday  $name",
            fontSize = 36.sp,
            modifier = Modifier.fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth().wrapContentWidth(align = Alignment.End)
                .padding(start = 16.dp, end = 16.dp)
                .background(color = Color.Green)
            )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage(stringResource(R.string.receiver_name), stringResource(R.string.from_text))
    }
}