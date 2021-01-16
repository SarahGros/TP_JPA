package galerie.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Tableau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull n'est pas nécessaire car l'id du premier objet de l'entity est à 1 et le second à 2
    private Integer id;

    @Column(name = "TITRE", nullable = false)
    private String titre;

    @Column(name = "SUPPORT")
    private String support;

    @Column(name = "LARGEUR")
    private Integer largeur;

    @Column(name = "HAUTEUR")
    private Integer hauteur;

    @ManyToOne
    private Artiste artiste;

    @OneToOne
    private Transaction transaction;

    @ManyToMany
    private List<Exposition> expositions = new LinkedList<>();

}
