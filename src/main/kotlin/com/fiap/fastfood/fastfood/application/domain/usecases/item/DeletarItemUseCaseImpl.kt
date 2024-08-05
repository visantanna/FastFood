package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.ports.item.RemoverItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class RemoverItemUseCaseImpl(
    val itemPortRepository : ItemPortRepository
) : RemoverItemUseCase {
    override fun execute(id: String) {
        if(itemPortRepository.exists(id)){
            itemPortRepository.delete(id)
        }else{
            throw BussinessLogicException("Erro ao tentar deletar Item. Item Inexistente", 404)
        }
    }
}