# KuyMabar - Aplikasi Olahraga Bersama

Aplikasi Android untuk mencari dan bergabung dengan venue olahraga favorit.

## Fitur Utama

### 🏠 Struktur Navigasi Utama
- **MainScreen**: Scaffold dengan BottomAppBar dan FloatingActionButton
- **HomeScreen (Lobi)**: Halaman utama dengan greeting, kategori olahraga, dan rekomendasi venue
- **Jelajah**: Halaman untuk menjelajahi venue (placeholder)
- **Jadwal**: Halaman untuk mengatur jadwal (placeholder)
- **Profil**: Halaman profil pengguna (placeholder)

### 🎨 Desain UI
- Material Design 3 dengan tema yang konsisten
- Bottom Navigation Bar dengan 4 item utama + FAB
- Greeting header yang dinamis berdasarkan waktu
- Kategori olahraga dengan state selection
- Card-based venue list dengan informasi lengkap

### 🏗️ Arsitektur
- **MVVM Pattern** dengan ViewModel dan Repository
- **Hilt Dependency Injection** untuk dependency management
- **Jetpack Compose** untuk UI modern
- **Navigation Component** untuk navigasi antar screen

## Struktur File

```
app/src/main/java/com/dakode/kuymabar/
├── ui/screens/
│   ├── MainScreen.kt          # Scaffold utama dengan BottomAppBar
│   ├── HomeScreen.kt          # Halaman Lobi (Home)
│   ├── LoginScreen.kt         # Halaman Login
│   ├── SignUpScreen.kt        # Halaman Sign Up
│   ├── OnboardingScreen.kt    # Halaman Onboarding
│   └── SplashScreen.kt        # Halaman Splash
├── ui/viewmodel/
│   ├── HomeViewModel.kt       # ViewModel untuk HomeScreen
│   └── LoginViewModel.kt      # ViewModel untuk Login/SignUp
├── data/
│   └── VenueRepository.kt     # Repository untuk data venue
└── model/
    └── SportVenue.kt          # Data class untuk venue olahraga
```

## Navigasi

```
Splash → Onboarding → Login/SignUp → MainApp
                                    ├── Lobi (HomeScreen)
                                    ├── Jelajah
                                    ├── Jadwal
                                    └── Profil
```

## Fitur HomeScreen (Lobi)

1. **GreetingHeader**: Sapaan dinamis + notifikasi icon
2. **CategoriesList**: Kategori olahraga dengan horizontal scroll
3. **VenueListSection**: Rekomendasi venue dengan card design

## Cara Menjalankan

1. Clone repository
2. Buka di Android Studio
3. Sync project dengan Gradle
4. Run aplikasi di emulator atau device

## Dependencies

- Jetpack Compose
- Material Design 3
- Hilt (Dependency Injection)
- Navigation Component
- ViewModel & LiveData
- Coroutines & Flow

## Status Pengembangan

✅ **Selesai:**
- Struktur navigasi utama
- HomeScreen dengan desain modern
- BottomAppBar dengan FAB
- Integrasi dengan arsitektur MVVM

🔄 **Dalam Pengembangan:**
- Implementasi halaman Jelajah
- Implementasi halaman Jadwal
- Implementasi halaman Profil
- Fitur filter venue berdasarkan kategori 