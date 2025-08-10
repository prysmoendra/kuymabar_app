package com.dakode.kuymabar.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dakode.kuymabar.R
import com.dakode.kuymabar.model.OnboardingItem
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.launch
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingScreen(navController: NavController) {
    val items = listOf(
        OnboardingItem(
            title = "Cari Lawan Sparing?",
            description = "Posting ajakan tanding dan temukan lawan yang sepadan untuk timmu.",
            image = R.drawable.cari_lawan_kuymabar
        ),
        OnboardingItem(
            title = "Butuh Tim atau Pemain?",
            description = "Gabung dengan tim yang ada atau rekrut anggota baru untuk melengkapi squad-mu.",
            image = R.drawable.butuh_pemain_kuymabar
        ),
        OnboardingItem(
            title = "Atur Jadwal & Mulai Bermain!",
            description = "Chat, atur jadwal, dan mulai pertandingan persahabatanmu.",
            image = R.drawable.atur_jadwal_kuymabar
        )
    )
    val pagerState = rememberPagerState(pageCount = { items.size })
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            === JIKA MEMAKAI TEXT ====
//            Text(text = "KuyMabar",
//                style = MaterialTheme.typography.titleMedium,
//                fontWeight = FontWeight.Bold
//            )
            Image(
                painter = painterResource(id = R.drawable.svg_top_nav),
                contentDescription = "KuyMabar Logo",
                modifier = Modifier.size(120.dp)
            )
            TextButton(onClick = { navController.navigate("login") }) {
                Text(
                    text ="Skip",
                    color = Color(0xFFF97A00),
                    style = TextStyle(
                        letterSpacing = 1.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        // Main Content
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = items[page].image),
                        contentDescription = items[page].title,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Spacer(Modifier.height(32.dp))
                    Text(
                        text = items[page].title,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = items[page].description,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Footer
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                pageCount = items.size,
                activeColor = Color(0xFFF97A00),
                inactiveColor = Color.LightGray
            )
            Button(
                onClick = {
                    if (pagerState.currentPage < items.size - 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        navController.navigate("login")
                    }
                },
                modifier = Modifier
                    .width(150.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF97A00),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = if (pagerState.currentPage < items.size - 1) "Next" else "Mulai",
                    style = TextStyle(
                        letterSpacing = 1.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}