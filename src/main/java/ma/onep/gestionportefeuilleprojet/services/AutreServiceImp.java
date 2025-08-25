package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.AutreDTO;
import ma.onep.gestionportefeuilleprojet.entities.Autre;
import ma.onep.gestionportefeuilleprojet.entities.PartiesPrenantes;
import ma.onep.gestionportefeuilleprojet.exceptions.AutreNotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.PartiesPrenantesNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.AutreMapper;
import ma.onep.gestionportefeuilleprojet.mappers.PartiesPrenantesMapper;
import ma.onep.gestionportefeuilleprojet.repository.AutreRepository;
import ma.onep.gestionportefeuilleprojet.repository.PartiesPrenantesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AutreServiceImp implements AutreService {

    private AutreRepository autreRepository;
    private PartiesPrenantesRepository partiesPrenantesRepository;
    private AutreMapper autreMapper;
    private PartiesPrenantesMapper partiesPrenantesMapper;

    @Override
    public List<AutreDTO> findAll() {
        List<Autre> autres = autreRepository.findAll();
        return autres.stream()
                .map(autreMapper::fromAutre)
                .collect(Collectors.toList());
    }

    @Override
    public AutreDTO findById(Long id) throws AutreNotFoundException {
        Autre autre = autreRepository.findById(id)
                .orElseThrow(() -> new AutreNotFoundException("Autre non trouvé avec l'ID: " + id));
        return autreMapper.fromAutre(autre);
    }

    @Override
    public AutreDTO save(AutreDTO autreDTO) throws AutreNotFoundException {
        Autre autre = autreMapper.fromAutreDTO(autreDTO);

        // Gestion de la relation avec PartiesPrenantes via le mapping DTO -> Entity
        if (autreDTO.getPartiesPrenantesDTO() != null) {
            PartiesPrenantes partiesPrenantes = partiesPrenantesMapper.fromPartiesPrenanteDTO(autreDTO.getPartiesPrenantesDTO());

            // Si l'entité PartiesPrenantes a un ID, vérifier qu'elle existe
            if (partiesPrenantes.getIdPartiesPrenantes() != null) {
                PartiesPrenantes existingPartiesPrenantes = partiesPrenantesRepository
                        .findById(partiesPrenantes.getIdPartiesPrenantes())
                        .orElseThrow(() -> new PartiesPrenantesNotFoundException(
                                "PartiesPrenantes non trouvée avec l'ID: " + partiesPrenantes.getIdPartiesPrenantes()));

                autre.setPartiesPrenantes(existingPartiesPrenantes);
            } else {
                // Si nouvelle PartiesPrenantes, sauvegarder d'abord
                PartiesPrenantes savedPartiesPrenantes = partiesPrenantesRepository.save(partiesPrenantes);
                autre.setPartiesPrenantes(savedPartiesPrenantes);
            }
        }

        Autre savedAutre = autreRepository.save(autre);
        return autreMapper.fromAutre(savedAutre);
    }

    @Override
    public AutreDTO update(Long id, AutreDTO autreDTO) throws AutreNotFoundException {
        // Vérifier que l'entité existe
        Autre existingAutre = autreRepository.findById(id)
                .orElseThrow(() -> new AutreNotFoundException("Autre non trouvé avec l'ID: " + id));

        // Mettre à jour le nom si fourni dans le DTO
        if (autreDTO.getNomAutre() != null) {
            existingAutre.setNomAutre(autreDTO.getNomAutre());
        }

        // Mise à jour de la relation PartiesPrenantes via le mapping DTO -> Entity
        if (autreDTO.getPartiesPrenantesDTO() != null) {
            PartiesPrenantes partiesPrenantes = partiesPrenantesMapper.fromPartiesPrenanteDTO(autreDTO.getPartiesPrenantesDTO());

            if (partiesPrenantes.getIdPartiesPrenantes() != null) {
                PartiesPrenantes existingPartiesPrenantes = partiesPrenantesRepository
                        .findById(partiesPrenantes.getIdPartiesPrenantes())
                        .orElseThrow(() -> new PartiesPrenantesNotFoundException(
                                "PartiesPrenantes non trouvée avec l'ID: " + partiesPrenantes.getIdPartiesPrenantes()));

                existingAutre.setPartiesPrenantes(existingPartiesPrenantes);
            } else {
                PartiesPrenantes savedPartiesPrenantes = partiesPrenantesRepository.save(partiesPrenantes);
                existingAutre.setPartiesPrenantes(savedPartiesPrenantes);
            }
        } else {
            // Si aucune PartiesPrenantes n'est fournie, dissocier l'existante
            existingAutre.setPartiesPrenantes(null);
        }

        Autre updatedAutre = autreRepository.save(existingAutre);
        return autreMapper.fromAutre(updatedAutre);
    }

    @Override
    public void delete(Long id) throws AutreNotFoundException {
        if (!autreRepository.existsById(id)) {
            throw new AutreNotFoundException("Autre non trouvé avec l'ID: " + id);
        }
        autreRepository.deleteById(id);
        System.out.println();
    }
}