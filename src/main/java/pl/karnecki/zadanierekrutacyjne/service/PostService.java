package pl.karnecki.zadanierekrutacyjne.service;


import pl.karnecki.zadanierekrutacyjne.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getPosts();

    Optional<Post> getPostById(Integer id);

    List<Post> getPostsByTitle(String title);

    boolean savePost(Post post);

    boolean deletePost(Integer id);

    boolean modifyPost(Post post);
}
