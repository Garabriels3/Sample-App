package com.br.commondata.exception

private const val CONNECTION_ERROR_MESSAGE = "Verifique sua conexão e tente novamente."

class NetworkException(
    override val message: String = CONNECTION_ERROR_MESSAGE
) : Exception()