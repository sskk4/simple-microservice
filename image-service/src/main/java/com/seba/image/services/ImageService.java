package com.seba.image.services;

import com.seba.image.config.SecHolder;
import com.seba.image.entity.Image;
import com.seba.image.exceptions.ResourceNotFindException;
import com.seba.image.repositories.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;


@Service
@AllArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    @SneakyThrows
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFindException("IMAGE NOT FOUND"));
    }

    @SneakyThrows
    public Image getImageByTitle(String title) {
        return imageRepository.findByTitle(title).orElseThrow(
                () -> new ResourceNotFindException("IMAGE NOT FOUND"));
    }

    @SneakyThrows
    public Image save(String title, MultipartFile file) {

        Image image = new Image();
        image.setTitle(title);
        image.setFileName(file.getOriginalFilename());
        image.setData(file.getBytes());
        image.setUserId(SecHolder.getUserId());
        return imageRepository.save(image);
    }

    public Image delete(Long id) {
        Image image = imageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFindException("IMAGE NOT FOUND"));

        imageRepository.deleteById(id);
        return image;
    }
}
