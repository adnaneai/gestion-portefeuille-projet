package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.DemandeDTO;
import ma.onep.gestionportefeuilleprojet.entities.*;
import ma.onep.gestionportefeuilleprojet.enums.Statut;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeNotFoundException;

import java.util.List;

public interface DemandeService {

    public List<DemandeDTO> findAll();
    public DemandeDTO findById(Long id) throws DemandeNotFoundException;
    public List<DemandeDTO> findByStatut(Statut statut) throws DemandeNotFoundException;
    public List<DemandeDTO> findByIdentificationProjet(IdentificationProjet identificationProjet) throws DemandeNotFoundException;
    public List<DemandeDTO> findByPartiesPrenantes(PartiesPrenantes partiesPrenantes) throws DemandeNotFoundException;
    public List<DemandeDTO> findByObjectifsProjet(ObjectifsProjet objectifsProjet) throws DemandeNotFoundException;
    public List<DemandeDTO> findByDescriptionSommairePrestations(DescriptionSommairePrestations descriptionSommairePrestations) throws DemandeNotFoundException;
    public List<DemandeDTO> findByInformationsProjet(InformationsProjet informationsProjet) throws DemandeNotFoundException;
    public List<DemandeDTO> findByProjetsRelation(ProjetsRelation projetsRelation) throws DemandeNotFoundException;
    public DemandeDTO findByDemandeurId(Long demandeurId) throws DemandeNotFoundException;
    public DemandeDTO findByResponsablePMOId(Long responsablePMOId)  throws DemandeNotFoundException;
    public DemandeDTO saveDemande(DemandeDTO demandeDTO);
    public DemandeDTO updateById(DemandeDTO demandeDTO, Long id) throws DemandeNotFoundException;
    public DemandeDTO updateByDemandeurId(DemandeDTO demandeDTO, Long id) throws DemandeNotFoundException;
    public DemandeDTO updateByResponsablePMO(DemandeDTO demandeDTO, Long id) throws DemandeNotFoundException;
    public void deleteById(Long id) throws DemandeNotFoundException;
    public void deleteByDemandeurId(Long id) throws DemandeNotFoundException;
    public void deleteByResponsablePMO(Long id) throws DemandeNotFoundException;
}
