package pl.karnecki.zadanierekrutacyjne.repository;

import org.springframework.stereotype.Repository;
import pl.karnecki.zadanierekrutacyjne.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {


    List<Post> postList;

    public PostRepository() {
        this.postList = new ArrayList<>();
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
    public boolean addPostToList(Post post) {
        Optional<Post> postOptional = postList.stream()
                .filter(oldPost -> oldPost.getId().equals(post.getId()))
                .findFirst();

        if (postOptional.isPresent())
            return false;

        return postList.add(post);
    }

    public boolean removePostFromList(int id) {
        Optional<Post> postOptional = postList.stream()
                .filter(oldPost -> oldPost.getId().equals(id))
                .findFirst();

        if (postOptional.isPresent()) {
            postList.remove(id);
            return true;
        }
        return false;
    }

    public boolean modify(Post post) {
        Optional<Post> postOptional = postList.stream()
                .filter(oldPost -> oldPost.getId().equals(post.getId()))
                .findFirst();
        if (postOptional.isPresent()) {
            postList.remove(postOptional.get());
            return postList.add(post);
        }
        return false;
    }
}
