package cz.tul.services;

import cz.tul.data.Image;
import cz.tul.data.ImageRatingId;
import cz.tul.data.ImageRating;
import cz.tul.repositories.ImageRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ImageRatingService {

    @Autowired
    private ImageRatingRepository imageRatingRepository;

    public void create(ImageRating image_rating) {
        imageRatingRepository.save(image_rating);
    }

    public void update(ImageRating image_rating){ imageRatingRepository.save(image_rating); }

    public boolean exists(ImageRatingId imageRatingId) {
        return imageRatingRepository.exists(imageRatingId);
    }

    public List<ImageRating> getImageRatings(Image image) {
        return imageRatingRepository.getImageRatings(image.getId_image());
    }

    public List<ImageRating> getAll() {
        return StreamSupport.stream(imageRatingRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void delete(ImageRating image_rating){
        imageRatingRepository.delete(image_rating);
    }

    public void deleteAll() {
        imageRatingRepository.deleteAll();
    }
}
