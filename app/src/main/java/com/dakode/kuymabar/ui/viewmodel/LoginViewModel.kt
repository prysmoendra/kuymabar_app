package com.dakode.kuymabar.ui.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Data class untuk merepresentasikan UI State
data class LoginUiState(
    val isLoading: Boolean = false,
    val loginSuccess: Boolean = false,      // Dipisah kembali
    val signUpSuccess: Boolean = false,     // State baru untuk sign up
    val errorMessage: String? = null
)

class LoginViewModel : ViewModel() {

    // Inisialisasi FirebaseAuth
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // StateFlow untuk mengelola state
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    // Fungsi untuk proses login
    fun loginUser(email: String, password: String) {
        if (!isValidInput(email, password)) return
        _uiState.update { it.copy(isLoading = true, errorMessage = null) }

        auth.signInWithEmailAndPassword(email.trim(), password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _uiState.update { it.copy(isLoading = false, loginSuccess = true) }
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = task.exception?.message ?: "Login gagal. Silakan coba lagi."
                        )
                    }
                }
            }
    }

    // Fungsi untuk proses Sign Up
    fun signUpUser(email: String, password: String) {
        if (!isValidInput(email, password)) return
        _uiState.update { it.copy(isLoading = true, errorMessage = null) }

        auth.createUserWithEmailAndPassword(email.trim(), password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _uiState.update { it.copy(isLoading = false, signUpSuccess = true) }
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = task.exception?.message ?: "Sign up gagal. Silakan coba lagi."
                        )
                    }
                }
            }
    }

    // Fungsi validasi private untuk menghindari duplikasi kode
    private fun isValidInput(email: String, password: String): Boolean {
        if (email.isBlank()) {
            _uiState.update { it.copy(errorMessage = "Email tidak boleh kosong") }
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()) {
            _uiState.update { it.copy(errorMessage = "Format email tidak valid") }
            return false
        }
        if (password.isBlank()) {
            _uiState.update { it.copy(errorMessage = "Password tidak boleh kosong") }
            return false
        }
        if (password.length < 6) {
             _uiState.update { it.copy(errorMessage = "Password minimal harus 6 karakter") }
            return false
        }
        return true
    }

    fun clearErrorMessage() {
        _uiState.update { it.copy(errorMessage = null) }
    }

    // Fungsi untuk mereset state setelah navigasi ditangani oleh UI
    fun onNavigationHandled() {
        _uiState.update { it.copy(loginSuccess = false, signUpSuccess = false, errorMessage = null) }
    }
}
