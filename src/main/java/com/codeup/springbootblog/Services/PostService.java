package com.codeup.springbootblog.Services;

import com.codeup.springbootblog.Models.Post;
import com.codeup.springbootblog.Models.User;
import com.codeup.springbootblog.Repositories.PostsRepository;
import com.codeup.springbootblog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostsRepository postsRepository;
    private UsersRepository usersRepository;

    // Dependency Injection
    @Autowired
    public PostService(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    // Gets a single post based on ID
    public Post findPost(long id) {
        return postsRepository.findOne(id);
    }

    // listing all blog posts. Order not yet controlled. Consider functions to control listing orders on the future sql queries.
    public Iterable<Post> findAllPosts() {
        return postsRepository.findAll();
    }

    // Creates a post, will have INSERT functionality later when database is made.
    public void savePost(Post post, User user) {
        post.setUser(user);
        postsRepository.save(post);
    }

    // Edits a post.
    public void updatePost(Post post) {
        postsRepository.save(post);
    }

    // Deletes a post based on primary key ID
    public void deletePost(Long id) {
        postsRepository.delete(id);
    }

    public User findUser(long id) {
        return usersRepository.findOne(id);
    }

}
