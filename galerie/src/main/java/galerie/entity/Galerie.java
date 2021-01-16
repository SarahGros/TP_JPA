package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String nom;

    @Column(unique = true)
    @NonNull
    private String adresse;

    // DONE : Mettre en oeuvre la relation oneToMany vers Exposition

    @OneToMany(mappedBy = "galerie")
    private List<Exposition> expositions = new LinkedList<>();

    //implémentation en java de la méthode CAannuel(annee)
    public float cAannuel(int annee) {
        float chiffreAffaire = 0.0f;
        for (Exposition lesExpo : expositions) {
            if (lesExpo.getDebut().getYear() == annee) {
                chiffreAffaire = chiffreAffaire + lesExpo.ca();
            }
        }
        return chiffreAffaire;
    }
}