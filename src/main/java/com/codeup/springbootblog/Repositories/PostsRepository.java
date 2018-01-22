package com.codeup.springbootblog.Repositories;

import com.codeup.springbootblog.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post, Long> {
}
