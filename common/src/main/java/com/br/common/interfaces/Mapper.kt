package com.br.common.interfaces

interface Mapper<I, O> {
    fun map(source: I): O
}