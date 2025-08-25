package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.DesignationProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesignationProjetRepository extends JpaRepository<DesignationProjet, Long> {
    public Optional<DesignationProjet> findByNomDesignationProjet(String nomDesignationProjet);
}
