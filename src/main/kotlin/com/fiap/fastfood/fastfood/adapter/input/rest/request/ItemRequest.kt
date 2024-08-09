package com.fiap.fastfood.fastfood.adapter.input.rest.request

import org.springframework.web.multipart.MultipartFile

data class ItemRequest(
    val categoria: String,
    val nome :String,
    val preco: Double,
    val descricao : String,
    val imagem: MultipartFile
)