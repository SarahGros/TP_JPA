package galerie.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Exposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull n'est pas nécessaire car l'id du premier objet de l'entity est à 1 et le second à 2
    private Integer id;

    @Column(unique = true)
    @NonNull
    private Date debut;

    @Column(unique = true)
    @NonNull
    private String intitule;

    @Column(unique = true)
    @NonNull
    private Integer duree;

    @OneToMany(mappedBy = "exposition")
    private List<Transaction> transactions = new LinkedList<>();

    @ManyToOne
    private Galerie galerie;

    @ManyToMany
    @JoinTable(name = "expo_tableau",
            joinColumns =
            @JoinColumn(name = "exposition_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "tableau_id", referencedColumnName = "id"))
    List<Tableau> tableaux = new LinkedList<>();


    //implémentation en java de CA()
    public float ca() {
        float ca = 0.0f;
        for (Transaction laTransaction : transactions) {
            ca = ca + laTransaction.getPrixDeVente();
        }
        return ca;
    }
}
