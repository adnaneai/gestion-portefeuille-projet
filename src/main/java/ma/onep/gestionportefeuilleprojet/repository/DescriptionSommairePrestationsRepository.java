package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.DescriptionSommairePrestations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionSommairePrestationsRepository extends JpaRepository<DescriptionSommairePrestations, Long> {
}
