package com.example.beatsPM.Controllers;

import com.example.beatsPM.Models.Data.PostRepository;
import com.example.beatsPM.Models.PostData;
import com.example.beatsPM.Models.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@Controller
public class SearchController {

    @Autowired
    private PostRepository postRepository;


    @CrossOrigin(origins = "*")
    @PostMapping("/results")
    public @ResponseBody
    Iterable<PostModel> displaySearchResults( @RequestParam String searchTerm) {
        Iterable<PostModel> posts;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            posts = postRepository.findAll();
        } else {
            posts = PostData.findByValue( searchTerm, postRepository.findAll());
        }
    return posts;
    }
}
