package cst438;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MovieRating {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3, max=25)
	private String name;
	
	@NotNull
	@Size(min=3, max=25)
	private String title;
	
	@NotNull
	@Max(5)
	@Min(1)
	private long rating;
	
	@NotNull
	private String date;
	
	public MovieRating() {
		
	}
	
	public MovieRating(long id, String name, String title, Long rating, String date) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.rating = rating;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getRating() {
		return rating;
	}

	public void setRating(long rating) {
		this.rating = rating;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		Date now = new Date();
		// This format will allow the alphabetical sorting of the date to match sorting by date.
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		
		this.date = formatter.format(now);
	}
}
