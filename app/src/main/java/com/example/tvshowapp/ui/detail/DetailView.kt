package com.example.tvshowapp.ui.detail

import android.os.Bundle
import android.webkit.WebView
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.rememberAsyncImagePainter
import com.example.tvshowapp.network.TvShowType
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun DetailView(show:TvShowType, navController: NavController,viewModel: DetailViewModel=viewModel()){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.size(10.dp))
            Image(painter = rememberAsyncImagePainter(show.image?.original),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .height(550.dp),
            contentScale = ContentScale.Crop)
            Text(text = show.name, fontSize = 30.sp)
            Spacer(modifier = Modifier.height(10.dp))
        }
        Column(modifier=Modifier.padding(horizontal = 15.dp)) {
            Text(text = "Premiere date: ", fontWeight = FontWeight.Bold)
            Text(text = show.premiered)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Language: ",fontWeight = FontWeight.Bold)
            Text(text = show.language)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Type: ",fontWeight = FontWeight.Bold)
            Text(text = show.type)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Genres: ",fontWeight = FontWeight.Bold)
            Text(text = viewModel.getGenresString(show))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Summary:",fontWeight = FontWeight.Bold)
            AndroidView(
                factory = { context -> TextView(context) },
                update = { it.text = HtmlCompat.fromHtml(show.summary, HtmlCompat.FROM_HTML_MODE_COMPACT) }
            )
            Button(onClick = {
                viewModel.deleteShow(show = show)
                navController.navigate("Favourites")

            }, modifier= Modifier.fillMaxWidth(9.5f)) {
                Text(text = "Delete from favourites!")
            }
        }

    }

}