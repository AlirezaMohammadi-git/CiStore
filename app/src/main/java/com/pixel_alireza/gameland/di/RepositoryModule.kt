package com.pixel_alireza.gameland.di

import com.pixel_alireza.gameland.data.remote.repo.chat.message.MessageDataSource
import com.pixel_alireza.gameland.data.remote.repo.chat.message.MessageDataSourceImpl
import com.pixel_alireza.gameland.data.remote.repo.chat.socket.ChatSocketImpl
import com.pixel_alireza.gameland.data.remote.repo.chat.socket.ChatSocketService
import com.pixel_alireza.gameland.data.remote.repo.store.StoreDataService
import com.pixel_alireza.gameland.data.remote.repo.store.StoreDataServiceImpl
import com.pixel_alireza.gameland.data.remote.repo.user.UserService
import com.pixel_alireza.gameland.data.remote.repo.user.UserServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideUserRepo(
        userServiceImpl: UserServiceImpl
    ): UserService


    @Binds
    @Singleton
    abstract fun provideChatSocketService(
        chatSocketService: ChatSocketImpl
    ): ChatSocketService


    @Binds
    @Singleton
    abstract fun provideStoreDataService(
        storeDataServiceImpl: StoreDataServiceImpl
    ): StoreDataService

    @Binds
    @Singleton
    abstract fun provideMessageDataSource(
        messageDataSourceImpl: MessageDataSourceImpl
    ): MessageDataSource
}