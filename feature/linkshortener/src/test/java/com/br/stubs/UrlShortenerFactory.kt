package com.br.stubs

import com.br.domain.model.LinksModel
import com.br.domain.model.ShortenedUrlModel
import com.br.presentation.uimodel.LinksUI
import com.br.presentation.uimodel.ShortenedUrlUI

fun makeShortenedUrlUi(
    originalUrl: String = "https://www.google.com",
    links: LinksUI = makeLinksUi()
) = ShortenedUrlUI(
    alias = originalUrl,
    links = links
)

fun makeLinksUi(
    self: String = "https://bit.ly/3g5Z4Zp",
    short: String = "https://bit.ly/3g5Z4Zp"
) = LinksUI(
    self = self,
    short = short
)

fun makeShortenedUrlModel(
    alias: String = "https://www.google.com",
    linksModel: LinksModel = makeLinksModel()
) = ShortenedUrlModel(
    alias = alias,
    links = linksModel
)

fun makeLinksModel(
    self: String = "https://bit.ly/3g5Z4Zp",
    short: String = "https://bit.ly/3g5Z4Zp"
) = LinksModel(
    self = self,
    short = short
)