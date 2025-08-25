package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.ObjectifsProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.ObjectifsProjet;
import ma.onep.gestionportefeuilleprojet.exceptions.ObjectifsProjetNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.DemandeMapper;
import ma.onep.gestionportefeuilleprojet.mappers.ObjectifsProjetMapper;
import ma.onep.gestionportefeuilleprojet.repository.ObjectifsProjetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ObjectifsProjetServiceImp implements ObjectifsProjetService {

    private ObjectifsProjetRepository objectifsProjetRepository;
    private ObjectifsProjetMapper objectifsProjetMapper;
    private DemandeMapper demandeMapper;


    @Override
    public List<ObjectifsProjetDTO> findAll() {
        List<ObjectifsProjet> objectifsProjets = objectifsProjetRepository.findAll();
        return objectifsProjets.stream()
                .map(objectifsProjetMapper::fromObjectifsProjet)
                .collect(Collectors.toList());
    }

    @Override
    public ObjectifsProjetDTO findById(Long id) throws ObjectifsProjetNotFoundException {
        ObjectifsProjet objectifsProjet = objectifsProjetRepository.findById(id)
                .orElseThrow(() -> new ObjectifsProjetNotFoundException("ObjectifsProjet non trouvé avec l'ID: " + id));
        return objectifsProjetMapper.fromObjectifsProjet(objectifsProjet);
    }

    @Override
    public List<ObjectifsProjetDTO> findByNomObjectifsProjet(String nomObjectifsProjet) throws ObjectifsProjetNotFoundException {
        List<ObjectifsProjet> objectifsProjets = objectifsProjetRepository.findByNomObjectifsProjetContainingIgnoreCase(nomObjectifsProjet);
        if (objectifsProjets.isEmpty()) {
            throw new ObjectifsProjetNotFoundException("Aucun ObjectifsProjet trouvé avec le nom: " + nomObjectifsProjet);
        }
        return objectifsProjets.stream()
                .map(objectifsProjetMapper::fromObjectifsProjet)
                .collect(Collectors.toList());
    }

    @Override
    public ObjectifsProjetDTO saveObjectifsProjet(ObjectifsProjetDTO objectifsProjetDTO) {
        ObjectifsProjet objectifsProjet = objectifsProjetMapper.fromObjectifsProjetDTO(objectifsProjetDTO);
        ObjectifsProjet savedObjectifsProjet = objectifsProjetRepository.save(objectifsProjet);
        return objectifsProjetMapper.fromObjectifsProjet(savedObjectifsProjet);
    }

    @Override
    public ObjectifsProjetDTO updateObjectifsProjet(Long id, ObjectifsProjetDTO objectifsProjetDTO) throws ObjectifsProjetNotFoundException {
        ObjectifsProjet existingObjectifsProjet = objectifsProjetRepository.findById(id)
                .orElseThrow(() -> new ObjectifsProjetNotFoundException("ObjectifsProjet non trouvé avec l'ID: " + id));

        if (objectifsProjetDTO.getNomObjectifsProjet() != null) {
            existingObjectifsProjet.setNomObjectifsProjet(objectifsProjetDTO.getNomObjectifsProjet());
        }
        if (objectifsProjetDTO.getDemandeDTO() != null) {
            existingObjectifsProjet.setDemande(demandeMapper.fromDemandeDTO(objectifsProjetDTO.getDemandeDTO()));
        }
        ObjectifsProjet updatedObjectifsProjet = objectifsProjetRepository.save(existingObjectifsProjet);
        return objectifsProjetMapper.fromObjectifsProjet(updatedObjectifsProjet);
    }

    @Override
    public void deleteObjectifsProjet(Long id) throws ObjectifsProjetNotFoundException {
        if (!objectifsProjetRepository.existsById(id)) {
            throw new ObjectifsProjetNotFoundException("ObjectifsProjet non trouvé avec l'ID: " + id);
        }
        objectifsProjetRepository.deleteById(id);
    }
}