package com.fiap.fastfood.fastfood.adapter.output.repository.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("ClienteDocument")
data class ClienteEntity(
    @Id
    val id: String? ,
    val cpf: String? = "",
    val nome: String? = "",
    val email: String? = ""
)