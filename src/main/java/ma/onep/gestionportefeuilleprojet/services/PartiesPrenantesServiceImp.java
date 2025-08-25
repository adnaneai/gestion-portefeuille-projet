package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.PartiesPrenantesDTO;
import ma.onep.gestionportefeuilleprojet.entities.PartiesPrenantes;
import ma.onep.gestionportefeuilleprojet.exceptions.PartiesPrenantesNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.DemandeMapper;
import ma.onep.gestionportefeuilleprojet.mappers.PartiesPrenantesMapper;
import ma.onep.gestionportefeuilleprojet.repository.PartiesPrenantesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PartiesPrenantesServiceImp implements PartiesPrenantesService {

    private final PartiesPrenantesRepository partiesPrenantesRepository;
    private final PartiesPrenantesMapper partiesPrenantesMapper;
    private final DemandeMapper demandeMapper;

    @Override
    public List<PartiesPrenantesDTO> findAll() {
        List<PartiesPrenantes> partiesPrenantes = partiesPrenantesRepository.findAll();
        return partiesPrenantes.stream()
                .map(partiesPrenantesMapper::fromPartiesPrenante)
                .collect(Collectors.toList());
    }

    @Override
    public PartiesPrenantesDTO findById(Long id) throws PartiesPrenantesNotFoundException {
        PartiesPrenantes partiesPrenantes = partiesPrenantesRepository.findById(id)
                .orElseThrow(() -> new PartiesPrenantesNotFoundException("PartiesPrenantes non trouvée avec l'ID: " + id));
        return partiesPrenantesMapper.fromPartiesPrenante(partiesPrenantes);
    }

    @Override
    public List<PartiesPrenantesDTO> findAllPartiesPrenantesByMOA(String moa) throws PartiesPrenantesNotFoundException {
        List<PartiesPrenantes> partiesPrenantes = partiesPrenantesRepository.findByMoaContainingIgnoreCase(moa);
        if (partiesPrenantes.isEmpty()) {
            throw new PartiesPrenantesNotFoundException("Aucune PartiesPrenantes trouvée avec le MOA: " + moa);
        }
        return partiesPrenantes.stream()
                .map(partiesPrenantesMapper::fromPartiesPrenante)
                .collect(Collectors.toList());
    }

    @Override
    public List<PartiesPrenantesDTO> findAllPartiesPrenantesByMOE(String moe) throws PartiesPrenantesNotFoundException {
        List<PartiesPrenantes> partiesPrenantes = partiesPrenantesRepository.findByMoeContainingIgnoreCase(moe);
        if (partiesPrenantes.isEmpty()) {
            throw new PartiesPrenantesNotFoundException("Aucune PartiesPrenantes trouvée avec le MOE: " + moe);
        }
        return partiesPrenantes.stream()
                .map(partiesPrenantesMapper::fromPartiesPrenante)
                .collect(Collectors.toList());
    }

    @Override
    public List<PartiesPrenantesDTO> findAllPartiesPrenantesByAMO(String amo) throws PartiesPrenantesNotFoundException {
        List<PartiesPrenantes> partiesPrenantes = partiesPrenantesRepository.findByAmoContainingIgnoreCase(amo);
        if (partiesPrenantes.isEmpty()) {
            throw new PartiesPrenantesNotFoundException("Aucune PartiesPrenantes trouvée avec l'AMO: " + amo);
        }
        return partiesPrenantes.stream()
                .map(partiesPrenantesMapper::fromPartiesPrenante)
                .collect(Collectors.toList());
    }

    @Override
    public PartiesPrenantesDTO savePartiesPrenantes(PartiesPrenantesDTO partiesPrenantesDTO) throws PartiesPrenantesNotFoundException {
        PartiesPrenantes partiesPrenantes = partiesPrenantesMapper.fromPartiesPrenanteDTO(partiesPrenantesDTO);
        PartiesPrenantes savedPartiesPrenantes = partiesPrenantesRepository.save(partiesPrenantes);
        return partiesPrenantesMapper.fromPartiesPrenante(savedPartiesPrenantes);
    }

    @Override
    public PartiesPrenantesDTO updatePartiesPrenantesById(Long idPartiesPrenantes, PartiesPrenantesDTO partiesPrenantesDTO) throws PartiesPrenantesNotFoundException {
        PartiesPrenantes existingPartiesPrenantes = partiesPrenantesRepository.findById(idPartiesPrenantes)
                .orElseThrow(() -> new PartiesPrenantesNotFoundException("PartiesPrenantes non trouvée avec l'ID: " + idPartiesPrenantes));

        // Mise à jour des champs
        if (partiesPrenantesDTO.getMoa() != null) {
            existingPartiesPrenantes.setMoa(partiesPrenantesDTO.getMoa());
        }
        if (partiesPrenantesDTO.getMoe() != null) {
            existingPartiesPrenantes.setMoe(partiesPrenantesDTO.getMoe());
        }
        if (partiesPrenantesDTO.getAmo() != null) {
            existingPartiesPrenantes.setAmo(partiesPrenantesDTO.getAmo());
        }

        if (partiesPrenantesDTO.getDemandeDTO() != null) {
            existingPartiesPrenantes.setDemande(demandeMapper.fromDemandeDTO(partiesPrenantesDTO.getDemandeDTO()));
        }

        PartiesPrenantes updatedPartiesPrenantes = partiesPrenantesRepository.save(existingPartiesPrenantes);
        return partiesPrenantesMapper.fromPartiesPrenante(updatedPartiesPrenantes);
    }

    @Override
    public void deletePartiesPrenantesById(Long idPartiesPrenantes) throws PartiesPrenantesNotFoundException {
        if (!partiesPrenantesRepository.existsById(idPartiesPrenantes)) {
            throw new PartiesPrenantesNotFoundException("PartiesPrenantes non trouvée avec l'ID: " + idPartiesPrenantes);
        }
        partiesPrenantesRepository.deleteById(idPartiesPrenantes);
        System.out.println("Parties Prenantes avec l'ID " + idPartiesPrenantes + " a été supprimée avec succès");
    }
}