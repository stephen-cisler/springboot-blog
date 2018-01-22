package com.codeup.springbootblog.Services;

import com.codeup.springbootblog.Models.Post;
import com.codeup.springbootblog.Repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostsRepository postsRepository;

    // Dependency Injection
    @Autowired
    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
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
    public void savePost(Post post) {
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







    // A Seeder for this early stage. Most likely will be removed or commented out. Used for testing purposes.
//    private void createPosts() {
//        posts.add(new Post(posts.size() + 1,
//                "The First Post On the Blog",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo non tellus non vestibulum. Vivamus pharetra quis libero id dapibus. Aenean quis turpis non leo molestie volutpat ut ac leo. In hac habitasse platea dictumst. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam viverra eget mauris non commodo. Quisque laoreet dolor justo. Ut sem tellus, bibendum in vestibulum id, facilisis sit amet nisi. Cras et massa a velit dapibus aliquam. Nunc sit amet urna sed mi semper interdum. Vivamus lectus purus, mattis eu mollis at, sagittis ac est. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla nisi augue, malesuada sit amet imperdiet at, vehicula vitae massa. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."));
//        posts.add(new Post(posts.size() + 1,
//                "Another Entry On this Blog",
//                "Curabitur nec ultricies massa, a posuere sem. Donec venenatis faucibus erat, vitae accumsan mi tincidunt ac. Phasellus feugiat iaculis tortor sed blandit. Proin tempor nulla nisi. Nam lacus lectus, pulvinar in blandit dignissim, tempor sit amet quam. In hac habitasse platea dictumst. Maecenas eu dictum neque. Maecenas sollicitudin molestie hendrerit."));
//        posts.add(new Post(posts.size() + 1,
//                "Hey, New Update",
//                "Suspendisse potenti. Sed sagittis dui ac eleifend imperdiet. Etiam quis mollis velit, nec accumsan nulla. Praesent auctor maximus pulvinar. Nam pellentesque lacinia sem vitae bibendum. Quisque ac auctor purus. Curabitur nec dui sed justo tempus sodales. Maecenas vel volutpat magna, eget ullamcorper sem. Pellentesque semper hendrerit nunc nec suscipit."));
//        posts.add(new Post(posts.size() + 1,
//                "Test Blog Posts Done",
//                "In vulputate arcu eget lacinia venenatis. Maecenas nec arcu vulputate, consectetur metus eu, commodo lectus. Curabitur auctor enim purus, at sodales urna vehicula non."));
//    }


}
