package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.adapter.input.rest.request.ItemRequest
import com.fiap.fastfood.fastfood.adapter.input.rest.response.ItemResponse
import com.fiap.fastfood.fastfood.adapter.output.repository.toResponse
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiItem
import com.fiap.fastfood.fastfood.application.ports.service.item.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/v1/items")
class ControllerItem(
    val cadastraItemUseCase: CadastrarItemUseCase,
    val alteraItemUseCase: AlterarItemUseCase,
    val removeItemUseCase: RemoverItemUseCase,
    val obterItemPorCategoriaUseCase: ObterItemPorCategoriaUseCase,
    val obterItemUsecase: ObterItemUseCase,
    val obterItemImagemUseCase: ObterItemImageUseCase
): ApiItem {
    @Operation(summary = "Cadastra o item enviado, categorias possiveis são: LANCHE,ACOMPANHAMENTO, SOBREMESA, BEBIDA, " +
            "caso nenhum desses seja enviado o retorno é 400, preço tem que ser no formato: 2.00 (double), imagem obrigatória")
    @ApiResponses(value = [
        ApiResponse(responseCode = "400", description = "Categoria Inexistente! Escolha entre uma das opções: LANCHE,ACOMPANHAMENTO, SOBREMESA, BEBIDA" ,content = [Content()])
    ])
    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    override fun cadastraItem(@ModelAttribute item: ItemRequest): ResponseEntity<Item> {
        val itemSaved = cadastraItemUseCase.execute(item)
        return ResponseEntity.ok(itemSaved)
    }

    @Operation(summary = "Altera o item enviado, categorias possiveis são: LANCHE,ACOMPANHAMENTO, SOBREMESA, BEBIDA, " +
            "caso nenhum desses seja enviado o retorno é 400, preço tem que ser no formato: 2.00 (double), imagem obrigatória" +
            "caso o id passado não exista retorna 404")
    @ApiResponses(value = [
        ApiResponse(responseCode = "400", description = "Categoria Inexistente! Escolha entre uma das opções: LANCHE,ACOMPANHAMENTO, SOBREMESA, BEBIDA" ,content = [Content()]),
        ApiResponse(responseCode = "404", description = "Item a ser alterado não existe!" ,content = [Content()])
    ])
    @PutMapping("/{id}", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    override fun alteraItem(@PathVariable id: String, @ModelAttribute item: ItemRequest): ResponseEntity<Item> {
        return ResponseEntity.ok(alteraItemUseCase.execute(id,item))
    }

    @Operation(summary = "Remove o item cadastrado, caso não exista retorna 404")
    @ApiResponses(value = [
        ApiResponse(responseCode = "404", description = "Erro ao tentar deletar Item com o id: {id}. Item Inexistente" ,content = [Content()])
    ])
    @DeleteMapping("/{id}")
    override fun removeItem(@PathVariable id: String) :ResponseEntity<Item> {
        removeItemUseCase.execute(id)
        return ResponseEntity.noContent().build()
    }

    @Operation(summary = "Pega lista de Items por categoria (retorna todos os itens da base), caso categoria não exista retorna 400")
    @ApiResponses(value = [
        ApiResponse(responseCode = "400", description = "Categoria Inexistente! Escolha entre uma das opções: LANCHE,ACOMPANHAMENTO, SOBREMESA, BEBIDA" ,content = [Content()])
    ])
    @GetMapping()
    override fun obterItemsPorCategoria(@RequestParam categoria: String): ResponseEntity<List<ItemResponse>> {
        return ResponseEntity.ok(obterItemPorCategoriaUseCase.execute(categoria).map { it.toResponse() })
    }
    @GetMapping("/{id}")
    override fun obterItemById(@PathVariable id: String): ResponseEntity<ItemResponse>{
        return ResponseEntity.ok(obterItemUsecase.execute(id).toResponse())
    }

    @Operation(summary = "Retorna só a imagem, criei esse endpoint, pois não acredito que faça sentido" +
            " retornar uma lista de items junto com as imagens, response ficaria muito pesado, prefiri separar " +
            "em dois endpoints. Caso não exista imagem retorna 404. Caso ocorra qualquer falha ao retornar imagem: 500")
    @ApiResponses(value = [
        ApiResponse(responseCode = "404", description = "Item com id: {id} não tem imagem disponível" ,content = [Content()]),
        ApiResponse(responseCode = "500", description = "Erro ao tentar recuperar imagem" ,content = [Content()])
    ])
    @GetMapping("/{id}/imagem")
    override fun obterItemImageById(@PathVariable id: String):ResponseEntity<ByteArray>{
        val imagem = obterItemImagemUseCase.execute(id)

        val headers = HttpHeaders()
        headers.add("Content-Type", imagem.imagemMetadata.extensao)
        headers.add("Content-Size", imagem.content.size.toString())
        val response = ResponseEntity(imagem.content,headers, HttpStatus.OK)
        return  response
    }

}