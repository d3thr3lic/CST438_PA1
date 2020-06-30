# CST438_PA1
Objectives:
•	practice coding a Spring controller class that returns data in html format
•	use Spring templates to create parameterized html pages and html forms
•	code Spring entity classes and use spring repository to read/write data to a database
Requirements:
•	Define a model class for movie ratings. 
•	 It should contain attributes title, rating, name of person who posted the rating, date and time of posting.  Annotate the model class with @Entity and don’t forget it needs a primary key field annotated @Id and getters and setters for all fields.
•	Create a form that allows a user to enter their name, movie title and rating (1-5). 
•	Create a controller with methods 
Controller method	URL mapping
Display all ratings sorted by movie title and most recent rating first.  See below about how to specify ORDER BY using repository.
	@GetMapping(“/movies”)
process the posting of a new rating
•	add the current time of posting
•	in the case of validation errors, return the form with error messages to the user
	@PostMapping(“/movies/new”)
return a blank movie rating form
	@GetMapping(“movies/new”)

Specifying ORDER BY 
If you were coding SQL you would specify ORDER BY title, date desc to get an ordered list of movie ratings.  But you are not coding SQL, Spring-JPA is generating the SQL on your behalf.  To do this you must code a method and a Object-Query annotation in the Repository interface for movie ratings. Assuming that you used the name MovieRating, title and date the method and @Query annotation to use is 
public interface MovieRatingRepository extends CrudRepository<MovieRating, Long> {
	@Query("select m from MovieRating m order by title, date desc")
	List<MovieRating> findAllMovieRatingsOrderByTitleDateDesc();
} 
The @Query is similar to SQL, but it is not SQL.  It is an object SQL query language called JPQL (Java persistence query language).

What to submit for this assignment
Create a GitHub repo for this assignment.  Commit and push your code.  Create a pull request and have a team member do a review of your code on part of Assignment 1A.  Comments should be entered into the pull request.  There is nothing to submit for this assignment.
For assignment 1A, you will enter into iLearn the URL of the GitHub repo and this will give your instructor and TA access to your code and review comments.
