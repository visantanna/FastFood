package com.fiap.fastfood.fastfood.adapter.output.repository

import com.fiap.fastfood.fastfood.adapter.output.repository.entities.ClienteEntity
import com.fiap.fastfood.fastfood.application.domain.model.Cliente


fun Cliente.toEntity(): ClienteEntity =
    with(this){
        return ClienteEntity(
            cpf= this.cpf,
            nome= this.nome,
            email=this.email
        )
    }

fun ClienteEntity.toDomain(): Cliente =
    with(this){
        return Cliente(
            cpf= this.cpf,
            nome= this.nome,
            email=this.email
        )
    }