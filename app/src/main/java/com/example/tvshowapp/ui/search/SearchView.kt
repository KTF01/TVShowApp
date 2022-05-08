package com.example.tvshowapp.ui.search

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.tvshowapp.network.TvShowType
import com.google.gson.Gson

@Composable
fun SearchView(navController: NavController,searchViewModel: SearchViewModel = viewModel()){
    val showDialogState: Boolean by searchViewModel.showDialog.collectAsState()
    val loading:Boolean by searchViewModel.isLoading.collectAsState()
    SimpleAlertDialog(
        show = showDialogState,
        searchViewModel = searchViewModel,
        navController = navController
    )
    Column(modifier = Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value = text,
            onValueChange = {newText->
                text = newText
                searchViewModel.onTextBoxTextChanged(newText.text)
        })
        if(loading) CircularProgressIndicator() else
        LazyColumn(modifier = Modifier.fillMaxHeight(0.95f)){
            items(searchViewModel.loadedShows){show->
                ListItem(show = show, searchViewModel)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

}

@Composable
fun ListItem(show: TvShowType, searchViewModel: SearchViewModel){

    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .fillMaxWidth(0.7f)
        .clickable {
            searchViewModel.onOpenDialogClicked(show)
        }){
            Image(painter = rememberAsyncImagePainter(show.image?.medium),
                contentDescription = "show-image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth())


        Text(text = show.name, fontSize= 20.sp,
            style = TextStyle(color = Color.White,
                textAlign = TextAlign.Center,
                shadow = Shadow(color = Color.Black, offset = Offset(1f,1f), blurRadius = 1f )
            )
        )

    }
}

@Composable
fun SimpleAlertDialog(
    show: Boolean,
    searchViewModel: SearchViewModel,
    navController:NavController
) {
    if(show){
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                TextButton(onClick = {
                    searchViewModel.onDialogConfirm()
                    navController.navigate("Favourites")
                })
                { Text(text = "YES") }
            },
            dismissButton = {
                TextButton(onClick = {searchViewModel.onDialogDismiss()})
                { Text(text = "NO") }
            },
            text = { Text(text = "Add this show to your favourites?") },
            title = { searchViewModel.selectedShow?.name?.let { Text(text = it) } }
        )
    }
}