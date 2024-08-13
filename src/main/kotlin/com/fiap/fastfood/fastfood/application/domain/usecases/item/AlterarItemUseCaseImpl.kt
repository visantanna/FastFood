package com.fiap.fastfood.fastfood.application.domain.usecases.item

import com.fiap.fastfood.fastfood.adapter.input.rest.helper.toDomain
import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.domain.validation.ItemValidador
import com.fiap.fastfood.fastfood.application.ports.service.item.AlterarItemUseCase
import com.fiap.fastfood.fastfood.application.ports.output.file.FileStoragePort
import com.fiap.fastfood.fastfood.application.ports.output.repository.ItemPortRepository
import org.springframework.stereotype.Service

@Service
class AlterarItemUseCaseImpl(
    val itemValidador: ItemValidador,
    val itemPortRepository: ItemPortRepository,
    val fileStoragePort: FileStoragePort
) : AlterarItemUseCase {
    override fun execute(id: String, item: ItemRequest): Item {
        itemValidador.validate(item)
        val itemDomain = item.toDomain()
        if(itemPortRepository.exists(id)) {
            itemDomain.imagem?.let { fileStoragePort.delete(id, it) }
            if (!item.imagem.isEmpty && itemDomain.imagem != null) {
                fileStoragePort.save(item.imagem.inputStream, id, itemDomain.imagem)
            }
            return itemPortRepository.alter(id, itemDomain)
        }
        throw BussinessLogicException("Item a ser alterado não existe!", 404)
    }
}