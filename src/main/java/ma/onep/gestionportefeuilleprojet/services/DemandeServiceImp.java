package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.*;
import ma.onep.gestionportefeuilleprojet.entities.*;
import ma.onep.gestionportefeuilleprojet.enums.Statut;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.*;
import ma.onep.gestionportefeuilleprojet.repository.DemandeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ma.onep.gestionportefeuilleprojet.dto.DocumentDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DemandeServiceImp implements  DemandeService {
    private DemandeRepository demandeRepository;
    private DemandeMapper demandeMapper;
    private IdentificationProjetMapper  identificationProjetMapper;
    private PartiesPrenantesMapper partiesPrenantesMapper;
    private ObjectifsProjetMapper objectifsProjetMapper;
    private DescriptionSommairePrestationsMapper descriptionSommairePrestationsMapper;
    private InformationsProjetMapper informationsProjetMapper;
    private ProjetsRelationMapper projetsRelationMapper;
    private AutresInformationMapper  autresInformationMapper;
    private UtilisateurMapper utilisateurMapper;
    private DocumentMapper documentMapper;

    @Override
    public List<DemandeDTO> findAll() {
        List<Demande> demandes = demandeRepository.findAll();
        return demandes.stream()
                .map(demandeMapper::fromDemande)
                .collect(Collectors.toList());
    }

    @Override
    public DemandeDTO findById(Long id) throws DemandeNotFoundException {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(()->new DemandeNotFoundException("Demande non trouvé avec l'ID : " + id));
        return demandeMapper.fromDemande(demande);
    }

    @Override
    public List<DemandeDTO> findByStatut(Statut statut) throws DemandeNotFoundException {
        List<Demande> demandes = demandeRepository.findByStatut(statut);
        return demandes.stream()
                .map(demandeMapper::fromDemande)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDTO> findByIdentificationProjet(IdentificationProjet identificationProjet) throws DemandeNotFoundException {
        List<Demande> demandes = demandeRepository.findByIdentificationProjet(identificationProjet);
        return demandes.stream()
                .map(demandeMapper::fromDemande)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDTO> findByPartiesPrenantes(PartiesPrenantes partiesPrenantes) throws DemandeNotFoundException {
        List<Demande> demandes = demandeRepository.findByPartiesPrenantes(partiesPrenantes);
        return demandes.stream()
                .map(demandeMapper::fromDemande)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDTO> findByObjectifsProjet(ObjectifsProjet objectifsProjet) throws DemandeNotFoundException {
        List<Demande> demandes = demandeRepository.findByObjectifsProjet(objectifsProjet);
        return demandes.stream()
                .map(demandeMapper::fromDemande)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDTO> findByDescriptionSommairePrestations(DescriptionSommairePrestations descriptionSommairePrestations) throws DemandeNotFoundException {
        List<Demande> demandes = demandeRepository.findByDescriptionSommairePrestations(descriptionSommairePrestations);
        return demandes.stream()
                .map(demandeMapper::fromDemande)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDTO> findByInformationsProjet(InformationsProjet informationsProjet) throws DemandeNotFoundException {
        List<Demande> demandes = demandeRepository.findByInformationsProjet(informationsProjet);
        return demandes.stream()
                .map(demandeMapper::fromDemande)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDTO> findByProjetsRelation(ProjetsRelation projetsRelation) throws DemandeNotFoundException {
        List<Demande> demandes = demandeRepository.findByProjetsRelation(projetsRelation);
        return demandes.stream()
                .map(demandeMapper::fromDemande)
                .collect(Collectors.toList());
    }

    @Override
    public DemandeDTO findByDemandeurId(Long demandeurId) throws DemandeNotFoundException {
        Demande demande = demandeRepository.findByDemandeurIdUtilisateur(demandeurId)
                .orElseThrow(()->new DemandeNotFoundException("Demande non trouvé avec l'ID de demandeur : " +demandeurId));
        return demandeMapper.fromDemande(demande);
    }

    @Override
    public DemandeDTO findByResponsablePMOId(Long responsablePMOId) throws DemandeNotFoundException {
        Demande demande = demandeRepository.findByResponsablePMO_IdUtilisateur(responsablePMOId)
                .orElseThrow(()->new DemandeNotFoundException("Demande non trouvé avec l'ID de ResponsableMPO : " +responsablePMOId));
        return demandeMapper.fromDemande(demande);
    }

    @Override
    public DemandeDTO saveDemande(DemandeDTO demandeDTO) {
        Demande demande = demandeMapper.fromDemandeDTO(demandeDTO);
        Demande savedDemande = demandeRepository.save(demande);
        return demandeMapper.fromDemande(savedDemande);
    }

    @Override
    public DemandeDTO updateById(DemandeDTO demandeDTO, Long id) throws DemandeNotFoundException {
        Demande existingDemande = demandeRepository.findById(id)
                .orElseThrow(() -> new DemandeNotFoundException("Demande non trouvée avec l'ID : " + id));

        if (existingDemande.getStatut() == Statut.VALIDE) {
            throw new DemandeNotFoundException("Impossible de modifier une demande déjà validée.");
        }

        existingDemande.setStatut(demandeDTO.getStatut());

        if(demandeDTO.getIdentificationProjetDTO() != null)
            existingDemande.setIdentificationProjet(
                    identificationProjetMapper.fromIdentificationProjetDTO(demandeDTO.getIdentificationProjetDTO())
            );

        if(demandeDTO.getPartiesPrenantesDTO() != null)
            existingDemande.setPartiesPrenantes(
                    partiesPrenantesMapper.fromPartiesPrenanteDTO(demandeDTO.getPartiesPrenantesDTO())
            );

        if(demandeDTO.getObjectifsProjetDTO() != null)
            existingDemande.setObjectifsProjet(
                    objectifsProjetMapper.fromObjectifsProjetDTO(demandeDTO.getObjectifsProjetDTO())
            );

        if(demandeDTO.getDescriptionSommairePrestationsDTO() != null)
            existingDemande.setDescriptionSommairePrestations(
                    descriptionSommairePrestationsMapper.fromDescriptionSommairePrestationsDTO(
                            demandeDTO.getDescriptionSommairePrestationsDTO()
                    )
            );

        if(demandeDTO.getInformationsProjetDTO() != null)
            existingDemande.setInformationsProjet(
                    informationsProjetMapper.fromInformationsProjetDTO(demandeDTO.getInformationsProjetDTO())
            );

        if(demandeDTO.getProjetsRelationDTO() != null)
            existingDemande.setProjetsRelation(
                    projetsRelationMapper.fromProjetsRelationDTO(demandeDTO.getProjetsRelationDTO())
            );

        if(demandeDTO.getDemandeur() != null)
            existingDemande.setDemandeur(utilisateurMapper.fromDemandeurDTO(demandeDTO.getDemandeur()));

        if(demandeDTO.getResponsablePMO() != null)
            existingDemande.setResponsablePMO(utilisateurMapper.fromResponsablePMODTO(demandeDTO.getResponsablePMO()));

        Demande updatedDemande = demandeRepository.save(existingDemande);
        return demandeMapper.fromDemande(updatedDemande);
    }

    @Override
    public DemandeDTO updateByDemandeurId(DemandeDTO demandeDTO, Long demandeurId) throws DemandeNotFoundException {
        Demande existingDemande = demandeRepository.findByDemandeurIdUtilisateur(demandeurId)
                .orElseThrow(() -> new DemandeNotFoundException(
                        "Demande non trouvée pour le demandeur ID : " + demandeurId));

        if (existingDemande.getStatut() == Statut.VALIDE) {
            throw new DemandeNotFoundException("Impossible de modifier une demande déjà validée.");
        }

        existingDemande.setStatut(demandeDTO.getStatut());

        // Gestion des AutresInformation avec les documents
        if(demandeDTO.getAutresInformationDTO() != null) {
            AutresInformation existingAutresInfo = existingDemande.getAutresInformation();
            AutresInformationDTO newAutresInfoDTO = demandeDTO.getAutresInformationDTO();

            if(existingAutresInfo == null) {
                // Créer une nouvelle AutresInformation avec les documents
                AutresInformation newAutresInfo = autresInformationMapper.fromAutreInformationDTO(newAutresInfoDTO);
                if(newAutresInfoDTO.getDocumentDTOS() != null) {
                    List<Document> newDocuments = newAutresInfoDTO.getDocumentDTOS().stream()
                            .map(documentMapper::fromDocumentDTO)
                            .peek(document -> document.setAutresInformation(newAutresInfo))
                            .collect(Collectors.toList());
                    newAutresInfo.setDocuments(newDocuments);
                }
                existingDemande.setAutresInformation(newAutresInfo);
            } else {
                // Mettre à jour les documents existants
                List<Document> existingDocs = existingAutresInfo.getDocuments();
                List<DocumentDTO> newDocDTOs = newAutresInfoDTO.getDocumentDTOS();

                if(newDocDTOs != null && !newDocDTOs.isEmpty()) {
                    // Convertir les nouveaux DocumentDTO en entités Document
                    List<Document> newDocs = newDocDTOs.stream()
                            .map(documentMapper::fromDocumentDTO)
                            .peek(document -> document.setAutresInformation(existingAutresInfo))
                            .collect(Collectors.toList());

                    // Ajouter les nouveaux documents aux existants
                    if (existingDocs == null) {
                        existingAutresInfo.setDocuments(newDocs);
                    } else {
                        existingDocs.addAll(newDocs);
                    }
                }
                existingDemande.setAutresInformation(existingAutresInfo);
            }
        }

        // Mise à jour des autres champs
        if(demandeDTO.getIdentificationProjetDTO() != null)
            existingDemande.setIdentificationProjet(
                    identificationProjetMapper.fromIdentificationProjetDTO(demandeDTO.getIdentificationProjetDTO())
            );
        if(demandeDTO.getPartiesPrenantesDTO() != null)
            existingDemande.setPartiesPrenantes(
                    partiesPrenantesMapper.fromPartiesPrenanteDTO(demandeDTO.getPartiesPrenantesDTO())
            );
        if(demandeDTO.getObjectifsProjetDTO() != null)
            existingDemande.setObjectifsProjet(
                    objectifsProjetMapper.fromObjectifsProjetDTO(demandeDTO.getObjectifsProjetDTO())
            );
        if(demandeDTO.getDescriptionSommairePrestationsDTO() != null)
            existingDemande.setDescriptionSommairePrestations(
                    descriptionSommairePrestationsMapper.fromDescriptionSommairePrestationsDTO(
                            demandeDTO.getDescriptionSommairePrestationsDTO()
                    )
            );
        if(demandeDTO.getInformationsProjetDTO() != null)
            existingDemande.setInformationsProjet(
                    informationsProjetMapper.fromInformationsProjetDTO(demandeDTO.getInformationsProjetDTO())
            );
        if(demandeDTO.getProjetsRelationDTO() != null)
            existingDemande.setProjetsRelation(
                    projetsRelationMapper.fromProjetsRelationDTO(demandeDTO.getProjetsRelationDTO())
            );
        if(demandeDTO.getDemandeur() != null)
            existingDemande.setDemandeur(utilisateurMapper.fromDemandeurDTO(demandeDTO.getDemandeur()));
        if(demandeDTO.getResponsablePMO() != null)
            existingDemande.setResponsablePMO(utilisateurMapper.fromResponsablePMODTO(demandeDTO.getResponsablePMO()));

        Demande updatedDemande = demandeRepository.save(existingDemande);
        return demandeMapper.fromDemande(updatedDemande);
    }

    @Override
    public DemandeDTO updateByResponsablePMO(DemandeDTO demandeDTO, Long responsablePMOId) throws DemandeNotFoundException {
        Demande existingDemande = demandeRepository.findByResponsablePMO_IdUtilisateur(responsablePMOId)
                .orElseThrow(() -> new DemandeNotFoundException(
                        "Demande non trouvée pour le Responsable PMO ID : " + responsablePMOId));

        if (existingDemande.getStatut() == Statut.VALIDE) {
            throw new DemandeNotFoundException("Impossible de modifier une demande déjà validée.");
        }

        existingDemande.setStatut(demandeDTO.getStatut());

        if(demandeDTO.getIdentificationProjetDTO() != null)
            existingDemande.setIdentificationProjet(
                    identificationProjetMapper.fromIdentificationProjetDTO(demandeDTO.getIdentificationProjetDTO())
            );

        if(demandeDTO.getPartiesPrenantesDTO() != null)
            existingDemande.setPartiesPrenantes(
                    partiesPrenantesMapper.fromPartiesPrenanteDTO(demandeDTO.getPartiesPrenantesDTO())
            );

        if(demandeDTO.getObjectifsProjetDTO() != null)
            existingDemande.setObjectifsProjet(
                    objectifsProjetMapper.fromObjectifsProjetDTO(demandeDTO.getObjectifsProjetDTO())
            );

        if(demandeDTO.getDescriptionSommairePrestationsDTO() != null)
            existingDemande.setDescriptionSommairePrestations(
                    descriptionSommairePrestationsMapper.fromDescriptionSommairePrestationsDTO(
                            demandeDTO.getDescriptionSommairePrestationsDTO()
                    )
            );

        if(demandeDTO.getInformationsProjetDTO() != null)
            existingDemande.setInformationsProjet(
                    informationsProjetMapper.fromInformationsProjetDTO(demandeDTO.getInformationsProjetDTO())
            );

        if(demandeDTO.getProjetsRelationDTO() != null)
            existingDemande.setProjetsRelation(
                    projetsRelationMapper.fromProjetsRelationDTO(demandeDTO.getProjetsRelationDTO())
            );

        if(demandeDTO.getDemandeur() != null)
            existingDemande.setDemandeur(utilisateurMapper.fromDemandeurDTO(demandeDTO.getDemandeur()));

        if(demandeDTO.getResponsablePMO() != null)
            existingDemande.setResponsablePMO(utilisateurMapper.fromResponsablePMODTO(demandeDTO.getResponsablePMO()));

        Demande updatedDemande = demandeRepository.save(existingDemande);
        return demandeMapper.fromDemande(updatedDemande);
    }

    @Override
    public void deleteById(Long id) throws DemandeNotFoundException {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(()->new DemandeNotFoundException("Demande non trouvé avec l'ID : " + id));
        demandeRepository.delete(demande);
        System.out.println("Demande avec l'ID "+id+" a été supprimé avec succès");
    }

    @Override
    public void deleteByDemandeurId(Long id) throws DemandeNotFoundException {
        Demande demande = demandeRepository.findByDemandeurIdUtilisateur(id)
                .orElseThrow(() -> new DemandeNotFoundException("Aucune demande trouvée pour le Demandeur avec ID : " + id));
        demandeRepository.delete(demande);
        System.out.println("Demande liée au Demandeur ID " + id + " a été supprimée avec succès.");
    }

    @Override
    public void deleteByResponsablePMO(Long id) throws DemandeNotFoundException {
        Demande demande = demandeRepository.findByResponsablePMO_IdUtilisateur(id)
                .orElseThrow(() -> new DemandeNotFoundException("Aucune demande trouvée pour le Responsable PMO avec ID : " + id));
        demandeRepository.delete(demande);
        System.out.println("Demande liée au Responsable PMO ID " + id + " a été supprimée avec succès.");
    }
}
