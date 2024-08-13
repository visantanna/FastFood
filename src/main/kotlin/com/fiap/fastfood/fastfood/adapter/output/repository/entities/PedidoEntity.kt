package com.fiap.fastfood.fastfood.adapter.output.repository.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("pedidoDocument")
data class PedidoEntity (
    @Id
    val id: String?,
    @DBRef
    val cliente: ClienteEntity,
    @DBRef
    val lanche: ItemEntity?,
    @DBRef
    val acompanhamento: ItemEntity?,
    @DBRef
    val bebida: ItemEntity?,
    @DBRef
    val sobremesa: ItemEntity?,
    val status : String
)