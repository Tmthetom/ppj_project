package cz.tul.services;

import cz.tul.data.Tag;
import cz.tul.data.User;
import cz.tul.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public void create(Tag tag) {
        tagRepository.save(tag);
    }

    public boolean exists(Tag tag) {
        return tagRepository.exists(tag.getName());
    }

    public boolean exists(String tagName) {
        return tagRepository.exists(tagName);
    }

    public Tag get(Tag tag){
        return tagRepository.findOne(tag.getName());
    }

    public Tag get(String tagName){
        return tagRepository.findOne(tagName);
    }

    public List<Tag> getAll() {
        return StreamSupport.stream(tagRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void delete(Tag tag){
        tagRepository.delete(tag.getName());
    }

    public void deleteAll() {
        tagRepository.deleteAll();
    }
}
