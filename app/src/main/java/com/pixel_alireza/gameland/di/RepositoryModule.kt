package com.pixel_alireza.gameland.di

import com.pixel_alireza.gameland.data.remote.repo.chat.ChatSocketImpl
import com.pixel_alireza.gameland.data.remote.repo.chat.ChatSocketService
import com.pixel_alireza.gameland.data.remote.repo.user.UserServiceImpl
import com.pixel_alireza.gameland.data.remote.repo.user.UserService
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

}