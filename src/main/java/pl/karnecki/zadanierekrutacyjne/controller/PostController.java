package pl.karnecki.zadanierekrutacyjne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.karnecki.zadanierekrutacyjne.model.Post;
import pl.karnecki.zadanierekrutacyjne.service.PostServiceImpl;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;

    }

    @GetMapping("/{title}")
    public Post[] getPosts(@PathVariable String title) {
        RestTemplate restTemplate = new RestTemplate();

        Post[] forObject = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class);

        for (Post post : forObject) {
            System.out.println(post);
        }
        return forObject;
    }
}
