package pl.karnecki.zadanierekrutacyjne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karnecki.zadanierekrutacyjne.model.Post;
import pl.karnecki.zadanierekrutacyjne.service.PostServiceImpl;

import java.util.List;


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
}
