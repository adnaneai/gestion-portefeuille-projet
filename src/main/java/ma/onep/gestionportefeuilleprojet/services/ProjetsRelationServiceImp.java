package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.ProjetsRelationDTO;
import ma.onep.gestionportefeuilleprojet.entities.ProjetsRelation;
import ma.onep.gestionportefeuilleprojet.exceptions.ProjetsRelationNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.DemandeMapper;
import ma.onep.gestionportefeuilleprojet.mappers.DesignationProjetMapper;
import ma.onep.gestionportefeuilleprojet.mappers.ProjetsRelationMapper;
import ma.onep.gestionportefeuilleprojet.mappers.TypeRelationMapper;
import ma.onep.gestionportefeuilleprojet.repository.ProjetsRelationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProjetsRelationServiceImp implements ProjetsRelationService {

    private ProjetsRelationRepository projetsRelationRepository;
    private ProjetsRelationMapper projetsRelationMapper;
    private DesignationProjetMapper designationProjetMapper;
    private TypeRelationMapper typeRelationMapper;
    private DemandeMapper demandeMapper;

    @Override
    public List<ProjetsRelationDTO> findAllProjetRelation() {
        List<ProjetsRelation> projetsRelations = projetsRelationRepository.findAll();
        return projetsRelations.stream()
                .map(projetsRelationMapper::fromProjetsRelation)
                .collect(Collectors.toList());
    }

    @Override
    public ProjetsRelationDTO findProjetRelationById(Long id) throws ProjetsRelationNotFoundException {
        ProjetsRelation projetsRelation = projetsRelationRepository.findById(id)
                .orElseThrow(() -> new ProjetsRelationNotFoundException("ProjetsRelation non trouvé avec l'ID: " + id));
        return projetsRelationMapper.fromProjetsRelation(projetsRelation);
    }

    @Override
    public ProjetsRelationDTO saveProjetRelation(ProjetsRelationDTO projetsRelationDTO) {
        ProjetsRelation projetsRelation = projetsRelationMapper.fromProjetsRelationDTO(projetsRelationDTO);
        ProjetsRelation savedProjetsRelation = projetsRelationRepository.save(projetsRelation);
        return projetsRelationMapper.fromProjetsRelation(savedProjetsRelation);
    }

    @Override
    public ProjetsRelationDTO updateProjetRelation(Long id, ProjetsRelationDTO projetsRelationDTO) throws ProjetsRelationNotFoundException {
        ProjetsRelation existingProjetsRelation = projetsRelationRepository.findById(id)
                .orElseThrow(() -> new ProjetsRelationNotFoundException("ProjetsRelation non trouvé avec l'ID: " + id));

        // Mise à jour des DesignationProjet (pas forcément non null)
        if (projetsRelationDTO.getDesignationProjetDTOS() != null) {
            existingProjetsRelation.setDesignationProjets(
                    projetsRelationDTO.getDesignationProjetDTOS().stream()
                            .map(designationProjetMapper::fromDesignationProjetDTO)
                            .collect(Collectors.toList())
            );
        }

        // Mise à jour des TypeRelation (pas forcément non null)
        if (projetsRelationDTO.getTypeRelationDTOS() != null) {
            existingProjetsRelation.setTypeRelations(
                    projetsRelationDTO.getTypeRelationDTOS().stream()
                            .map(typeRelationMapper::fromTypeRelationDTO)
                            .collect(Collectors.toList())
            );
        }

        // Mise à jour de la Demande (pas forcément non null)
        if (projetsRelationDTO.getDemandeDTO() != null) {
            existingProjetsRelation.setDemande(demandeMapper.fromDemandeDTO(projetsRelationDTO.getDemandeDTO()));
        }

        ProjetsRelation updatedProjetsRelation = projetsRelationRepository.save(existingProjetsRelation);
        return projetsRelationMapper.fromProjetsRelation(updatedProjetsRelation);
    }

    @Override
    public ProjetsRelationDTO deleteProjetRelation(Long id) throws ProjetsRelationNotFoundException {
        ProjetsRelation projetsRelation = projetsRelationRepository.findById(id)
                .orElseThrow(() -> new ProjetsRelationNotFoundException("ProjetsRelation non trouvé avec l'ID: " + id));

        ProjetsRelationDTO deletedProjetsRelationDTO = projetsRelationMapper.fromProjetsRelation(projetsRelation);
        projetsRelationRepository.deleteById(id);

        return deletedProjetsRelationDTO;
    }
}