package com.fiap.fastfood.fastfood.adapter.input.rest.response

import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.ImagemMetadata

data class ItemResponse(
    val id: String,
    val categoria: String,
    val nome :String,
    val preco: Double,
    val descricao : String,
)