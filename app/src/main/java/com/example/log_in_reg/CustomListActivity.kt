package com.example.log_in_reg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.log_in_reg.ui.theme.Log_in_regTheme

class CustomListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log_in_regTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    MyListcustom()

                }
            }
        }
    }

    data class FruitModel(val name: String, val image: Int)

    @Composable
    fun ListRow(model: FruitModel) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(Color.Cyan)
        ) {
            Image(
                painter = painterResource(id = model.image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)
            )
            Text(
                text = model.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }

    private val fruitsList = mutableListOf<FruitModel>().apply {

        add(FruitModel("apple", R.drawable.apple))
        add(FruitModel("orange", R.drawable.orange))
        add(FruitModel("mangoe", R.drawable.mangoe))
        add(FruitModel("banana", R.drawable.banana))
        add(FruitModel("strawberry", R.drawable.strawberry))
    }

    @Composable
    fun MyListcustom() {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            items(fruitsList) { model ->
                ListRow(model = model)
            }
        }


    }

    @Preview
    @Composable
    private fun customprev() {
        MyListcustom()
    }
}
