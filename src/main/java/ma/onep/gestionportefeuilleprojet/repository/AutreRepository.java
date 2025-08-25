package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.Autre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutreRepository extends JpaRepository<Autre, Long> {
}
