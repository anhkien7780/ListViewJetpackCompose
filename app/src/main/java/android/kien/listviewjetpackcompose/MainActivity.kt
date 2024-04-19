package android.kien.listviewjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.kien.listviewjetpackcompose.ui.theme.ListViewJetpackComposeTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListViewJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColumnList(listItem = listItem)
                }
            }
        }
    }
}

@Composable
fun ItemRow(item: Item){
    Row( modifier = Modifier
        .fillMaxWidth()
    ){
        Image(painter = painterResource(id = item.image), contentDescription = "")
        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
        Column {
            Text(text = item.name)
            Text(text = item.price.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemRowPreview(){
    ItemRow(Item("Banana", 78.7, R.drawable.ic_launcher_background))
}


@Composable
fun ColumnList(listItem: List<Item>){
    LazyColumn {
        items(listItem){
            listItem -> Box(
            Modifier
                .padding(5.dp)
                .border(width = 1.dp, color = Color.Black)
            ){
                ItemRow(listItem)
            }
        }
    }
}

var listItem = mutableListOf(
    Item("Banana", 78.7, R.drawable.ic_launcher_background),
    Item("Apple", 78.7, R.drawable.ic_launcher_background),
    Item("Chicken", 78.7, R.drawable.ic_launcher_background),
    Item("Potato", 78.7, R.drawable.ic_launcher_background),
    Item("Orange", 78.7, R.drawable.ic_launcher_background),
    Item("Lime", 78.7, R.drawable.ic_launcher_background),
    Item("Apple Pine", 78.7, R.drawable.ic_launcher_background),
    Item("Pen", 78.7, R.drawable.ic_launcher_background)
    )

@Preview(showBackground = true)
@Composable
fun ColumnListPreview(){
    ColumnList(listItem)
}