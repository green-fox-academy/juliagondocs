package com.greenox.reddit.services;

import com.greenox.reddit.models.Post;
import com.greenox.reddit.models.User;
import com.greenox.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repo;

    @Autowired
    public PostServiceImpl ( PostRepository repo ) {
        this.repo=repo;
        repo.save(new Post("Series", "www.sorozatbarat.hu"));
        repo.save(new Post("Baby", "www.babyboom.hu"));
        repo.save(new Post("Medical","orvos.hu"));
        repo.save(new Post("Weather Forecast", "met.hu"));
    }

    public List<Post> findAll() {
        return repo.findAll();
    }

    public void saveNewPost( Post post) {
        repo.save(post);
    }

    public Post getPostById(Long id) {
        return repo.findPostById(id);
    }

    public void increaseScore( Post post) {
        post.setScore(post.getScore()+1);
        repo.save(post);
    }

    public void decreaseScore( Post post) {
        post.setScore(post.getScore()-1);
        repo.save(post);
    }

    public void deletePost(Long id) {
        repo.delete(repo.findPostById(id));
    }

    public void setUpDatabase(List<User> users) {
        Post post = repo.findPostById(1L);
        post.setOwner(users.get(1));
        repo.save(post);

        post = repo.findPostById(2L);
        post.setOwner(users.get(1));
        repo.save(post);

        post = repo.findPostById(3L);
        post.setOwner(users.get(2));
        repo.save(post);

        post = repo.findPostById(4L);
        post.setOwner(users.get(3));
        repo.save(post);
    }
}
