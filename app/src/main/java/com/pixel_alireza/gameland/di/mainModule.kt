package com.pixel_alireza.gameland.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.pixel_alireza.gameland.data.local.chatDatabase.ChatDao
import com.pixel_alireza.gameland.data.local.chatDatabase.ChatDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.websocket.WebSockets
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object mainModule {

    @Provides
    @Singleton
    fun providesClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging)
            install(WebSockets)
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }

    @Provides
    @Singleton
    fun provideSharePref(context: Application): SharedPreferences {
        return context.getSharedPreferences("tokenData", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideChatDatabase(context: Application): ChatDao {
        val database =
            Room.databaseBuilder(context, ChatDatabase::class.java, "chatDatabase").build()
        return database.chatDao()
    }

}