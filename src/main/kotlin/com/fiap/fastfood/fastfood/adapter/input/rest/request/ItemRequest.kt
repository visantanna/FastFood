package com.fiap.fastfood.fastfood.adapter.input.rest.request

import com.fiap.fastfood.fastfood.application.domain.model.Categoria

data class ItemRequest(
    val categoria: String,
    val nome :String,
    val preco: Double,
    val descricao : String,
    val imagens: List<Array<Byte>>
)