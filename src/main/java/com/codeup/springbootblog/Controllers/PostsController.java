package com.codeup.springbootblog.Controllers;

import com.codeup.springbootblog.Models.Post;
import com.codeup.springbootblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String viewSingePost(@PathVariable String id, Model vModel){
        Post post = new Post("This is my first Post", "I don't have much to say.");
        vModel.addAttribute("post", post);
        vModel.addAttribute("id", id);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost() {
     return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }

}
