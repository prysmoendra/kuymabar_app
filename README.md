# KuyMabar - Aplikasi Sosial Olahraga

KuyMabar adalah aplikasi Android yang dibangun menggunakan Kotlin, Jetpack Compose, dan Material Design 3 untuk menghubungkan pemain olahraga dan memfasilitasi pertandingan persahabatan.

## Fitur

### Onboarding Flow
Aplikasi memiliki alur onboarding yang terdiri dari 3 layar:

1. **SplashScreen** - Menampilkan video loading dan gambar statis selama 5 detik
2. **OnboardingScreen** - 3 halaman perkenalan dengan fitur:
   - Horizontal pager untuk swipe antar halaman
   - Indikator halaman aktif
   - Tombol "Lewati" dan "Selanjutnya"/"Mulai"
3. **LoginScreen** - UI login modern dengan email/password dan social sign-up

## Teknologi yang Digunakan

- **Kotlin** - Bahasa pemrograman utama
- **Jetpack Compose** - UI toolkit modern untuk Android
- **Material Design 3** - Design system terbaru dari Google
- **Navigation Compose** - Navigasi antar layar
- **Horizontal Pager** - Untuk swipe antar halaman onboarding
- **ExoPlayer (Media3)** - Untuk pemutaran video

## Struktur Proyek

```
app/src/main/java/com/dakode/kuymabar/
├── MainActivity.kt                 # Activity utama dengan NavHost
└── ui/screens/
    ├── SplashScreen.kt            # Layar splash dengan video dan gambar statis
    ├── OnboardingScreen.kt        # Layar onboarding dengan 3 halaman
    └── LoginScreen.kt             # Layar login modern dengan email/password dan social sign-up
```

## Cara Menjalankan

1. Clone repository ini
2. Buka proyek di Android Studio
3. Sync gradle files
4. Run aplikasi di emulator atau device

## Build Requirements

- Android Studio Hedgehog atau lebih baru
- Kotlin 1.9.22
- Compose Compiler 1.5.8
- Minimum SDK: 24
- Target SDK: 35

## Dependencies

- `androidx.compose:compose-bom:2024.10.01`
- `androidx.navigation:navigation-compose:2.7.7`
- `androidx.compose.material3:material3`
- `androidx.compose.foundation:foundation`
- `androidx.media3:media3-exoplayer:1.3.1`
- `androidx.media3:media3-ui:1.3.1`

## Alur Navigasi

```
SplashScreen (5 detik) → OnboardingScreen → LoginScreen
```

- SplashScreen otomatis navigasi ke OnboardingScreen setelah 5 detik
- OnboardingScreen memiliki 3 halaman yang bisa di-swipe
- Tombol "Lewati" atau "Mulai" di halaman terakhir navigasi ke LoginScreen
- LoginScreen menampilkan form login modern dengan email/password dan social sign-up buttons

## Status Pengembangan

✅ **Selesai:**
- Setup proyek dengan Jetpack Compose
- Implementasi SplashScreen
- Implementasi OnboardingScreen dengan HorizontalPager
- Implementasi LoginScreen
- Navigasi antar layar
- Material Design 3 theming

🔄 **Dalam Pengembangan:**
- Implementasi Firebase Authentication
- Fitur registrasi pengguna
- Fitur utama aplikasi

## Kontribusi

Silakan buat pull request untuk kontribusi atau laporkan bug melalui issues.

## Lisensi

Proyek ini menggunakan lisensi MIT. 