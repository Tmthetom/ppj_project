package cz.tul.services;

import cz.tul.data.Image;
import cz.tul.data.ImageTagId;
import cz.tul.data.Image_Tag;
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

    public void create(Image_Tag image_tag) {
        imageTagRepository.save(image_tag);
    }

    public void update(Image_Tag image_tag){ imageTagRepository.save(image_tag); }

    public boolean exists(ImageTagId imageTagId) {
        return imageTagRepository.exists(imageTagId);
    }

    public List<Image_Tag> getImageTags(Image image) {
        return StreamSupport.stream(imageTagRepository.getImageTags(image.getId_image()).spliterator(), false).collect(Collectors.toList());
    }

    public List<Image_Tag> getAll() {
        return StreamSupport.stream(imageTagRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void delete(Image_Tag image_tag){
        imageTagRepository.delete(image_tag);
    }

    public void deleteAll() {
        imageTagRepository.deleteAll();
    }
}
