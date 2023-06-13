package com.pixel_alireza.gameland.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pixel_alireza.gameland.data.local.ProductDatabase.ProductDao
import com.pixel_alireza.gameland.data.local.ProductDatabase.ProductDatabase
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
    fun provideChatDatabase(context: Application): ProductDao {

        val migration1to2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Add the necessary SQL statements here
//                database.execSQL("ALTER TABLE Message_table ADD COLUMN my_column TEXT")
//                database.execSQL("CREATE TABLE New_Message_table (id INTEGER PRIMARY KEY NOT NULL, my_column TEXT)")
//                database.execSQL("INSERT INTO New_Message_table (id, my_column ) SELECT id, my_column  FROM Message_table")
//                database.execSQL("DROP TABLE Message_table")
//                database.execSQL("ALTER TABLE New_Message_table RENAME TO Message_table")
            }
        }


        val database =
            Room.databaseBuilder(context, ProductDatabase::class.java, "ProductDatabase")
                .addMigrations(migration1to2)
                .build()
        return database.ProductDao()
    }


}