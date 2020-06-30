package cst438;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController { // localhost:8080/hello?name=mitchell
	
	@Autowired
	MovieRatingRepository movieRatingRepository;
	
	@GetMapping("/hello")
	public String hello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("time", new java.util.Date().toString());
		return "index";
	}

	@GetMapping("movies/new")
	public String createNewRating(Model model) {
		MovieRating movieRating = new MovieRating();
		model.addAttribute("movieRating", movieRating);
		return "movie_form";
	}
	
	@PostMapping("/movies/new")
	public String processPersonForm(@Valid MovieRating movieRating,
									BindingResult result,
									Model model) {
		if (result.hasErrors()) {
			return "movie_form";
		}
		movieRatingRepository.save(movieRating);
		return "index";
	}
	
	@GetMapping("/movies")
	public String showAllMovieRatings(Model model) {
		Iterable<MovieRating> movieRating = movieRatingRepository.findAll();
		model.addAttribute("movieRating", movieRating);
		return "movie_list";
		
	}
}
