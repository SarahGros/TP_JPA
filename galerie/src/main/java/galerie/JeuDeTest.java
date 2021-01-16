package galerie;

import galerie.dao.ExpositionRepository;
import galerie.dao.GalerieRepository;
import galerie.dao.PersonneRepository;
import galerie.entity.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@Log4j2
public class JeuDeTest implements CommandLineRunner {

    @Autowired
    private ExpositionRepository expoRepo;

    @Autowired
    private GalerieRepository galerieRepo;

    @Autowired
    private PersonneRepository persoRepo;

    @Override
    public void run(String[] args) throws Exception {

        //ajout d'un tableau
        Tableau AmongUs = new Tableau();
        AmongUs.setTitre("Jeu");
        Tableau garnica = new Tableau();
        garnica.setTitre("Garnica");
        List listeTableauSarah = new LinkedList<>();
        listeTableauSarah.add(AmongUs);
        listeTableauSarah.add(garnica);


        //ajout d'un artiste
        Artiste Sarah = new Artiste();
        Sarah.setBiographie("Sarah 21ans");
        Sarah.setTableaux(listeTableauSarah);

        //ajout d'une personne
        Sarah.setNom("Sarah");
        Sarah.setAdresse("17 rue Sainte Foy");
        persoRepo.save(Sarah);

        //ajout deuxième personne
        Personne lAcheteur = new Personne();
        lAcheteur.setNom("unAcheteur");
        lAcheteur.setAdresse("1 carrer ferrer");

        // ajout d'une exposition
        Exposition premiereExpo = new Exposition();
        premiereExpo.setDebut(new Date(30 / 04 / 2021));
        premiereExpo.setDuree(1);
        premiereExpo.setIntitule("Premiere expo de sarah");
        expoRepo.save(premiereExpo);
        Optional<Exposition> monExpo = expoRepo.findById(1);
        log.info("l'expo : {}", monExpo);

        //ajout d'une transaction
        Transaction premiereTransac = new Transaction();
        premiereTransac.setPrixDeVente(1000);
        premiereTransac.setVenduLe(new Date(30 / 04 / 2021));
        premiereTransac.setExposition(premiereExpo);
        premiereTransac.setPersonne(lAcheteur);

        // ajout d'une galerie
        Galerie nouvelleGalerie = new Galerie();
        nouvelleGalerie.setNom("Galerie d'expo");
        nouvelleGalerie.setAdresse("12 rue isis, Castres");
        List listeExpoGalerie = new LinkedList<>();
        listeExpoGalerie.add(premiereExpo);
        nouvelleGalerie.setExpositions(listeExpoGalerie);
        galerieRepo.save(nouvelleGalerie);
        float caNouvelleGalerie = nouvelleGalerie.cAannuel(2021);

    }

}
