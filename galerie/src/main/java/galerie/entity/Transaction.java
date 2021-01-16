package galerie.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull n'est pas nécessaire car l'id du premier objet de l'entity est à 1 et le second à 2
    private Integer id;

    @Column(name = "DATEVENTE", nullable = false)
    private Date venduLe;

    @Column(name = "PRIX", nullable = false)
    private Integer prixDeVente;

    @ManyToOne
    private Exposition exposition;

    @ManyToOne
    private Personne personne;

    @OneToOne
    private Tableau tableau;
}
