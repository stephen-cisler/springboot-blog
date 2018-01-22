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

    // Handles display of all blog posts.
    @GetMapping("/posts")
    public String viewPosts(Model vModel) {
        Iterable<Post> posts = postService.findAllPosts();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    // Handles detailed display of a single blog post
    @GetMapping("/posts/{id}")
    public String viewSingePost(@PathVariable String id, Model vModel) {
        Post post = postService.findPost(Long.parseLong(id));
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    // Handles the blog creation form.
    @GetMapping("/posts/create")
    public String viewCreatePost(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    // Handles the blog creation submission.
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, Model vModel) {
        postService.savePost(post);
        vModel.addAttribute("post", post);
        return "redirect:/posts";
    }

    // Handles blog editing form.
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable String id, Model vModel) {
        long longId = Long.parseLong(id);
        vModel.addAttribute("post", postService.findPost(longId));
        return "posts/edit";
    }

    // Handles blog editing submission. BUT CURRENTLY DOES NOT SAVE EDITS
    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post, Model vModel) {
        return "redirect:/posts";
    }

}
