package com.example.month7hw1.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.month7hw1.data.db.database.WayDao
import com.example.month7hw1.data.db.database.WayDatabase
import com.example.month7hw1.data.repositories.WayRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, RoomDatabase::class.java,
        "ways"
    ).build()

    @Provides
    fun provideWayDao(wayDatabase: WayDatabase) =
        wayDatabase.getWayDao()

    @Provides
    fun provideWayRepository(wayDao: WayDao)=
        WayRepositoryImpl(wayDao)
}