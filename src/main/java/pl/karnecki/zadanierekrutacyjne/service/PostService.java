package pl.karnecki.zadanierekrutacyjne.service;


import pl.karnecki.zadanierekrutacyjne.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getPostsByTitle(String title);

    boolean savePost(Post post);

    boolean deletePost(int id);

    boolean modifyPost(Post post);
}
