package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DesignationProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.DesignationProjet;
import ma.onep.gestionportefeuilleprojet.entities.ProjetsRelation;
import ma.onep.gestionportefeuilleprojet.exceptions.DesignationProjetNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.DesignationProjetMapper;
import ma.onep.gestionportefeuilleprojet.mappers.ProjetsRelationMapper;
import ma.onep.gestionportefeuilleprojet.repository.DesignationProjetRepository;
import ma.onep.gestionportefeuilleprojet.repository.ProjetsRelationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DesignationProjetServiceImp implements DesignationProjetService {

    private DesignationProjetRepository designationProjetRepository;
    private ProjetsRelationRepository projetsRelationRepository;
    private DesignationProjetMapper designationProjetMapper;
    private ProjetsRelationMapper projetsRelationMapper;

    @Override
    public List<DesignationProjetDTO> findAllDesignationProjet() {
        List<DesignationProjet> designationProjets = designationProjetRepository.findAll();
        return designationProjets.stream()
                .map(designationProjetMapper::fromDesignationProjet)
                .collect(Collectors.toList());
    }

    @Override
    public DesignationProjetDTO findDesignationProjetById(Long id) throws DesignationProjetNotFoundException {
        DesignationProjet designationProjet = designationProjetRepository.findById(id)
                .orElseThrow(() -> new DesignationProjetNotFoundException("DesignationProjet non trouvé avec l'ID: " + id));
        return designationProjetMapper.fromDesignationProjet(designationProjet);
    }

    @Override
    public DesignationProjetDTO findDesignationProjetByName(String nomDesignationProjet) throws DesignationProjetNotFoundException {
        DesignationProjet designationProjet = designationProjetRepository.findByNomDesignationProjet(nomDesignationProjet)
                .orElseThrow(() -> new DesignationProjetNotFoundException("DesignationProjet non trouvé avec le nom: " + nomDesignationProjet));
        return designationProjetMapper.fromDesignationProjet(designationProjet);
    }

    @Override
    public DesignationProjetDTO saveDesignationProjet(DesignationProjetDTO designationProjetDTO) throws DesignationProjetNotFoundException {
        DesignationProjet designationProjet = designationProjetMapper.fromDesignationProjetDTO(designationProjetDTO);

        // Gestion de la relation avec ProjetsRelation si le DTO est fourni
        if (designationProjetDTO.getProjetsRelationDTO() != null) {
            // Convertir le DTO en entité pour récupérer l'ID
            ProjetsRelation projetsRelation = projetsRelationMapper.fromProjetsRelationDTO(designationProjetDTO.getProjetsRelationDTO());

            // Si l'entité a un ID (existant en base), on l'associe
            if (projetsRelation.getIdProjetRelation() != null) {
                // Vérifier que l'entité existe en base
                ProjetsRelation existingProjetsRelation = projetsRelationRepository
                        .findById(projetsRelation.getIdProjetRelation())
                        .orElseThrow(() -> new DesignationProjetNotFoundException(
                                "ProjetsRelation non trouvé avec l'ID: " + projetsRelation.getIdProjetRelation()));

                designationProjet.setProjetsRelation(existingProjetsRelation);
            } else {
                // Si c'est une nouvelle ProjetsRelation, on la sauvegarde d'abord
                ProjetsRelation savedProjetsRelation = projetsRelationRepository.save(projetsRelation);
                designationProjet.setProjetsRelation(savedProjetsRelation);
            }
        }

        DesignationProjet savedDesignationProjet = designationProjetRepository.save(designationProjet);
        return designationProjetMapper.fromDesignationProjet(savedDesignationProjet);
    }

    @Override
    public DesignationProjetDTO updateDesignationProjet(Long id, DesignationProjetDTO designationProjetDTO) throws DesignationProjetNotFoundException {
        DesignationProjet existingDesignationProjet = designationProjetRepository.findById(id)
                .orElseThrow(() -> new DesignationProjetNotFoundException("DesignationProjet non trouvé avec l'ID: " + id));

        // Mise à jour du nom
        if (designationProjetDTO.getNomDesignationProjet() != null) {
            existingDesignationProjet.setNomDesignationProjet(designationProjetDTO.getNomDesignationProjet());
        }

        // Mise à jour de la relation ProjetsRelation si fournie
        if (designationProjetDTO.getProjetsRelationDTO() != null) {
            // Convertir le DTO en entité pour récupérer l'ID
            ProjetsRelation projetsRelation = projetsRelationMapper.fromProjetsRelationDTO(designationProjetDTO.getProjetsRelationDTO());

            if (projetsRelation.getIdProjetRelation() != null) {
                // Vérifier que l'entité existe en base
                ProjetsRelation existingProjetsRelation = projetsRelationRepository
                        .findById(projetsRelation.getIdProjetRelation())
                        .orElseThrow(() -> new DesignationProjetNotFoundException(
                                "ProjetsRelation non trouvé avec l'ID: " + projetsRelation.getIdProjetRelation()));

                existingDesignationProjet.setProjetsRelation(existingProjetsRelation);
            } else {
                // Si c'est une nouvelle ProjetsRelation, on la sauvegarde d'abord
                ProjetsRelation savedProjetsRelation = projetsRelationRepository.save(projetsRelation);
                existingDesignationProjet.setProjetsRelation(savedProjetsRelation);
            }
        }

        DesignationProjet updatedDesignationProjet = designationProjetRepository.save(existingDesignationProjet);
        return designationProjetMapper.fromDesignationProjet(updatedDesignationProjet);
    }

    @Override
    public void deleteDesignationProjet(Long id) throws DesignationProjetNotFoundException {
        if (!designationProjetRepository.existsById(id)) {
            throw new DesignationProjetNotFoundException("DesignationProjet non trouvé avec l'ID: " + id);
        }
        designationProjetRepository.deleteById(id);
    }
}