package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.ports.service.item.RemoverItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.file.FileStoragePort
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class RemoverItemUseCaseImpl(
    val itemPortRepository : ItemPortRepository,
    val fileStoragePort: FileStoragePort
) : RemoverItemUseCase {
    override fun execute(id: String) {
        if(itemPortRepository.exists(id)){
            val item =  itemPortRepository.getById(id)
            item.imagem?.let{fileStoragePort.delete(id, it)}
            itemPortRepository.delete(id)
        }else{
            throw BussinessLogicException("Erro ao tentar deletar Item com o id: $id. Item Inexistente", 404)
        }
    }
}