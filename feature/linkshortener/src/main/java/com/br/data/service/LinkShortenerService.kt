package com.br.data.service

import com.br.data.request.OriginalUrlRequest
import com.br.data.response.ShortenedUrlResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LinkShortenerService {
    @POST("/api/alias")
    fun createShortenedUrl(@Body request: OriginalUrlRequest): ShortenedUrlResponse
}