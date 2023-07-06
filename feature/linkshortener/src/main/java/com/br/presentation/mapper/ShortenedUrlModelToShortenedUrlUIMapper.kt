package com.br.presentation.mapper

import com.br.domain.model.LinksModel
import com.br.domain.model.ShortenedUrlModel
import com.br.general.mapper.Mapper
import com.br.presentation.uimodel.LinksUI
import com.br.presentation.uimodel.ShortenedUrlUI

class ShortenedUrlModelToShortenedUrlUIMapper : Mapper<ShortenedUrlModel, ShortenedUrlUI> {
    override fun map(input: ShortenedUrlModel): ShortenedUrlUI {
        return ShortenedUrlUI(
            alias = input.alias,
            links = input.links.mapLinksModelToUI()
        )
    }

    private fun LinksModel.mapLinksModelToUI(): LinksUI {
        return LinksUI(
            self = self,
            short = short
        )
    }
}