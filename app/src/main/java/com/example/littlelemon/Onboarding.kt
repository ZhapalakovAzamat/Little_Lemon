package com.example.littlelemon

import android.content.Context
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Onboarding(navController: NavController){
    val context = LocalContext.current
    var firstName by rememberSaveable { mutableStateOf("")}
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "Logo"
            , modifier = Modifier
                .size(400.dp, 100.dp)
                .fillMaxSize()
                .padding(20.dp)
        )
        Box(
            modifier = Modifier
                .background(Color(0xFF485E57))
                .padding(0.dp, 48.dp, 0.dp, 48.dp)
                .fillMaxWidth()

        ){
            Text(
                text = "Let's get to know you"
                , fontSize = 30.sp
                , fontWeight = FontWeight.Normal
                , color = Color.White
                , textAlign = TextAlign.Center
                , modifier = Modifier
                    .fillMaxWidth()

            )
        }
        Box(modifier = Modifier
            .size(400.dp, 75.dp)
        ) {
            Text(
                text = "Personal information"
                , fontSize = 20.sp
                , fontWeight = FontWeight.SemiBold
                , textAlign = TextAlign.Start
                , modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 50.dp, start = 10.dp
                    )
            )
        }
        Text(
            text = "First name"
            , fontSize = 12.sp
            , fontWeight = FontWeight.SemiBold
            , textAlign = TextAlign.Start
            , modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp)
        )
        OutlinedTextField(
            value = firstName
            , onValueChange = {
                firstName = it
            }
            , textStyle = TextStyle(fontSize = 25.sp)
            , shape = RoundedCornerShape(10.dp)
            , modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        Text(
            text = "Last name"
            , fontSize = 12.sp
            , fontWeight = FontWeight.SemiBold
            , textAlign = TextAlign.Start
            , modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp)
        )
        OutlinedTextField(
            value = lastName
            , onValueChange = {
                lastName = it
            }
            , textStyle = TextStyle(fontSize = 25.sp)
            , shape = RoundedCornerShape(10.dp)
            , modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        Text(
            text = "Email"
            , fontSize = 12.sp
            , fontWeight = FontWeight.SemiBold
            , textAlign = TextAlign.Start
            , modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 10.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            }
            , textStyle = TextStyle(fontSize = 25.sp)
            , shape = RoundedCornerShape(10.dp)
            , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            , modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        Button(
            onClick = { 
                if (
                    firstName.isBlank()
                    && lastName.isBlank()
                    && email.isBlank()
                ){
                    Toast.makeText(
                        context, context.getString(R.string.registration_unsuccessful)
                    , Toast.LENGTH_SHORT
                    ).show()
                } else {
                    saveToSharedPreferences(context
                        , firstName
                        , lastName
                        , email
                    )
                    Toast.makeText(context, context.getString(R.string.registration_successful),
                    Toast.LENGTH_LONG
                ).show()
                navController.navigate(Destinations.Home.route)
                }
            }
            , border = BorderStroke(1.dp, Color(0xFFF47836))
            , shape = RoundedCornerShape(10.dp)
            , colors = ButtonDefaults.buttonColors(Color(0xFFDCAB3B))
            , modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Register", color = Color.Black)
        }
    }
}

fun saveToSharedPreferences(
    context: Context
    , firstName: String
    , lastName: String
    , email: String
    ){
    val sharedP = context.getSharedPreferences("userData", Context.MODE_PRIVATE) ?: return
    with(sharedP.edit()) {
        putString("firstName", firstName)
        putString("lastName", lastName)
        putString("email", email)
        apply()
    }
}

@Preview(showSystemUi = true)
@Composable
fun OnboardingPrev(){
    val navController = rememberNavController()
    Onboarding(navController)
}

