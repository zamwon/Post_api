//package pl.karnecki.zadanierekrutacyjne.repository;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.web.client.RestTemplate;
//import pl.karnecki.zadanierekrutacyjne.model.Post;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class PostRepository  {
//
//
//    private List<Post> postList;
//    private RestTemplate restTemplate;
//
//    public PostRepository() {
//        this.postList = new ArrayList<>();
//        postList.add(new Post(1, 1, "title", "body"));
//        this.restTemplate = new RestTemplate();
//
//        Post[] forObject = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class);
//
//        assert forObject != null;
//        postList.addAll(Arrays.asList(forObject));
//    }
//
//    public List<Post> getPostList() {
//        return postList;
//    }
//
//    public void setPostList(List<Post> postList) {
//        this.postList = postList;
//    }
//
//    public boolean addPostToList(Post post) {
//        Optional<Post> postOptional = postList.stream()
//                .filter(oldPost -> oldPost.getId().equals(post.getId()))
//                .findFirst();
//
//        if (postOptional.isPresent())
//            return false;
//
//        return postList.add(post);
//    }
//
//    public boolean removePostFromList(Integer id) {
//        Optional<Post> postOptional = postList.stream()
//                .filter(oldPost -> oldPost.getId().equals(id))
//                .findFirst();
//
//        if (postOptional.isPresent()) {
//            postList.remove(id.intValue());
//            return true;
//        }
//        return false;
//    }
//
//    public boolean modify(Post post) {
//        Optional<Post> postOptional = postList.stream()
//                .filter(oldPost -> oldPost.getId().equals(post.getId()))
//                .findFirst();
//        if (postOptional.isPresent()) {
//            postList.remove(postOptional.get());
//            return postList.add(post);
//        }
//        return false;
//    }
//}
