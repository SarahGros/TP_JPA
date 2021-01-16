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
public class Artiste extends Personne{

    @Column(name = "Biographie")
    private String biographie;

    @OneToMany(mappedBy = "artiste")
    private List<Tableau> tableaux = new LinkedList<>();
}
