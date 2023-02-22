package com.codeupspringblog.controllers;

import com.codeupspringblog.models.Post;
import com.codeupspringblog.repositories.PostRepository;
import com.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping(path = "/posts")
    public String showPosts(Model model){
        List<Post> posts = new ArrayList<>();
        Post p1 = new Post (1,"post 1","my initial post!");

        posts.add(p1);
        model.addAttribute("allPosts",posts);
        return "posts/index";

    }

    @GetMapping("/posts/{id}")

    public String singlePost(@PathVariable long id,Model model){
        model.addAttribute("post", postDao.findById(id).get());

        return  "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "view the form for creating a post";
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String newPost(){
        return "create a new post";
    }

}
