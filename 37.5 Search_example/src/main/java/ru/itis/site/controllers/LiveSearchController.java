package ru.itis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.site.model.Movie;
import ru.itis.site.service.MovieService;

import java.util.List;

@Controller
public class LiveSearchController {

    @Autowired
    private MovieService movieService;

    @RequestMapping (value = "/movie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Movie> searchMovie(@RequestBody String title) {
        return movieService.search(title);
    }
}
