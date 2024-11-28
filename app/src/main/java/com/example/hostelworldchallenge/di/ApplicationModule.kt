package com.example.hostelworldchallenge.di

import com.example.hostelworldchallenge.feature_property_listing.data.repository.PropertyRepositoryImpl
import com.example.hostelworldchallenge.feature_property_listing.domain.repository.PropertyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {

    @Binds
    abstract fun provideMessagingRepository(
        propertyRepositoryImpl: PropertyRepositoryImpl,
    ): PropertyRepository
}