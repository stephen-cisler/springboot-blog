package com.codeup.springbootblog.Services;

import com.codeup.springbootblog.Models.Post;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts = new ArrayList<>();

    public PostService() {
        createPosts();
    }

    public Post findPost(long id) {
        for (int i = 0; i < posts.size(); i += 1) {
            if (posts.get(i).getId() == id) {
                return posts.get(i);
        }
    }

        return posts.get((int)id -1);
}

    public List<Post> findAllPosts() {
        return posts;
    }

    public void savePost(Post post) {
        post.setId((long) posts.size() + 1);
        posts.add(post);
    }

    private void createPosts() {
        posts.add(new Post(posts.size() + 1,
                "The First Post On the Blog",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo non tellus non vestibulum. Vivamus pharetra quis libero id dapibus. Aenean quis turpis non leo molestie volutpat ut ac leo. In hac habitasse platea dictumst. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam viverra eget mauris non commodo. Quisque laoreet dolor justo. Ut sem tellus, bibendum in vestibulum id, facilisis sit amet nisi. Cras et massa a velit dapibus aliquam. Nunc sit amet urna sed mi semper interdum. Vivamus lectus purus, mattis eu mollis at, sagittis ac est. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla nisi augue, malesuada sit amet imperdiet at, vehicula vitae massa. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos."));
        posts.add(new Post(posts.size() + 1,
                "Another Entry On this Blog",
                "Curabitur nec ultricies massa, a posuere sem. Donec venenatis faucibus erat, vitae accumsan mi tincidunt ac. Phasellus feugiat iaculis tortor sed blandit. Proin tempor nulla nisi. Nam lacus lectus, pulvinar in blandit dignissim, tempor sit amet quam. In hac habitasse platea dictumst. Maecenas eu dictum neque. Maecenas sollicitudin molestie hendrerit."));
        posts.add(new Post(posts.size() + 1,
                "Hey, New Update",
                "Suspendisse potenti. Sed sagittis dui ac eleifend imperdiet. Etiam quis mollis velit, nec accumsan nulla. Praesent auctor maximus pulvinar. Nam pellentesque lacinia sem vitae bibendum. Quisque ac auctor purus. Curabitur nec dui sed justo tempus sodales. Maecenas vel volutpat magna, eget ullamcorper sem. Pellentesque semper hendrerit nunc nec suscipit."));
        posts.add(new Post(posts.size() + 1,
                "Test Blog Posts Done",
                "In vulputate arcu eget lacinia venenatis. Maecenas nec arcu vulputate, consectetur metus eu, commodo lectus. Curabitur auctor enim purus, at sodales urna vehicula non."));
    }


}
