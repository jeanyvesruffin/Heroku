package com.ruffin.heroku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// extends SpringBootServletInitializer 
// Il s'agit d'une extension de WebApplicationInitializer 
// qui exécute une SpringApplication à partir d'une archive WAR 
// traditionnelle déployée sur un conteneur Web

@SpringBootApplication
public class HerokuApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HerokuApplication.class, args);
	}


	// Pour tester notre API avec  POSTMAN, nous pouvons consulter par ex les sessions en envoyant la requete

	// EXEMPLE TEST API POSTMAN  pour READ toutes les  datas


	// GET ==> http://localhost:8080/api/v1/sessions
	// GET ==> http://localhost:8080/api/v1/speakers
	// Afin d'avoir une serialisation "propre" nous ajoutons l'annotation JsonIgnore ds le model speaker
	// Pour fix l'erreur 500 lors de l'appel de l'url http://localhost:8080/api/v1/sessions/1
	// Nous ajoutons l'annotation JSonIgnoreProperties({"hibernateLazyInitializer"}) pour que JSON ignore les propriétés purement techniques d'Hibernate

	// EXEMPLE TEST API POSTMAN pour READ une datas (ex parmametre id:2)
	// GET ==> http://localhost:8080/api/v1/sessions/2
	// GET ==> http://localhost:8080/api/v1/speakers/2

	// EXEMPLE TEST API POSTMAN pour CREATE une session
	// parametre POSTMAN (POST, Body, raw, JSON)
	// POST http://localhost:8080/api/v1/sessions
	/*
	{
		"session_name": "Jean-Yves RUFFIN Session",
		"session_description": "Test de création d'une session pour Ruffin Jean-Yves",
		"session_length": 45
	}
	 */
	/*
	return : 200
	{
	    "session_id": 93,
	    "session_name": "Jean-Yves RUFFIN Session",
	    "session_description": "Test de création d'une session pour Ruffin Jean-Yves",
	    "session_length": 45,
	    "speakers": null
	}
	 */

	// EXEMPLE TEST API POSTMAN pour UPDATE une session (ex precedent : id:93)
	// parametre POSTMAN (PUT, Body, raw, JSON)
	// PUT http://localhost:8080/api/v1/sessions/93
	// return : 200
	/*
	{
	    "session_id": 93,
	    "session_name": "Jean-Yves RUFFIN Session",
	    "session_description": "Test de création d'une session pour Ruffin Jean-Yves",
	    "session_length": 90,
	    "speakers": null
	}
	 */

	// EXEMPLE TEST API POSTMAN pour DELETE une session (ex precedent : id:93)
	// parametre POSTMAN (PUT, Body, raw, JSON)
	// DELETE http://localhost:8080/api/v1/sessions/93
	// return : 200
	/*
		{
		    "session_id": 93,
		    "session_name": "Jean-Yves RUFFIN Session",
		    "session_description": "Test de création d'une session pour Ruffin Jean-Yves",
		    "session_length": 90,
		    "speakers": null
		}
	 */

	// EXEMPLE TEST API POSTMAN pour consulter la version de l'app a travers .yml
	// GET http://localhost:5000/
	// return : 200
	/*
		{
	    "app-version": "1.0.0"
		}
	 */

}
