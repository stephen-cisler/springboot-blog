package com.codeup.springbootblog.Controllers;

import com.codeup.springbootblog.Models.Post;
import com.codeup.springbootblog.Models.User;
import com.codeup.springbootblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        // HARD WIRED USER, REMOVE LATER
        User user = postService.findUser(1L);
        postService.savePost(post, user);
        vModel.addAttribute("post", post);
        return "redirect:/posts";
    }

    // Handles blog editing form.
    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable String id, Model vModel) {
        long longId = Long.parseLong(id);
        vModel.addAttribute("post", postService.findPost(longId));
        return "posts/edit";
    }

    // Handles blog editing submission.
    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post, Model vModel) {
        User user = postService.findUser(1L);
        postService.savePost(post, user);
        return "redirect:/posts";
    }

    // Handles blog post deletion page for confirmation
    @GetMapping("/posts/{id}/delete")
    public String deletePostConfirm(@PathVariable String id, Model vModel) {
        long longId = Long.parseLong(id);
        vModel.addAttribute("post", postService.findPost(longId));
        return "posts/delete";
    }

    // Handles blog entry deletion.
    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postService.deletePost(post.getId());
        return "redirect:/posts";

    }

}
