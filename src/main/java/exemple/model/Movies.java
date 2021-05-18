package exemple.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movies")
public class Movies {

	@Id
	@Column(name = "idM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idM;

	@Column(name = "title")
	private String title;

	@Column(name = "releaseDate")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date releaseDate = new Date();

	@Column(name = "director")
	private String director;

	@Column(name = "type")
	private String type;

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movies(String title, Date releaseDate, String director, String type) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.director = director;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIdM() {
		return idM;
	}

}
