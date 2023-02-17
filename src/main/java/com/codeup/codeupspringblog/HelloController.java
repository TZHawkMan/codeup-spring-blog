package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
record Message(String message){}


@Controller
public class HelloController {
    //method will listen for GET requests at /hello
    @GetMapping("/hello")// does not need "path =" if only one direction
    @ResponseBody
    public String helloWorld(){
        return "<h1> Hello from Spring </h1>";
    }

    @GetMapping(path = "json", produces= "application/json")
    @ResponseBody
    public Message returnMessage(){
        return new Message("hello from spring");
    }

    /*@PostMapping
    @PutMapping
    @PatchMapping
    @DeleteMapping
    Http methods*/
//RequestMapping is the parent of all other mapping annotations and can be further customized.
    @RequestMapping (path = "/color" , method = RequestMethod.GET)
    @ResponseBody
    public String color(){
        return "Royal blue";
    }

// path variables are established in the URI mapping by curly braces.
    @GetMapping("/hello/{lastName}/{firstName}")
    @ResponseBody
    //If using Path variables, you must include the annotations in the method parameters.
    public String sayHello(@PathVariable String lastName, @PathVariable String firstName){
        return "Hello" + " " + lastName + firstName;
    }

    @GetMapping("/boolean/{boolean}")
    @ResponseBody
    public String booleanValue(@PathVariable boolean booleanVar) {
        return "the answer is :" + booleanVar;
    }


    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    @GetMapping("/dogpark")
    public String dogpark(Model model) {
        List<String> dogs = new ArrayList<>();
        dogs.add("Bubbles");
        dogs.add("Spot");
        dogs.add("Ezekial");

        model.addAttribute("dogs", dogs);
        return "dogpark";
    }

}
