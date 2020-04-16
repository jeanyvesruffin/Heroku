package com.ruffin.heroku.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//annotaion entity indique que cette classe represente une table de notre base de données

@Entity(name = "sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {

	// annotation pour indiquer que session_id est la primary key

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long session_id;
	
	private String session_name;
	private String session_description;
	private Integer session_length;

	
	// exemple de relation many to many
	
	@ManyToMany
	@JoinTable(
			name = "session_speakers",
			joinColumns = @JoinColumn(name = "session_id"),
			inverseJoinColumns = @JoinColumn(name = "speaker_id"))
	private List<Speaker> speakers;
	
	public Session() {
		super();
	}


	public Long getSession_id() {
		return session_id;
	}


	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}


	public String getSession_name() {
		return session_name;
	}


	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}


	public String getSession_description() {
		return session_description;
	}


	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}


	public Integer getSession_length() {
		return session_length;
	}


	public void setSession_length(Integer session_length) {
		this.session_length = session_length;
	}


	public List<Speaker> getSpeakers() {
		return speakers;
	}


	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

}
