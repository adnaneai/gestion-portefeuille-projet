package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.IdentificationProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdentificationProjetRepository extends JpaRepository<IdentificationProjet, Long> {

    Optional<IdentificationProjet> findByCode(String code);

    Optional<IdentificationProjet> findByIdProjet(String idProjet);

    Optional<IdentificationProjet> findByIntituleProjet(String intituleProjet);

    boolean existsIdentificationProjetByCode(String code);

    boolean existsIdentificationProjetByIdProjet(String idProjet);

    boolean existsIdentificationProjetByIntituleProjet(String intituleProjet);
}
