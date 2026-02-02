package com.example.myapplication.view

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.Routes
import com.example.myapplication.repositry.Repositry
import com.example.myapplication.viewModel.SignupLoginViewModel


@Composable
fun Signup(navController: NavController,appRepo: Repositry) {
    var name:String by remember { mutableStateOf("") }
    var mobileNo:String by remember { mutableStateOf("") }
    var password:String by remember { mutableStateOf("") }

    var context = LocalContext.current;


   var viewModel: SignupLoginViewModel = viewModel();

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(value=name, onValueChange = { it->
                name= it
            }, label = {
                Text("Name")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))
            OutlinedTextField(value=mobileNo, onValueChange = { it->
                if(it.length<=10)
                    mobileNo= it
            }, label = {
                Text("Mobile Number")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            OutlinedTextField(value=password, onValueChange = { it->
                password= it
            }, label = {
                Text("Password")
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
            Button(onClick = {
                if(viewModel.createUser(name,mobileNo,password,appRepo))
                    navController.navigate(Routes.LoginPage.route)
                else
                {
                    Toast.makeText(context,"Error Occured",Toast.LENGTH_LONG).show();
                }
            }) {
                Text("Signup")
            }
            Spacer(Modifier.height(70.dp))
            Text("Already a User", color = Color.DarkGray)
            Button(onClick = {
                navController.navigate(Routes.LoginPage.route)
            }) {
                Text("Login")
            }
        }


    }

}