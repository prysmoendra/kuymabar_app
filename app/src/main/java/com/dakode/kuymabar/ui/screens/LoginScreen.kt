package com.dakode.kuymabar.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dakode.kuymabar.R

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    var passwordVisible by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Runner Illustration
            Image(
                painter = painterResource(id = R.drawable.svg_kuymabar),
                contentDescription = "Runner Illustration",
                modifier = Modifier.height(200.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Welcome Text
            Text(
                text = "Selamat Datang, Kuy Mabar!",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Email Field
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Email") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Kata Sandi") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = if (passwordVisible) painterResource(id = R.drawable.eye_show_svgrepo) else painterResource(id = R.drawable.eye_hide_svgrepo),
                            contentDescription = if (passwordVisible) "Tampilkan kata sandi" else "Sembunyikan kata sandi",
                            modifier = Modifier.size(28.dp).padding(end = 4.dp),
                            tint = Color.Gray
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Forgot Password
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = {
                        Log.d("LoginScreen", "Forgot password clicked")
                        Toast.makeText(context, "Forgot password clicked", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Text(
                        text = "Lupa kata sandi?",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Get Started Button
            Button(
                onClick = {
                    Log.d("LoginScreen", "Get started clicked")
                    Toast.makeText(context, "Get started clicked", Toast.LENGTH_SHORT).show()
                    // TODO: Navigate to main screen when authentication is implemented
                    // navController.navigate("main") { popUpTo("login") { inclusive = true } }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF97A00),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Get Started",
                    style = TextStyle(
                        fontSize = 16.sp,
                        letterSpacing = 1.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Or sign up with separator
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f))
                Text(
                    text = "atau",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                HorizontalDivider(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Social Sign Up Buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Google Button
                OutlinedButton(
                    onClick = {
                        Log.d("LoginScreen", "Google sign up clicked")
                        Toast.makeText(context, "Google sign up clicked", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(60.dp),
                    shape = RoundedCornerShape(50.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                ) {
//                    Icon(
//                        imageVector = Icons.Default.Home,
//                        contentDescription = "Google",
//                        modifier = Modifier.size(32.dp),
//                        tint = Color.Gray
//                    )
                    Image(
                        painter = painterResource(id = R.drawable.google_svgrepo),
                        contentDescription = "Google",
                        modifier = Modifier.size(32.dp)
                    )
                }

                // Facebook Button
                OutlinedButton(
                    onClick = {
                        Log.d("LoginScreen", "Facebook sign up clicked")
                        Toast.makeText(context, "Facebook sign up clicked", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(60.dp),
                    shape = RoundedCornerShape(50.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                ) {
//                    Icon(
//                        imageVector = Icons.Default.Person,
//                        contentDescription = "Facebook",
//                        modifier = Modifier.size(32.dp),
//                        tint = Color.Gray
//                    )
                    Image(
                        painter = painterResource(id = R.drawable.facebook_svgrepo),
                        contentDescription = "Facebook",
                        modifier = Modifier.size(32.dp)
                    )
                }

                // Apple Button
                OutlinedButton(
                    onClick = {
                        Log.d("LoginScreen", "Apple sign up clicked")
                        Toast.makeText(context, "Apple sign up clicked", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(60.dp),
                    shape = RoundedCornerShape(50.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                ) {
//                    Icon(
//                        imageVector = Icons.Default.Favorite,
//                        contentDescription = "Apple",
//                        modifier = Modifier.size(32.dp),
//                        tint = Color.Gray
//                    )
                    Image(
                        painter = painterResource(id = R.drawable.apple_svgrepo),
                        contentDescription = "Apple",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }
    }
}