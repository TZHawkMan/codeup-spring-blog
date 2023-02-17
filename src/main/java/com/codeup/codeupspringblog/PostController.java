package com.codeup.codeupspringblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/posts")
    @ResponseBody
    public String indexPage(){
        return "posts index page";

    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable int id){
        return  "view an individual post:" + id;
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
