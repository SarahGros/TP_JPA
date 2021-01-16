package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {
    /**
     * Calculer le chiffre d'affaires pour une exposition
     * @param id la clé primaire de l'exposition
     * @return le chiffre d'affaires de cette exposition
     */
@Query(value = "SELECT SUM(PRIX) AS Chiffre_DAffaire_De_LExposition"
        + "INNER JOIN Transaction ON Transaction.exposition_id = Exposition.id "
        + "WHERE Exposition.id = :id Group by Exposition.id",
        nativeQuery = true)

  float chiffreAffairePour(Integer id);
}
