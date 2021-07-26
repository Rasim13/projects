package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.site.model.Movie;
import ru.itis.site.service.MovieService;

import java.util.List;

@Controller
public class LiveSearchController {

    @Autowired
    private MovieService movieService;

    @RequestMapping (value = "/movies", method = RequestMethod.GET)

    @ResponseBody
    public List<Movie> searchMovie(@RequestParam String title) {
        return movieService.search(title);
    }

//    @RequestMapping (value = "/movies", method = RequestMethod.GET)
//    public String getMoviesPage (Model model) {
//        List<Movie> movies = movieService.findAll();
//        model.addAttribute("movies", movies);
//        return "movies";
//    }
}
