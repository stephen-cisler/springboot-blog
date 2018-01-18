package com.codeup.springbootblog;

import com.codeup.springbootblog.Models.Post;
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

    @GetMapping("/posts")
    public String viewPosts(Model vModel) {
        List<Post> posts= new ArrayList<>();
        Post post1 = new Post("Lets Eat More Pizza", "I don't have much to say on the matter.");
        Post post2 = new Post("Bootstrap Navbars need jQuery to really work", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab adipisci atque dolore dolores et id inventore laudantium minus, nisi, obcaecati odio quidem soluta vero voluptates voluptatibus? Aperiam consectetur optio quos?.");
        Post post3 = new Post("Have Some More Nonsense For You", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab adipisci atque dolore, nisi, obcaecati odio quidem soluta vero voluptates voluptatibus? Aperiam consectetur optio quos?.");
        Post post4 = new Post("Post number FOUR", "And I'm not sure what else there is to talk about now.");

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

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
