package com.dakode.kuymabar.data

import com.dakode.kuymabar.model.SportVenue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

// Definisikan interface untuk kemudahan testing
interface VenueRepository {
    suspend fun getVenues(): List<SportVenue>
}

class VenueRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : VenueRepository {
    override suspend fun getVenues(): List<SportVenue> {
        return try {
            firestore.collection("sport_venues")
                .get()
                .await()
                .toObjects(SportVenue::class.java)
        } catch (e: Exception) {
            // Jika terjadi error, kembalikan list kosong atau lempar exception
            // Untuk sekarang, kita log error dan kembalikan list kosong
            e.printStackTrace()
            emptyList()
        }
    }
}
