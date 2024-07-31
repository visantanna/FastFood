package com.fiap.fastfood.fastfood.application.ports.input.rest

import com.fiap.fastfood.fastfood.application.domain.model.Item

interface ApiItem {
    fun cadastraItem(item: Item);
    fun alteraItem(id: String, item: Item)
    fun removeItem(id: String)
    fun obterItemsPorCategoria(categoria:String)
}