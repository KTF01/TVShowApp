package com.example.tvshowapp.ui.favourites

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tvshowapp.R

class FavouritesView: ComponentActivity(){

    private val viewModel: FavouritesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Title("TV Show app")
                FavouritesList(shows = viewModel.testShows)
                Button(
                    modifier = Modifier.fillMaxWidth(0.7f),
                    onClick = {
                    viewModel.loadShows()
                }) {
                    Text(text = "Add")
                }
            }

        }
    }

    @Composable
    fun Title(title:String){
        Text(text = title, fontSize = 35.sp, textAlign = TextAlign.Center)
    }

    //TODO: tvShow
    @Composable
    fun FavouritesList(shows:List<String> ){
        LazyColumn(modifier = Modifier.fillMaxHeight(0.93f)){
            items(shows){show->
                ListItem(show = show)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

    @Composable
    fun ListItem(show:String){
        val toast = Toast.makeText(LocalContext.current, show, Toast.LENGTH_SHORT)
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth(0.7f).clickable {
            toast.show();
        }){
            Image(painter = painterResource(R.drawable.profile_picture),
                contentDescription = "Image 1",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth())
            Text(text = show, fontSize= 20.sp,
                style = TextStyle(color = Color.White,
                textAlign = TextAlign.Center,
                shadow = Shadow(color = Black, offset = Offset(1f,1f), blurRadius = 1f )))
        }
    }

    @Preview
    @Composable
    fun PreviewListItem() {
        ListItem("Android")
    }
}