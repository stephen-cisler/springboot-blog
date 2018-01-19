package com.codeup.springbootblog.Controllers;

import com.codeup.springbootblog.Models.Post;
import com.codeup.springbootblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {
    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String viewPosts(Model vModel) {
        List<Post> posts = postService.findAllPosts();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewSingePost(@PathVariable String id, Model vModel) {
        Post post = postService.findPost(Long.parseLong(id));
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePost(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, Model vModel) {
        postService.savePost(post);
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable String id, Model vModel) {
        long longId = Long.parseLong(id);
        vModel.addAttribute("post", postService.findPost(longId));
        return "posts/edit";
    }

    public String editPost(@ModelAttribute Post post, Model vModel) {
        return "posts/show";
    }

}
