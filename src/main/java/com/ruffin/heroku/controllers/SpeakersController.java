package com.ruffin.heroku.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruffin.heroku.models.Speaker;
import com.ruffin.heroku.repositories.ISpeakerRepository;

//l'annotation @REST + @RequestMapping concerne l'url ou sera envoyé le controllers
//dans le controllers nous manipulerons notre API endpoint + base REST

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
	
	@Autowired
	private ISpeakerRepository speakerRepository;

	@GetMapping
	@RequestMapping("{id}")
	public Speaker get(@PathVariable Long id) {
		return speakerRepository.getOne(id);
	}
	
	// CRUD (Create) HTTP POST example
	
	@PostMapping
	public Speaker create(@RequestBody final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	// CRUD (Read) HTTP GET example
	
	@GetMapping
	public List<Speaker> list () {
		return speakerRepository.findAll();
	}
	

	// CRUD (Update) HTTP POST example (PATCH = update de juste une portion put update toute la ligne)
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update (@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker existingSpeaker = speakerRepository.getOne(id);
		BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
		return speakerRepository.saveAndFlush(existingSpeaker);
	}
	
	// CRUD (Remove) HTTP POST example

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete (@PathVariable Long id) {
		// Vous devez également vérifier les enregistrements des enfants avant de les supprimer
		speakerRepository.deleteById(id);
	}

	
	
	
	
}
