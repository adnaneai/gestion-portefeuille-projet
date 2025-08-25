package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.Beneficitaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficitaireRepository extends JpaRepository<Beneficitaire, Long> {
    List<Beneficitaire> findByNomBeneficitaireContainingIgnoreCase(String nomBeneficitaire);
    boolean existsById(Long id);
}
