package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.Demandeur;
import ma.onep.gestionportefeuilleprojet.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    public Optional<Demandeur> findByMatricule(Long idMatricule);
    public Optional<Demandeur> deleteByMatricule(Long idMatricule);
}
