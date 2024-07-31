package com.fiap.fastfood.fastfood.adapter.output.repository.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("Cliente")
data class ClienteEntity(
    @Id
    val Id: String = "",
    val cpf: String? = "",
    val nome: String? = "",
    val email: String? = ""
)