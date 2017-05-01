package cz.tul.services;

import cz.tul.data.Image;
import cz.tul.data.ImageTagId;
import cz.tul.data.ImageTag;
import cz.tul.repositories.ImageTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImageTagService {

    @Autowired
    private ImageTagRepository imageTagRepository;

    public void create(ImageTag image_tag) {
        imageTagRepository.save(image_tag);
    }

    public void update(ImageTag image_tag){ imageTagRepository.save(image_tag); }

    public boolean exists(ImageTagId imageTagId) {
        return imageTagRepository.exists(imageTagId);
    }

    public List<ImageTag> getImageTags(Image image) {
        return StreamSupport.stream(imageTagRepository.getImageTags(image.getId_image()).spliterator(), false).collect(Collectors.toList());
    }

    public List<ImageTag> getAll() {
        return StreamSupport.stream(imageTagRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void delete(ImageTag image_tag){
        imageTagRepository.delete(image_tag);
    }

    public void deleteAll() {
        imageTagRepository.deleteAll();
    }
}
