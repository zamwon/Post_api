package pl.karnecki.zadanierekrutacyjne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karnecki.zadanierekrutacyjne.model.Post;
import pl.karnecki.zadanierekrutacyjne.repository.PostRepo;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepo postRepository;

    @Autowired
    public PostServiceImpl(PostRepo postRepository) {
        this.postRepository = postRepository;
    }

    private boolean isPostOnList(Post post) {
        return postRepository.findById(post.getId())
                .stream()
                .anyMatch(element ->
                        element.getId().equals(post.getId()));
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getPostsByTitle(String title) {
        return getPosts()
                .stream()
                .filter(post -> post.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public boolean savePost(Post post) {
        if (isPostOnList(post)) return false;
        postRepository.save(post);
        return true;
    }

    @Override
    public boolean deletePost(Integer id) {
        postRepository.delete(postRepository.getOne(id));
        return true;
    }

    @Override
    public boolean modifyPost(Post post) {
        Optional<Post> postOptional = postRepository.findAll()
                .stream()
                .filter(oldPost -> oldPost.getId().equals(post.getId()))
                .findFirst();
        if (postOptional.isPresent()) {
            postOptional.get().setTitle(post.getTitle());
            postOptional.get().setBody(post.getBody());
            postRepository.save(postOptional.get());
            return true;
        }
        return false;
    }
}
