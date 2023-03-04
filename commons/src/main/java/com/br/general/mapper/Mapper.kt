package com.br.general.mapper

interface Mapper<IN, OUT> {
    fun map(input: IN): OUT
}