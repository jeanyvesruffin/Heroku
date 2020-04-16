package com.ruffin.heroku.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruffin.heroku.models.Session;



public interface ISessionRepository extends JpaRepository<Session, Long>{

	
	// indiquera par exemple l'interface crud pour une session
	
}
