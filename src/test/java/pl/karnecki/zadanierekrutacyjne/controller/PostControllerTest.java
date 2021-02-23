package pl.karnecki.zadanierekrutacyjne.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.karnecki.zadanierekrutacyjne.model.Post;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PostControllerTest {

    private ResponseEntity<List<Post>> prepareMockData() {
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(1, 1, "b", "t", false));
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @Test
    void getPosts() {

        //given
        PostController postController = mock(PostController.class);
        when(postController.getPosts()).thenReturn(prepareMockData());

        //when
        ResponseEntity<List<Post>> posts = postController.getPosts();
        //then
        Assertions.assertEquals(posts.getStatusCode(), postController.getPosts().getStatusCode());
        Assertions.assertEquals(posts.getBody(), postController.getPosts().getBody());
    }


}