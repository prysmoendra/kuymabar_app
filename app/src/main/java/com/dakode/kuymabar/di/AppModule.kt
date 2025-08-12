package com.dakode.kuymabar.di

import com.dakode.kuymabar.data.VenueRepository
import com.dakode.kuymabar.data.VenueRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideVenueRepository(firestore: FirebaseFirestore): VenueRepository {
        return VenueRepositoryImpl(firestore)
    }
}