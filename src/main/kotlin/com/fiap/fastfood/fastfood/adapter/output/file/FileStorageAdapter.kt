package com.fiap.fastfood.fastfood.adapter.output.file

import com.fiap.fastfood.fastfood.application.domain.model.ImagemMetadata
import com.fiap.fastfood.fastfood.application.domain.model.Item
import com.fiap.fastfood.fastfood.application.ports.output.file.FileStoragePort
import org.springframework.stereotype.Repository
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

@Repository
class FileStorageAdapter: FileStoragePort {
    val DEFAULT_IMAGES_FOLDER = "src/main/resources/static/images/"
    override fun save(imageContent: InputStream, id: String , imageMetadata: ImagemMetadata) {
        val filePath = getFilePath(id, imageMetadata)
        Files.copy(imageContent,filePath, StandardCopyOption.REPLACE_EXISTING)
    }

    override fun get(id: String, imageMetadata: ImagemMetadata): ByteArray? {
        val filePath = getFilePath(id, imageMetadata)
        if (Files.exists(filePath))
            return Files.readAllBytes(filePath)
        return null
    }

    override fun delete(id: String, imageMetadata: ImagemMetadata) {
        val filePath = getFilePath(id, imageMetadata)
        if (Files.exists(filePath))
            Files.delete(filePath)
    }

    private fun getFilePath(
        id: String,
        imageMetadata: ImagemMetadata
    ): Path {
        val fileName = generateFileName(id, imageMetadata)
        val uploadPath = Files.createDirectories(Path.of(DEFAULT_IMAGES_FOLDER))
        val filePath = uploadPath.resolve(fileName)
        return filePath
    }

    private fun generateFileName(
        id: String,
        imageMetadata: ImagemMetadata
    ) = id + imageMetadata.nomeArquivo


}