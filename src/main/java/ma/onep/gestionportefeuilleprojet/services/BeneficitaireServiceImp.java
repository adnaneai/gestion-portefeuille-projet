package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.BeneficitaireDTO;
import ma.onep.gestionportefeuilleprojet.entities.Beneficitaire;
import ma.onep.gestionportefeuilleprojet.entities.PartiesPrenantes;
import ma.onep.gestionportefeuilleprojet.exceptions.BeneficitaireNotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.PartiesPrenantesNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.BeneficitaireMapper;
import ma.onep.gestionportefeuilleprojet.mappers.PartiesPrenantesMapper;
import ma.onep.gestionportefeuilleprojet.repository.BeneficitaireRepository;
import ma.onep.gestionportefeuilleprojet.repository.PartiesPrenantesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BeneficitaireServiceImp implements BeneficitaireService {

    private BeneficitaireRepository beneficitaireRepository;
    private PartiesPrenantesRepository partiesPrenantesRepository;
    private BeneficitaireMapper beneficitaireMapper;
    private PartiesPrenantesMapper partiesPrenantesMapper;

    @Override
    public List<BeneficitaireDTO> findAll() {
        List<Beneficitaire> beneficiaires = beneficitaireRepository.findAll();
        return beneficiaires.stream()
                .map(beneficitaireMapper::fromBeneficitaire)
                .collect(Collectors.toList());
    }

    @Override
    public BeneficitaireDTO findById(Long id) throws BeneficitaireNotFoundException {
        Beneficitaire beneficitaire = beneficitaireRepository.findById(id)
                .orElseThrow(() -> new BeneficitaireNotFoundException("Bénéficiaire non trouvé avec l'ID: " + id));
        return beneficitaireMapper.fromBeneficitaire(beneficitaire);
    }

    @Override
    public List<BeneficitaireDTO> findByNomBeneficitaire(String nomBeneficitaire) throws BeneficitaireNotFoundException {
        List<Beneficitaire> beneficiaires = beneficitaireRepository.findByNomBeneficitaireContainingIgnoreCase(nomBeneficitaire);
        if (beneficiaires.isEmpty()) {
            throw new BeneficitaireNotFoundException("Aucun bénéficiaire trouvé avec le nom: " + nomBeneficitaire);
        }
        return beneficiaires.stream()
                .map(beneficitaireMapper::fromBeneficitaire)
                .collect(Collectors.toList());
    }

    @Override
    public BeneficitaireDTO saveBeneficitaire(BeneficitaireDTO beneficitaireDTO) throws BeneficitaireNotFoundException {
        Beneficitaire beneficitaire = beneficitaireMapper.fromBeneficitaireDTO(beneficitaireDTO);

        // Gestion de la relation avec PartiesPrenantes si le DTO est fourni
        if (beneficitaireDTO.getPartiesPrenantesDTO() != null) {
            // Convertir le DTO en entité pour récupérer l'ID
            PartiesPrenantes partiesPrenantes = partiesPrenantesMapper.fromPartiesPrenanteDTO(beneficitaireDTO.getPartiesPrenantesDTO());

            // Si l'entité a un ID (existant en base), on l'associe
            if (partiesPrenantes.getIdPartiesPrenantes() != null) {
                // Vérifier que l'entité existe en base
                PartiesPrenantes existingPartiesPrenantes = partiesPrenantesRepository
                        .findById(partiesPrenantes.getIdPartiesPrenantes())
                        .orElseThrow(() -> new PartiesPrenantesNotFoundException(
                                "PartiesPrenantes non trouvée avec l'ID: " + partiesPrenantes.getIdPartiesPrenantes()));

                beneficitaire.setPartiesPrenantes(existingPartiesPrenantes);
            } else {
                // Si c'est une nouvelle PartiesPrenantes, on la sauvegarde d'abord
                PartiesPrenantes savedPartiesPrenantes = partiesPrenantesRepository.save(partiesPrenantes);
                beneficitaire.setPartiesPrenantes(savedPartiesPrenantes);
            }
        }

        Beneficitaire savedBeneficitaire = beneficitaireRepository.save(beneficitaire);
        return beneficitaireMapper.fromBeneficitaire(savedBeneficitaire);
    }

    @Override
    public BeneficitaireDTO updateBeneficitaireById(Long id, BeneficitaireDTO beneficitaireDTO) throws BeneficitaireNotFoundException {
        Beneficitaire existingBeneficitaire = beneficitaireRepository.findById(id)
                .orElseThrow(() -> new BeneficitaireNotFoundException("Bénéficiaire non trouvé avec l'ID: " + id));

        // Mise à jour du nom
        if (beneficitaireDTO.getNomBeneficitaire() != null) {
            existingBeneficitaire.setNomBeneficitaire(beneficitaireDTO.getNomBeneficitaire());
        }

        // Mise à jour de la relation PartiesPrenantes si fournie
        if (beneficitaireDTO.getPartiesPrenantesDTO() != null) {
            // Convertir le DTO en entité pour récupérer l'ID
            PartiesPrenantes partiesPrenantes = partiesPrenantesMapper.fromPartiesPrenanteDTO(beneficitaireDTO.getPartiesPrenantesDTO());

            if (partiesPrenantes.getIdPartiesPrenantes() != null) {
                // Vérifier que l'entité existe en base
                PartiesPrenantes existingPartiesPrenantes = partiesPrenantesRepository
                        .findById(partiesPrenantes.getIdPartiesPrenantes())
                        .orElseThrow(() -> new PartiesPrenantesNotFoundException(
                                "PartiesPrenantes non trouvée avec l'ID: " + partiesPrenantes.getIdPartiesPrenantes()));

                existingBeneficitaire.setPartiesPrenantes(existingPartiesPrenantes);
            } else {
                // Si c'est une nouvelle PartiesPrenantes, on la sauvegarde d'abord
                PartiesPrenantes savedPartiesPrenantes = partiesPrenantesRepository.save(partiesPrenantes);
                existingBeneficitaire.setPartiesPrenantes(savedPartiesPrenantes);
            }
        }

        Beneficitaire updatedBeneficitaire = beneficitaireRepository.save(existingBeneficitaire);
        return beneficitaireMapper.fromBeneficitaire(updatedBeneficitaire);
    }

    @Override
    public void deleteBeneficitaireById(Long id) throws BeneficitaireNotFoundException {
        if (!beneficitaireRepository.existsById(id)) {
            throw new BeneficitaireNotFoundException("Bénéficiaire non trouvé avec l'ID: " + id);
        }
        beneficitaireRepository.deleteById(id);
    }
}