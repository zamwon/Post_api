package pl.karnecki.zadanierekrutacyjne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karnecki.zadanierekrutacyjne.model.Post;
import pl.karnecki.zadanierekrutacyjne.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private boolean isPostOnList(Post post) {
        return postRepository.getPostList()
                .stream()
                .anyMatch(element ->
                        element.getId().equals(post.getId()));
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.getPostList();
    }

    @Override
    public List<Post> getPostsByTitle(String title) {
        return postRepository.getPostList()
                .stream()
                .filter(post -> post.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public boolean savePost(Post post) {
        if (isPostOnList(post)) return false;
        postRepository.addPostToList(post);
        return true;
    }

    @Override
    public boolean deletePost(Integer id) {
        postRepository.removePostFromList(id);
        return true;
    }

    @Override
    public boolean modifyPost(Post post) {
        if (isPostOnList(post)) {
            postRepository.modify(post);
            return true;
        } else
            return false;
    }
}
