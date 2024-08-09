package com.fiap.fastfood.fastfood.application.domain.model

class Item(
    val id: String?,
    val categoria: Categoria,
    val nome :String,
    val preco: Double,
    val descricao : String,
    val imagem: ImagemMetadata?
)
