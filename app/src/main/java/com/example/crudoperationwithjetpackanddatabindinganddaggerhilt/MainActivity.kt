package com.example.crudoperationwithjetpackanddatabindinganddaggerhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.nav.NavGraph
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.ui.theme.CRUDOperationWithJetPackAndDataBindingAndDaggerHiltTheme
import com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.util.SharedViewModel

class MainActivity : ComponentActivity() {

private lateinit var navController: NavController
private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CRUDOperationWithJetPackAndDataBindingAndDaggerHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    navController = rememberNavController()
                    NavGraph(navController = navController , sharedViewModel = sharedViewModel )

                }
            }
        }
    }
}

