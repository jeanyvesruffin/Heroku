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

import com.ruffin.heroku.models.Session;
import com.ruffin.heroku.repositories.ISessionRepository;





// l'annotation @REST + @RequestMapping concerne l'url ou sera envoyé le controllers
// dans le controllers nous manipulerons notre API endpoint + base REST


@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

	@Autowired
	private ISessionRepository sessionRepository;


	@GetMapping
	@RequestMapping("{id}")
	public Session get(@PathVariable Long id) {
		return sessionRepository.getOne(id);
	}

	// CRUD (Create) HTTP POST example

	@PostMapping
	public Session create(@RequestBody final Session session) {
		return sessionRepository.saveAndFlush(session);
	}

	// CRUD (Read) HTTP GET example

	@GetMapping
	public List<Session> list () {
		return sessionRepository.findAll();
	}

	// CRUD (Update) HTTP POST example (PATCH = update de juste une portion put update toute la ligne)
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update (@PathVariable Long id, @RequestBody Session session) {
		
		Session existingSession = sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, existingSession, "session_id");
		return sessionRepository.saveAndFlush(existingSession);
		
	}
	
	// CRUD (Remove) HTTP POST example

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete (@PathVariable Long id) {
		// Vosu devez également vérifier les enregistrements des enfants avant de les supprimer
		sessionRepository.deleteById(id);
	}

}
