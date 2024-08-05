package com.fiap.fastfood.fastfood.adapter.output.repository.entities

import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import org.springframework.context.annotation.Description
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("itemDocument")
data class ItemEntity(
    @Id
    var id: String="",
    val nome: String,
    val preco: Double,
    val descricao: String,
    val categoria: String,
    val imagens: List<Array<Byte>>
)