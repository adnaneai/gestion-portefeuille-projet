package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.TypeRelationDTO;
import ma.onep.gestionportefeuilleprojet.entities.TypeRelation;
import ma.onep.gestionportefeuilleprojet.entities.ProjetsRelation;
import ma.onep.gestionportefeuilleprojet.exceptions.TypeRelationNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.TypeRelationMapper;
import ma.onep.gestionportefeuilleprojet.mappers.ProjetsRelationMapper;
import ma.onep.gestionportefeuilleprojet.repository.TypeRelationRepository;
import ma.onep.gestionportefeuilleprojet.repository.ProjetsRelationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TypeRelationServiceImp implements TypeRelationService {

    private TypeRelationRepository typeRelationRepository;
    private ProjetsRelationRepository projetsRelationRepository;
    private TypeRelationMapper typeRelationMapper;
    private ProjetsRelationMapper projetsRelationMapper;

    @Override
    public List<TypeRelationDTO> findAllTypeRelation() {
        List<TypeRelation> typeRelations = typeRelationRepository.findAll();
        return typeRelations.stream()
                .map(typeRelationMapper::fromTypeRelation)
                .collect(Collectors.toList());
    }

    @Override
    public TypeRelationDTO findTypeRelationById(Long id) throws TypeRelationNotFoundException {
        TypeRelation typeRelation = typeRelationRepository.findById(id)
                .orElseThrow(() -> new TypeRelationNotFoundException("TypeRelation non trouvé avec l'ID: " + id));
        return typeRelationMapper.fromTypeRelation(typeRelation);
    }

    @Override
    public TypeRelationDTO findTypeRelationByName(String nomTypeRelation) throws TypeRelationNotFoundException {
        TypeRelation typeRelation = typeRelationRepository.findByNomTypeRelation(nomTypeRelation)
                .orElseThrow(() -> new TypeRelationNotFoundException("TypeRelation non trouvé avec le nom: " + nomTypeRelation));
        return typeRelationMapper.fromTypeRelation(typeRelation);
    }

    @Override
    public TypeRelationDTO saveTypeRelation(TypeRelationDTO typeRelationDTO) throws TypeRelationNotFoundException {
        TypeRelation typeRelation = typeRelationMapper.fromTypeRelationDTO(typeRelationDTO);

        // Gestion de la relation avec ProjetsRelation si le DTO est fourni
        if (typeRelationDTO.getProjetsRelationDTO() != null) {
            // Convertir le DTO en entité pour récupérer l'ID
            ProjetsRelation projetsRelation = projetsRelationMapper.fromProjetsRelationDTO(typeRelationDTO.getProjetsRelationDTO());

            // Si l'entité a un ID (existant en base), on l'associe
            if (projetsRelation.getIdProjetRelation() != null) {
                // Vérifier que l'entité existe en base
                ProjetsRelation existingProjetsRelation = projetsRelationRepository
                        .findById(projetsRelation.getIdProjetRelation())
                        .orElseThrow(() -> new TypeRelationNotFoundException(
                                "ProjetsRelation non trouvé avec l'ID: " + projetsRelation.getIdProjetRelation()));

                typeRelation.setProjetsRelation(existingProjetsRelation);
            } else {
                // Si c'est une nouvelle ProjetsRelation, on la sauvegarde d'abord
                ProjetsRelation savedProjetsRelation = projetsRelationRepository.save(projetsRelation);
                typeRelation.setProjetsRelation(savedProjetsRelation);
            }
        }

        TypeRelation savedTypeRelation = typeRelationRepository.save(typeRelation);
        return typeRelationMapper.fromTypeRelation(savedTypeRelation);
    }

    @Override
    public TypeRelationDTO updateTypeRelation(Long id, TypeRelationDTO typeRelationDTO) throws TypeRelationNotFoundException {
        TypeRelation existingTypeRelation = typeRelationRepository.findById(id)
                .orElseThrow(() -> new TypeRelationNotFoundException("TypeRelation non trouvé avec l'ID: " + id));

        // Mise à jour du nom
        if (typeRelationDTO.getNomTypeRelation() != null) {
            existingTypeRelation.setNomTypeRelation(typeRelationDTO.getNomTypeRelation());
        }

        // Mise à jour de la relation ProjetsRelation si fournie
        if (typeRelationDTO.getProjetsRelationDTO() != null) {
            // Convertir le DTO en entité pour récupérer l'ID
            ProjetsRelation projetsRelation = projetsRelationMapper.fromProjetsRelationDTO(typeRelationDTO.getProjetsRelationDTO());

            if (projetsRelation.getIdProjetRelation() != null) {
                // Vérifier que l'entité existe en base
                ProjetsRelation existingProjetsRelation = projetsRelationRepository
                        .findById(projetsRelation.getIdProjetRelation())
                        .orElseThrow(() -> new TypeRelationNotFoundException(
                                "ProjetsRelation non trouvé avec l'ID: " + projetsRelation.getIdProjetRelation()));

                existingTypeRelation.setProjetsRelation(existingProjetsRelation);
            } else {
                // Si c'est une nouvelle ProjetsRelation, on la sauvegarde d'abord
                ProjetsRelation savedProjetsRelation = projetsRelationRepository.save(projetsRelation);
                existingTypeRelation.setProjetsRelation(savedProjetsRelation);
            }
        }

        TypeRelation updatedTypeRelation = typeRelationRepository.save(existingTypeRelation);
        return typeRelationMapper.fromTypeRelation(updatedTypeRelation);
    }

    @Override
    public void deleteTypeRelation(Long id) throws TypeRelationNotFoundException {
        if (!typeRelationRepository.existsById(id)) {
            throw new TypeRelationNotFoundException("TypeRelation non trouvé avec l'ID: " + id);
        }
        typeRelationRepository.deleteById(id);
    }
}