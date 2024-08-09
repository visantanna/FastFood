package com.fiap.fastfood.fastfood.application.ports.output.file

import com.fiap.fastfood.fastfood.application.domain.model.ImagemMetadata
import com.fiap.fastfood.fastfood.application.domain.model.Item
import java.io.InputStream

interface FileStoragePort {
    fun save(imageContent: InputStream, id: String , imageMetadata: ImagemMetadata)
    fun get(id: String , imageMetadata: ImagemMetadata): ByteArray?
    fun delete(id:String , imageMetadata: ImagemMetadata)
}