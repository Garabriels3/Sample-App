package com.br.data.mapper

import com.br.data.response.LinksResponse
import com.br.data.response.ShortenedUrlResponse
import com.br.domain.model.LinksModel
import com.br.domain.model.ShortenedUrlModel
import com.br.general.mapper.Mapper

class ShortenedUrlResponseToShortenedUrlModelMapper: Mapper<ShortenedUrlResponse, ShortenedUrlModel> {
    override fun map(input: ShortenedUrlResponse): ShortenedUrlModel {
        return ShortenedUrlModel(
            alias = input.alias,
            links = input.linksResponse.toLinksModel()
        )
    }

    private fun LinksResponse.toLinksModel(): LinksModel {
        return LinksModel(
            self = self,
            short = short
        )
    }
}