package com.pixel_alireza.gameland.data.remote.repo.store

import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.remote.model.Common
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import javax.inject.Inject

class StoreDataServiceImpl @Inject constructor(
    val client: HttpClient
) : StoreDataService {
    override suspend fun getAllItems(): Resource<Common<List<StoreData>>> {
        return try {
            val request = client.get<Common<List<StoreData>>> {
                url(StoreDataService.endPoint.getAllItemds.url)
            }
            Resource.Success(request)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message.toString(), null)
        }

    }
}