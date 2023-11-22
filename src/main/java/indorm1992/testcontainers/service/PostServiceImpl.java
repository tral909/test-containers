package indorm1992.testcontainers.service;

import indorm1992.testcontainers.model.Post;
import indorm1992.testcontainers.model.exception.PostNotFoundException;
import indorm1992.testcontainers.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post getById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);
        postRepository.addView(id);
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = postRepository.findAll(Sort.by("id").descending());
        posts.forEach(p -> postRepository.addView(p.getId())); //todo many sql requests, refactor for 1
        return posts;
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }
}
