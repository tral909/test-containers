package indorm1992.testcontainers.service;

import indorm1992.testcontainers.model.Post;

import java.util.List;

public interface PostService {

    Post getById(long id);

    List<Post> getAll();

    Post create(Post post);

    void delete(long id);
}
