package cz.tul.services;

import cz.tul.data.Image;
import cz.tul.data.Tag;
import cz.tul.data.User;
import cz.tul.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void create(Image image) {
        imageRepository.save(image);
    }

    public void update(Image image){ imageRepository.save(image); }

    public boolean exists(Image image) {
        return imageRepository.exists(image.getId_image());
    }

    public Image get(Image image) {
        return imageRepository.findOne(image.getId_image());
    }

    public List<Image> getAll() {
        return StreamSupport.stream(imageRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public List<Image> getByName(String name){
        return imageRepository.findByName(name);
    }

    public List<Image> getByAuthor(User author){
        return imageRepository.findByAuthor(author);
    }

    public List<Image> getByTag(Tag tag) {
        return imageRepository.findByTags(tag.getName());
    }

    public void delete(Image image){
        imageRepository.delete(image.getId_image());
    }

    public void deleteAll() {
        imageRepository.deleteAll();
    }
}
