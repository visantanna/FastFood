package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.ports.service.item.ObterItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class ObterItemUseCaseImpl(
    private val itemPortRepository: ItemPortRepository,
): ObterItemUseCase {
    override fun execute(id: String):Item {
        if(itemPortRepository.exists(id)){
            return itemPortRepository.getById(id)
        }else{
            throw BussinessLogicException("Item com o id: $id não encontrado!", 404)
        }
    }

}