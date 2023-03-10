package com.codeupspringblog.controllers;

import com.codeupspringblog.models.Ad;
import com.codeupspringblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {
    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/ad";
    }

    @GetMapping("/ads/{title}")
    public String adShow(@PathVariable String title, Model model) {
        model.addAttribute("title", adDao.findByTitle(title));
        return"ads/adsShow";
    }


    @GetMapping("/ads/{id}")
    public String singleAd(@PathVariable long id, Model model){
        model.addAttribute("ad", adDao.findById(id).get());
        return "ads/show";
    }

    @GetMapping("/ads/create")
    public String adCreateForm(){
        return "ads/create";
    }

    @PostMapping(path = "/ads/create")
    public String adCreateSubmit(@RequestParam String title, @RequestParam String description){
        Ad newAd = new Ad(title, description);

        adDao.save(newAd);

        return "redirect:/ads";
    }




}