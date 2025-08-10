package com.dakode.kuymabar.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dakode.kuymabar.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Navigation after delay
    LaunchedEffect(true) {
        delay(3000L) // 3 seconds
        navController.navigate("onboarding") {
            popUpTo("splash") { inclusive = true }
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.kuy_orange)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo Utama
            Image(
                painter = painterResource(id = R.drawable.splash_g_kuymabar),
                contentDescription = "Logo Aplikasi KuyMabar",
                modifier = Modifier.width(200.dp)
            )
            
            // Spasi Pemisah
            Spacer(modifier = Modifier.height(16.dp))
            
            // Teks Logo
            Image(
                painter = painterResource(id = R.drawable.splash_t_kuymabar),
                contentDescription = "Teks Logo KuyMabar",
                modifier = Modifier.width(250.dp)
            )
        }
    }
}