package com.fiap.fastfood.fastfood.adapter.input.rest

import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.ports.input.rest.ApiItem
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/items")
class ControllerItem: ApiItem {
    @PostMapping()
    override fun cadastraItem(@RequestBody item: Item) {

    }

    @PutMapping("/{id}")
    override fun alteraItem(@PathVariable id: String, @RequestBody item: Item) {

    }

    @DeleteMapping("/id")
    override fun removeItem(@PathVariable id: String) {

    }

    @GetMapping()
    override fun obterItemsPorCategoria(@RequestParam categoria: String) {

    }

}