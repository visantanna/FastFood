package com.fiap.fastfood.fastfood.application.ports.service.item

import com.fiap.fastfood.fastfood.application.domain.model.Imagem

interface ObterItemImageUseCase {
    fun execute(id:String): Imagem
}