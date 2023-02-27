package com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.util.SharedViewModel
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.util.UserData

@Composable
fun AddDataScreen(
    navController: NavController, sharedViewModel: SharedViewModel
) {
    var id: String by remember { mutableStateOf("") }
    var employeeId: String by remember { mutableStateOf("") }
    var name: String by remember { mutableStateOf("") }
    var department: String by remember { mutableStateOf("") }
    var manager: String by remember { mutableStateOf("") }
    var designation: String by remember { mutableStateOf("") }
    var userName: String by remember { mutableStateOf("") }
    var emailId: String by remember { mutableStateOf("") }
    var location: String by remember { mutableStateOf("") }
    var dateOfBirth: String by remember { mutableStateOf("") }
    var gender: String by remember { mutableStateOf("") }
    var bloodGroup: String by remember { mutableStateOf("") }
    var maritalStatus: String by remember { mutableStateOf("") }
    var personalEmail: String by remember { mutableStateOf("") }
    var phoneNumber: String by remember { mutableStateOf("") }
    var specilization: String by remember { mutableStateOf("") }
    var teamLead: String by remember { mutableStateOf("") }
    var subcompanyName: String by remember { mutableStateOf("") }
    var companyName: String by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {

        //back button
        Row(
            modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
//            IconButton(onClick = { navController.popBackStack() }) {
//                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
//            }
        }
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //userID
            OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = id, onValueChange = {
                id = it
            }, label = {
                Text(text = "id")
            })

            //employeeId
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = employeeId,
                onValueChange = {
                    employeeId = it
                },
                label = {
                    Text(text = "EmployeeId")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            //name
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = { name = it },
                label = {
                    Text(text = "name")
                })

            //department
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = department,
                onValueChange = { department = it },
                label = {
                    Text(text = "department")
                })

            //manger
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = manager,
                onValueChange = { manager = it },
                label = {
                    Text(text = "Manager")
                })

            //designation
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                value = designation,
                onValueChange = { designation = it },
                label = {
                    Text(text = "designation")
                })

            //Save Button
            Button(modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth(), onClick = {
                val userData = UserData (
                    id = id,
                    name = name ,
                    department = department,
                    manager = manager,
                    designation = designation
                )
                sharedViewModel.saveData(userData= userData,context = context)
                }) {
                Text(text = "Save")
            }

        }
    }
}




