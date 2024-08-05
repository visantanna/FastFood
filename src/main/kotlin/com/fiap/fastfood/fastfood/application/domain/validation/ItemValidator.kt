package com.fiap.fastfood.fastfood.application.domain.validation

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Categoria
import com.fiap.fastfood.fastfood.application.domain.model.Item

class ItemValidator {
    fun validate(item: ItemRequest){
        validateCategory(item.categoria)
    }
    fun validateCategory(categoria: String){
        try{
            Categoria.valueOf(categoria);
        }catch (ex: Exception){
            throw BussinessLogicException(
                "Categoria Inexistente! Escolha entre uma das opções: "+ Categoria.values(),
                400
            )
        }
    }


}