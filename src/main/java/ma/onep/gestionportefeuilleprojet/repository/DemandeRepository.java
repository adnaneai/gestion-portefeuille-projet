package ma.onep.gestionportefeuilleprojet.repository;

import ma.onep.gestionportefeuilleprojet.entities.*;
import ma.onep.gestionportefeuilleprojet.enums.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    public     List<Demande> findByStatut(Statut statut);
    public List<Demande> findByIdentificationProjet(IdentificationProjet identificationProjet);
    public List<Demande> findByPartiesPrenantes(PartiesPrenantes partiesPrenantes);
    public List<Demande> findByObjectifsProjet(ObjectifsProjet objectifsProjet);
    public List<Demande> findByDescriptionSommairePrestations(DescriptionSommairePrestations descriptionSommairePrestations);
    public List<Demande> findByInformationsProjet(InformationsProjet informationsProjet);
    public List<Demande> findByProjetsRelation(ProjetsRelation projetsRelation);
    public Optional<Demande> findByDemandeurIdUtilisateur(Long demandeurIdUtilisateur);
    public Optional<Demande> findByResponsablePMO_IdUtilisateur(Long responsablePMOIdUtilisateur);

}
