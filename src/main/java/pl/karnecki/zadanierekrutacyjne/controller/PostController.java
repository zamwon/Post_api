package pl.karnecki.zadanierekrutacyjne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karnecki.zadanierekrutacyjne.model.Post;
import pl.karnecki.zadanierekrutacyjne.service.PostServiceImpl;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;

    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<Post>> getPostsByTitle(@PathVariable String title) {
        List<Post> first = postService.getPostsByTitle(title);
        if (first != null) {
            return new ResponseEntity<>(first, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable Integer id) {
        if (postService.deletePost(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> modifyPost(@PathVariable Integer id, @RequestBody Post post) {
        Optional<Post> postById = postService.getPostById(id);

        if (postById.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Post postToUpdate = postById.get();

            if (post.getTitle() != null) {
                postToUpdate.setTitle(post.getTitle());
            }
            if (post.getBody() != null) {
                postToUpdate.setBody(post.getBody());
            }

            postService.modifyPost(postToUpdate);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        }
    }
}
