package pl.karnecki.zadanierekrutacyjne;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.karnecki.zadanierekrutacyjne.model.Post;
import pl.karnecki.zadanierekrutacyjne.repository.PostRepo;

@Component
public class Start {

    private PostRepo postRepo;
    private RestTemplate restTemplate;
   ;

    public Start(PostRepo postRepo) {
        this.postRepo = postRepo;
        this.restTemplate = new RestTemplate();

    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){

        Post[] forObject = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class);
        assert forObject != null;
        for (Post p: forObject) {
            postRepo.save(p);
        }

    }
}
