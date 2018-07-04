package com.greenox.reddit.services;

import com.greenox.reddit.models.Post;
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
        repo.save(new Post("Weather Forecast", "www.met.hu", 1243L, "OMSZ", "1"));
        repo.save(new Post("Series", "www.sorozatbarat.hu", 10243L, "Bari", "1"));
        repo.save(new Post("Facebook", "www.fb.hu", 100243L, "FB", "1"));
    }

    public List<Post> findAll() {
        return repo.findAll();
    }

    public void saveNewPost( Post post) {
        repo.save(post);
    }
}