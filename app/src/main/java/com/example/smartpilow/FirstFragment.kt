package com.example.smartpilow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseUser

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

//    override fun onStart() {
//        val currentUser = auth.currentUser
//        if(currentUser!=null){
//            if(currentUser.email == "test1@gmail.com"){
//                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//            }
//        }
//
//        super.onStart()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    val editTextEmail =     view.findViewById<EditText>(R.id.editText_email)
     val editTextPassword =    view.findViewById<EditText>(R.id.editText_password)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            if(editTextEmail.text.isEmpty() || editTextPassword.text.isEmpty()){
                Toast.makeText(context, "Enter email or password",
                    Toast.LENGTH_LONG).show()
            }else{
                signIn(email = editTextEmail.text.toString(), password = editTextPassword.text.toString())
            }

        }
    }

    private fun signIn(email: String, password: String) {
        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->

                if(task.isSuccessful){
                    val user = auth.currentUser
                    if(user!=null){
                        if(user.email=="test1@gmail.com"){
                            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                        }else{
                            findNavController().navigate(R.id.action_FirstFragment_to_emptyFragment)
                        }
                    }

                } else{
                    Toast.makeText(context, "Authentication failed.",
                        Toast.LENGTH_LONG).show()
                }
            }
//        auth.signInWithEmailAndPassword(email, password)
//
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d("TAG", "signInWithEmail:success")
//                    val user = auth.currentUser
//                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w("TAG", "signInWithEmail:failure", task.exception)
//                    Toast.makeText(context, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show()
//                    //updateUI(null)
//                }
//            }
        // [END sign_in_with_email]
    }
}


