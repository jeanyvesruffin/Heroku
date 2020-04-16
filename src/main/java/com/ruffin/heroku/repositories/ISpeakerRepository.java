package com.ruffin.heroku.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruffin.heroku.models.Speaker;

public interface ISpeakerRepository extends JpaRepository<Speaker, Long>{

		// indiquera par exemple l'interface crud pour un speaker
}
