package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.ProjetsRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetsRelationRepository extends JpaRepository<ProjetsRelation, Long> {
}
