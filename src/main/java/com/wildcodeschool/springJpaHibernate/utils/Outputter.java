package com.wildcodeschool.springJpaHibernate.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.springJpaHibernate.entities.Maison;
import com.wildcodeschool.springJpaHibernate.repositories.MaisonRepository;

@Component
public class Outputter implements CommandLineRunner {

	private Logger LOG = LoggerFactory.getLogger("les maisons sont");
	
	@Autowired
    private MaisonRepository maisonRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Checke combien d'objets se trouvent dans la BDD      
        LOG.info("******************");
        LOG.info("Nombre de maisons : " + maisonRepository.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        Maison Maison1 = new Maison("Bienvenue", "15 place de la lLiberté");
        LOG.info("******************");
        LOG.info(Maison1 + " a bien été crée !");
        maisonRepository.save(Maison1);
        LOG.info(Maison1 + " a bien été enregistrée !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        Maison Maison2 = new Maison("La bonne place", "312 rue de la Paix");
        LOG.info("******************");
        LOG.info(Maison2 + " a bien été crée !");
        maisonRepository.save(Maison2);
        LOG.info(Maison2 + " a bien été enregistrée !");

        // Lit les informations correspondant au second utilisateur
        Maison tempMaison = maisonRepository.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Le nom de la seconde maison est " + tempMaison.getName());
        LOG.info("Située au " + tempMaison.getAddress());

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Liste des maisons ");
        for(Maison myMaison : maisonRepository.findAll()) {
            LOG.info(myMaison.toString());
        };

        // Supprime le second utilisateur de la BDD
        maisonRepository.deleteById(2L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */

        /*  Liste les utilisateurs enregistrés dans la BDD
            (permet de vérifier que le second utilisateur
            a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Liste des maisons ");
        for(Maison myMaison : maisonRepository.findAll()) {
            LOG.info(myMaison.toString());
        };
	}

}
