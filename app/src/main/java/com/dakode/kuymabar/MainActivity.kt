package com.dakode.kuymabar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dakode.kuymabar.ui.screens.LoginScreen
import com.dakode.kuymabar.ui.screens.OnboardingScreen
import com.dakode.kuymabar.ui.screens.SplashScreen
import com.dakode.kuymabar.ui.theme.KuyMabarTheme
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KuyMabarTheme {
                // Contoh penggunaan textAlign = TextAlign.Justify
                // Text(
                //     text = "Ini adalah paragraf panjang yang saya ingin ratakan kanan-kiri agar terlihat seperti artikel majalah...",
                //     style = MaterialTheme.typography.bodyLarge, // Mengambil style dari tema
                //     textAlign = TextAlign.Justify // Menerapkan Justify secara manual
                // )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    
                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        composable("splash") {
                            SplashScreen(navController)
                        }
                        composable("onboarding") {
                            OnboardingScreen(navController)
                        }
                        composable("login") {
                            LoginScreen(navController)
                        }
                    }
                }
            }
        }
    }
}