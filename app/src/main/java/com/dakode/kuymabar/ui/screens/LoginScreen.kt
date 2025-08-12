package com.dakode.kuymabar.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dakode.kuymabar.R
import com.dakode.kuymabar.ui.viewmodel.LoginViewModel


@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Handle navigation after successful login
    LaunchedEffect(key1 = uiState.loginSuccess) {
        if (uiState.loginSuccess) {
            Toast.makeText(context, "Login Berhasil!", Toast.LENGTH_SHORT).show()
            // Change "home" to your actual main screen route
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
            viewModel.onNavigationHandled() // Reset state setelah navigasi
        }
    }

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
                text = "Yuk Main Bareng!",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Email Field
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    viewModel.clearErrorMessage()
                },
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
                singleLine = true,
                isError = uiState.errorMessage?.contains("email", ignoreCase = true) == true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    viewModel.clearErrorMessage()
                },
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
                            painter = if (passwordVisible) painterResource(id = R.drawable.eye_hide_svgrepo) else painterResource(id = R.drawable.eye_show_svgrepo),
                            contentDescription = if (passwordVisible) "Sembunyikan kata sandi" else "Tampilkan kata sandi",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Gray
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                isError = uiState.errorMessage?.contains("password", ignoreCase = true) == true || uiState.errorMessage?.contains("sandi", ignoreCase = true) == true
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

            // Error Message Display
            if (uiState.errorMessage != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = uiState.errorMessage!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.fillMaxWidth()
                )
            }


            Spacer(modifier = Modifier.height(12.dp))

            // Get Started Button
            Button(
                onClick = {
                    viewModel.loginUser(email, password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF97A00),
                    contentColor = Color.White
                ),
                enabled = !uiState.isLoading
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(28.dp),
                        color = Color.White,
                        strokeWidth = 3.dp
                    )
                } else {
                    Text(
                        text = "Get Started",
                        style = TextStyle(
                            fontSize = 16.sp,
                            letterSpacing = 1.5.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Navigate to Sign Up
            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = { navController.navigate("signup") }) {
                Text(
                    text = "Belum punya akun? Daftar",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
