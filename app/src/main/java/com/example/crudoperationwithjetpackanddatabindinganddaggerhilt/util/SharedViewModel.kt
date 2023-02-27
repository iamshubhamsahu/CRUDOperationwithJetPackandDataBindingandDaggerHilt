package com.example.crudoperationwithjetpackanddatabindinganddaggerhilt.util

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    fun saveData(userData: UserData, context: Context) = CoroutineScope(Dispatchers.IO).launch {
        val firestoreRef = Firebase.firestore.collection("employee").document(userData.id)

        try {
            firestoreRef.set(userData).addOnSuccessListener {
                Toast.makeText(context,"Succesfully Saved Data", Toast.LENGTH_SHORT).show()
            }

        }catch (e:Exception){
            Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()
        }
    }

    fun retreiveData(
        id:String,
        context: Context,
        data: (UserData) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {
        val firestoreRef = Firebase.firestore.collection("employee").document(id)

        try {
            firestoreRef.get().addOnSuccessListener {
            if(it.exists()){
                    val userData = it.toObject<UserData>()
                if (userData != null) {
                    data(userData)
                }
                else{
                    Toast.makeText(context,"No User Data found", Toast.LENGTH_SHORT).show()
                }
            }
            }

        }catch (e:Exception){
        Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteData(id :String, context: Context,navController: NavController) = CoroutineScope(Dispatchers.IO).launch {
        val firestoreRef = Firebase.firestore.collection("employee").document(id)

        try {
            firestoreRef.delete().addOnSuccessListener {
                Toast.makeText(context,"Succesfully Deleted Data", Toast.LENGTH_SHORT).show()
                navController.popBackStack()
            }

        }catch (e:Exception){
            Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()
        }
    }
}