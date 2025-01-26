package com.example.littlelemon

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth()
        , verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
            , modifier = Modifier
                .fillMaxWidth(1f)
        ){
            Image(
                painter = painterResource(id = R.drawable.logo)
                , contentDescription = "Logo"
                , modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(80.dp)
                    .padding(start = 50.dp, end = 5.dp)
            )
            Image(painter = painterResource(id = R.drawable.profile)
                , contentDescription = "Profile"
                , modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(end = 10.dp)
                    .clickable { navController.navigate(Destinations.Profile.route) }
            )
        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPrev(){
    val navController = rememberNavController()
    HomeScreen(navController)
}