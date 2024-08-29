package com.seba.image.rest;

import com.seba.image.config.CustomPrincipal;
import com.seba.image.config.SecHolder;
import com.seba.image.entity.Image;
import com.seba.image.services.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private final String TAG = "ImageController - ";

    private final ImageService imageService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Image getImageById(@PathVariable Long id) {
        log.info(TAG + "Get image by id: {}", id);
        return imageService.getImageById(id);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Image getImageByTitle(@PathVariable String title) {
        log.info(TAG + "Get image by title: {}", title);
        return imageService.getImageByTitle(title);
    }

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public Image saveImage(@RequestParam("title") String title,
                           @RequestParam("file") MultipartFile file) {
        log.info(TAG + "Save image file: {} , by user {}", file.getOriginalFilename(), SecHolder.getUserId());
        return imageService.save(title, file);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Image deleteImage(@PathVariable Long id) {
        log.info(TAG + "Delete image by id: {}", id);
        return imageService.delete(id);
    }

    @GetMapping("/unrestricted")
    public ResponseEntity<?> getMessage() {
        return new ResponseEntity<>("Hai this is a normal message..", HttpStatus.OK);
    }
    @GetMapping("/restricted")
    public ResponseEntity<?> getRestrictedMessage() {
        return new ResponseEntity<>("This is a restricted message", HttpStatus.OK);
    }
}
