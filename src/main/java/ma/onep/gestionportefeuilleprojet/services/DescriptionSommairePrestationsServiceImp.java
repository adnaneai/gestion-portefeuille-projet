package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DescriptionSommairePrestationsDTO;
import ma.onep.gestionportefeuilleprojet.entities.DescriptionSommairePrestations;
import ma.onep.gestionportefeuilleprojet.exceptions.DescriptionSommairePrestationsNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.DemandeMapper;
import ma.onep.gestionportefeuilleprojet.mappers.DescriptionSommairePrestationsMapper;
import ma.onep.gestionportefeuilleprojet.repository.DescriptionSommairePrestationsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DescriptionSommairePrestationsServiceImp implements DescriptionSommairePrestationsService {

    private DescriptionSommairePrestationsRepository descriptionSommairePrestationsRepository;
    private DescriptionSommairePrestationsMapper descriptionSommairePrestationsMapper;
    private DemandeMapper demandeMapper;

    @Override
    public List<DescriptionSommairePrestationsDTO> findAllDescriptionSommairePrestations() {
        List<DescriptionSommairePrestations> descriptions = descriptionSommairePrestationsRepository.findAll();
        return descriptions.stream()
                .map(descriptionSommairePrestationsMapper::fromDescriptionSommairePrestations)
                .collect(Collectors.toList());
    }

    @Override
    public DescriptionSommairePrestationsDTO findDescriptionSommairePrestationsById(Long id) throws DescriptionSommairePrestationsNotFoundException {
        DescriptionSommairePrestations description = descriptionSommairePrestationsRepository.findById(id)
                .orElseThrow(() -> new DescriptionSommairePrestationsNotFoundException("DescriptionSommairePrestations non trouvé avec l'ID: " + id));
        return descriptionSommairePrestationsMapper.fromDescriptionSommairePrestations(description);
    }

    @Override
    public DescriptionSommairePrestationsDTO saveDescriptionSommairePrestations(DescriptionSommairePrestationsDTO dto) {
        DescriptionSommairePrestations description = descriptionSommairePrestationsMapper.fromDescriptionSommairePrestationsDTO(dto);
        DescriptionSommairePrestations savedDescription = descriptionSommairePrestationsRepository.save(description);
        return descriptionSommairePrestationsMapper.fromDescriptionSommairePrestations(savedDescription);
    }

    @Override
    public DescriptionSommairePrestationsDTO updateDescriptionSommairePrestations(Long id, DescriptionSommairePrestationsDTO descriptionSommairePrestationsDTO) throws DescriptionSommairePrestationsNotFoundException {
        DescriptionSommairePrestations existingDescription = descriptionSommairePrestationsRepository.findById(id)
                .orElseThrow(() -> new DescriptionSommairePrestationsNotFoundException("DescriptionSommairePrestations non trouvé avec l'ID: " + id));

        if (descriptionSommairePrestationsDTO.getNomDescriptionSommairePrestations() != null) {
            existingDescription.setNomDescriptionSommairePrestations(descriptionSommairePrestationsDTO.getNomDescriptionSommairePrestations());
        }
        if (descriptionSommairePrestationsDTO.getDemandeDTO() != null) {
            existingDescription.setDemande(demandeMapper.fromDemandeDTO(descriptionSommairePrestationsDTO.getDemandeDTO()));
        }

        DescriptionSommairePrestations updatedDescription = descriptionSommairePrestationsRepository.save(existingDescription);
        return descriptionSommairePrestationsMapper.fromDescriptionSommairePrestations(updatedDescription);
    }

    @Override
    public void deleteDescriptionSommairePrestations(Long id) throws DescriptionSommairePrestationsNotFoundException {
        if (!descriptionSommairePrestationsRepository.existsById(id)) {
            throw new DescriptionSommairePrestationsNotFoundException("DescriptionSommairePrestations non trouvé avec l'ID: " + id);
        }
        descriptionSommairePrestationsRepository.deleteById(id);
    }
}