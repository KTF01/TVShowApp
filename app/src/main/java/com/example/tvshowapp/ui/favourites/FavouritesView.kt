package com.example.tvshowapp.ui.favourites

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.tvshowapp.network.TvShowType
import com.google.gson.Gson

@Composable
fun FavouritesView(navController: NavController,viewModel:FavouritesViewModel = viewModel()){
    Column(
        modifier = Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Title("My favourite TV shows")
        FavouritesList(shows = viewModel.favouriteShows, navController = navController)
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = {
                //viewModel.loadShows()
                navController.navigate("Search")
            }) {
            Text(text = "Add")
        }
    }
}

    @Composable
    fun Title(title:String){
        Text(text = title, fontSize = 35.sp, textAlign = TextAlign.Center)
    }

    @Composable
    fun FavouritesList(shows:List<TvShowType>, navController: NavController){
        LazyColumn(modifier = Modifier.fillMaxHeight(0.93f)){
            items(shows){show->
                ListItem(show = show, navController = navController)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

    @Composable
    fun ListItem(show:TvShowType, navController: NavController){
        val toast = Toast.makeText(LocalContext.current, show.name, Toast.LENGTH_SHORT)
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth(0.7f).clickable {
            toast.show();
            val gson = Gson()
            navController.navigate("Detail/show={show}".replace("{show}", gson.toJson(show).replace("/","{slash}")))
        }){
            Image(painter = rememberAsyncImagePainter(show.image?.medium),
                contentDescription = "Image 1",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth())
            Text(text = show.name, fontSize= 20.sp,
                style = TextStyle(color = Color.White,
                textAlign = TextAlign.Center,
                shadow = Shadow(color = Black, offset = Offset(1f,1f), blurRadius = 1f )))
        }
    }
