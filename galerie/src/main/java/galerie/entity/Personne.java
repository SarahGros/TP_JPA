package galerie.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull n'est pas nécessaire car l'id du premier objet de l'entity est à 1 et le second à 2
    private Integer id;

    @Column(name = "NOM")
    @NotNull
    private String nom;

    @Column(name = "ADRESSE")
    @NotNull
    private String adresse;

    @OneToMany(mappedBy = "personne")
    private List<Transaction> transactions = new LinkedList<>();

    //implémentation en java BudgetArt(annee)
    public float budgetArt(int annee) {
        float budget = 0.0f;
        for (Transaction transaction : transactions) {
            if (transaction.getVenduLe().getYear() == annee) {
                budget += transaction.getPrixDeVente();
            }

        }
        return budget;
    }

}
