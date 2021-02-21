package pl.karnecki.zadanierekrutacyjne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.karnecki.zadanierekrutacyjne.model.Post;


public interface PostRepo extends JpaRepository<Post, Integer> {

}
