package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.IdentificationProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.IdentificationProjet;
import ma.onep.gestionportefeuilleprojet.exceptions.IdentificationProjetNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.DemandeMapper;
import ma.onep.gestionportefeuilleprojet.mappers.IdentificationProjetMapper;
import ma.onep.gestionportefeuilleprojet.repository.IdentificationProjetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class IdentificationProjetServiceImp implements IdentificationProjetService {
    private IdentificationProjetRepository identificationProjetRepository;
    private IdentificationProjetMapper identificationProjetMapper;
    private DemandeMapper demandeMapper;

    @Override
    public List<IdentificationProjetDTO> findAllIdentificationProjets() {
        List<IdentificationProjet> identificationProjets = identificationProjetRepository.findAll();
        return identificationProjets.stream()
                .map(identificationProjetMapper::fromIdentificationProjet)
                .collect(Collectors.toList());
    }

    @Override
    public IdentificationProjetDTO findByIdIdentificationProjet(Long idIdentificationProjet) throws IdentificationProjetNotFoundException {
        IdentificationProjet identificationProjet = identificationProjetRepository.findById(idIdentificationProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'ID: " + idIdentificationProjet));
        return identificationProjetMapper.fromIdentificationProjet(identificationProjet);
    }

    @Override
    public IdentificationProjetDTO findByCodeIdentificationProjet(String codeIdentificationProjet) throws IdentificationProjetNotFoundException {
        IdentificationProjet identificationProjet = identificationProjetRepository.findByCode(codeIdentificationProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec le code: " + codeIdentificationProjet));
        return identificationProjetMapper.fromIdentificationProjet(identificationProjet);
    }

    @Override
    public IdentificationProjetDTO findByIdProjetIdentificationProjet(String idProjetIdentification) throws IdentificationProjetNotFoundException {
       IdentificationProjet identificationProjet = identificationProjetRepository.findByIdProjet(idProjetIdentification)
               .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'ID Projet: " + idProjetIdentification));
        return identificationProjetMapper.fromIdentificationProjet(identificationProjet);
    }

    @Override
    public IdentificationProjetDTO findByIntituleProjetIdentificationProjet(String intituleIdentificationProjet) throws IdentificationProjetNotFoundException {
        IdentificationProjet identificationProjet = identificationProjetRepository.findByIntituleProjet(intituleIdentificationProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'intitule Projet: " + intituleIdentificationProjet));
        return identificationProjetMapper.fromIdentificationProjet(identificationProjet);
    }

    @Override
    public IdentificationProjetDTO saveIdentificationProjet(IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException{
        if (identificationProjetRepository.existsIdentificationProjetByCode(identificationProjetDTO.getCode())){
            throw new IdentificationProjetNotFoundException("Le code '" + identificationProjetDTO.getCode() + "' existe déjà");
        } else if (identificationProjetRepository.existsIdentificationProjetByIdProjet(identificationProjetDTO.getIdProjet())) {
            throw new IdentificationProjetNotFoundException("L'ID Projet '" + identificationProjetDTO.getIdProjet() + "' existe déjà");
        } else if (identificationProjetRepository.existsIdentificationProjetByIntituleProjet(identificationProjetDTO.getIntituleProjet())) {
            throw new IdentificationProjetNotFoundException("L'intitule de projet '" + identificationProjetDTO.getIntituleProjet() + "' existe déjà");
        }
        IdentificationProjet identificationProjet = identificationProjetMapper.fromIdentificationProjetDTO(identificationProjetDTO);
        IdentificationProjet savedIdentificationProjet = identificationProjetRepository.save(identificationProjet);
        return identificationProjetMapper.fromIdentificationProjet(savedIdentificationProjet);
    }

    @Override
    public IdentificationProjetDTO updateIdentificationProjetByIdIdentificationProjet(Long idIdentificationProjet, IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {

        // Récupérer l'entité existante d'abord
        IdentificationProjet existingIdentificationProjet = identificationProjetRepository.findById(idIdentificationProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'ID: " + idIdentificationProjet));

        // Vérifier si le code existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getCode() != null &&
                !identificationProjetDTO.getCode().equals(existingIdentificationProjet.getCode()) &&
                identificationProjetRepository.existsIdentificationProjetByCode(identificationProjetDTO.getCode())) {
            throw new IdentificationProjetNotFoundException("Le code '" + identificationProjetDTO.getCode() + "' existe déjà");
        }

        // Vérifier si l'ID Projet existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getIdProjet() != null &&
                !identificationProjetDTO.getIdProjet().equals(existingIdentificationProjet.getIdProjet()) &&
                identificationProjetRepository.existsIdentificationProjetByIdProjet(identificationProjetDTO.getIdProjet())) {
            throw new IdentificationProjetNotFoundException("L'ID Projet '" + identificationProjetDTO.getIdProjet() + "' existe déjà");
        }

        // Vérifier si l'intitulé existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getIntituleProjet() != null &&
                !identificationProjetDTO.getIntituleProjet().equals(existingIdentificationProjet.getIntituleProjet()) &&
                identificationProjetRepository.existsIdentificationProjetByIntituleProjet(identificationProjetDTO.getIntituleProjet())) {
            throw new IdentificationProjetNotFoundException("L'intitule de projet '" + identificationProjetDTO.getIntituleProjet() + "' existe déjà");
        }

        // Mise à jour des champs
        if (identificationProjetDTO.getCode() != null) {
            existingIdentificationProjet.setCode(identificationProjetDTO.getCode());
        }
        if (identificationProjetDTO.getIdProjet() != null) {
            existingIdentificationProjet.setIdProjet(identificationProjetDTO.getIdProjet());
        }
        if (identificationProjetDTO.getIntituleProjet() != null) {
            existingIdentificationProjet.setIntituleProjet(identificationProjetDTO.getIntituleProjet());
        }
        if (identificationProjetDTO.getTypeProjet() != null) {
            existingIdentificationProjet.setTypeProjet(identificationProjetDTO.getTypeProjet());
        }
        if (identificationProjetDTO.getEtapeActuelleProjet() != null) {
            existingIdentificationProjet.setEtapeActuelleProjet(identificationProjetDTO.getEtapeActuelleProjet());
        }
        if (identificationProjetDTO.getDemandeDTO() != null) {
            existingIdentificationProjet.setDemande(demandeMapper.fromDemandeDTO(identificationProjetDTO.getDemandeDTO()));
        }

        IdentificationProjet updateIdentificationProjet = identificationProjetRepository.save(existingIdentificationProjet);
        return identificationProjetMapper.fromIdentificationProjet(updateIdentificationProjet);
    }

    @Override
    public IdentificationProjetDTO updateIdentificationProjetByCode(String codeIdentificationProjet, IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {

        // Récupérer l'entité existante d'abord
        IdentificationProjet existingIdentificationProjet = identificationProjetRepository.findByCode(codeIdentificationProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec le code: " + codeIdentificationProjet));

        // Vérifier si l'ID Projet existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getIdProjet() != null &&
                !identificationProjetDTO.getIdProjet().equals(existingIdentificationProjet.getIdProjet()) &&
                identificationProjetRepository.existsIdentificationProjetByIdProjet(identificationProjetDTO.getIdProjet())) {
            throw new IdentificationProjetNotFoundException("L'ID Projet '" + identificationProjetDTO.getIdProjet() + "' existe déjà");
        }

        // Vérifier si l'intitulé existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getIntituleProjet() != null &&
                !identificationProjetDTO.getIntituleProjet().equals(existingIdentificationProjet.getIntituleProjet()) &&
                identificationProjetRepository.existsIdentificationProjetByIntituleProjet(identificationProjetDTO.getIntituleProjet())) {
            throw new IdentificationProjetNotFoundException("L'intitule de projet '" + identificationProjetDTO.getIntituleProjet() + "' existe déjà");
        }

        // Mise à jour des champs (le code ne change pas car on recherche par code)
        if (identificationProjetDTO.getIdProjet() != null) {
            existingIdentificationProjet.setIdProjet(identificationProjetDTO.getIdProjet());
        }
        if (identificationProjetDTO.getIntituleProjet() != null) {
            existingIdentificationProjet.setIntituleProjet(identificationProjetDTO.getIntituleProjet());
        }
        if (identificationProjetDTO.getTypeProjet() != null) {
            existingIdentificationProjet.setTypeProjet(identificationProjetDTO.getTypeProjet());
        }
        if (identificationProjetDTO.getEtapeActuelleProjet() != null) {
            existingIdentificationProjet.setEtapeActuelleProjet(identificationProjetDTO.getEtapeActuelleProjet());
        }
        if (identificationProjetDTO.getDemandeDTO() != null) {
            existingIdentificationProjet.setDemande(demandeMapper.fromDemandeDTO(identificationProjetDTO.getDemandeDTO()));
        }

        IdentificationProjet updateIdentificationProjet = identificationProjetRepository.save(existingIdentificationProjet);
        return identificationProjetMapper.fromIdentificationProjet(updateIdentificationProjet);
    }

    @Override
    public IdentificationProjetDTO updateIdentificationProjetByIdProjet(String idProjet, IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {

        // Récupérer l'entité existante d'abord
        IdentificationProjet existingIdentificationProjet = identificationProjetRepository.findByIdProjet(idProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'ID Projet: " + idProjet));

        // Vérifier si le code existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getCode() != null &&
                !identificationProjetDTO.getCode().equals(existingIdentificationProjet.getCode()) &&
                identificationProjetRepository.existsIdentificationProjetByCode(identificationProjetDTO.getCode())) {
            throw new IdentificationProjetNotFoundException("Le code '" + identificationProjetDTO.getCode() + "' existe déjà");
        }

        // Vérifier si l'intitulé existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getIntituleProjet() != null &&
                !identificationProjetDTO.getIntituleProjet().equals(existingIdentificationProjet.getIntituleProjet()) &&
                identificationProjetRepository.existsIdentificationProjetByIntituleProjet(identificationProjetDTO.getIntituleProjet())) {
            throw new IdentificationProjetNotFoundException("L'intitule de projet '" + identificationProjetDTO.getIntituleProjet() + "' existe déjà");
        }

        // Mise à jour des champs (l'ID Projet ne change pas car on recherche par ID Projet)
        if (identificationProjetDTO.getCode() != null) {
            existingIdentificationProjet.setCode(identificationProjetDTO.getCode());
        }
        if (identificationProjetDTO.getIntituleProjet() != null) {
            existingIdentificationProjet.setIntituleProjet(identificationProjetDTO.getIntituleProjet());
        }
        if (identificationProjetDTO.getTypeProjet() != null) {
            existingIdentificationProjet.setTypeProjet(identificationProjetDTO.getTypeProjet());
        }
        if (identificationProjetDTO.getEtapeActuelleProjet() != null) {
            existingIdentificationProjet.setEtapeActuelleProjet(identificationProjetDTO.getEtapeActuelleProjet());
        }
        if (identificationProjetDTO.getDemandeDTO() != null) {
            existingIdentificationProjet.setDemande(demandeMapper.fromDemandeDTO(identificationProjetDTO.getDemandeDTO()));
        }

        IdentificationProjet updateIdentificationProjet = identificationProjetRepository.save(existingIdentificationProjet);
        return identificationProjetMapper.fromIdentificationProjet(updateIdentificationProjet);
    }

    @Override
    public IdentificationProjetDTO updateIdentificationProjetByIntituleProjet(String intituleProjet, IdentificationProjetDTO identificationProjetDTO) throws IdentificationProjetNotFoundException {

        // Récupérer l'entité existante d'abord
        IdentificationProjet existingIdentificationProjet = identificationProjetRepository.findByIntituleProjet(intituleProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'intitulé: " + intituleProjet));

        // Vérifier si le code existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getCode() != null &&
                !identificationProjetDTO.getCode().equals(existingIdentificationProjet.getCode()) &&
                identificationProjetRepository.existsIdentificationProjetByCode(identificationProjetDTO.getCode())) {
            throw new IdentificationProjetNotFoundException("Le code '" + identificationProjetDTO.getCode() + "' existe déjà");
        }

        // Vérifier si l'ID Projet existe déjà (et n'appartient pas à l'entité actuelle)
        if (identificationProjetDTO.getIdProjet() != null &&
                !identificationProjetDTO.getIdProjet().equals(existingIdentificationProjet.getIdProjet()) &&
                identificationProjetRepository.existsIdentificationProjetByIdProjet(identificationProjetDTO.getIdProjet())) {
            throw new IdentificationProjetNotFoundException("L'ID Projet '" + identificationProjetDTO.getIdProjet() + "' existe déjà");
        }

        // Mise à jour des champs (l'intitulé ne change pas car on recherche par intitulé)
        if (identificationProjetDTO.getCode() != null) {
            existingIdentificationProjet.setCode(identificationProjetDTO.getCode());
        }
        if (identificationProjetDTO.getIdProjet() != null) {
            existingIdentificationProjet.setIdProjet(identificationProjetDTO.getIdProjet());
        }
        if (identificationProjetDTO.getTypeProjet() != null) {
            existingIdentificationProjet.setTypeProjet(identificationProjetDTO.getTypeProjet());
        }
        if (identificationProjetDTO.getEtapeActuelleProjet() != null) {
            existingIdentificationProjet.setEtapeActuelleProjet(identificationProjetDTO.getEtapeActuelleProjet());
        }
        if (identificationProjetDTO.getDemandeDTO() != null) {
            existingIdentificationProjet.setDemande(demandeMapper.fromDemandeDTO(identificationProjetDTO.getDemandeDTO()));
        }

        IdentificationProjet updateIdentificationProjet = identificationProjetRepository.save(existingIdentificationProjet);
        return identificationProjetMapper.fromIdentificationProjet(updateIdentificationProjet);
    }

    @Override
    public void deleteIdentificationProjetByIdIdentificationProjet(Long idIdentificationProjet) throws IdentificationProjetNotFoundException {
        IdentificationProjet identificationProjet = identificationProjetRepository.findById(idIdentificationProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'ID: " + idIdentificationProjet));
        identificationProjetRepository.delete(identificationProjet);
        identificationProjetRepository.deleteById(idIdentificationProjet);
        System.out.println("IdentificationProjet avec ID " + idIdentificationProjet + " a été supprimée avec succès");
    }

    @Override
    public void deleteIdentificationProjetByCodeIdentificationProjet(String codeIdentificationProjet) throws IdentificationProjetNotFoundException {
        IdentificationProjet identificationProjet = identificationProjetRepository.findByCode(codeIdentificationProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec le code: " + codeIdentificationProjet));
        identificationProjetRepository.delete(identificationProjet);
        System.out.println("IdentificationProjet avec le code '" + codeIdentificationProjet + "' a été supprimée avec succès");
    }

    @Override
    public void deleteIdentificationProjetByIdProjet(String idProjetIdentification) throws IdentificationProjetNotFoundException {
        IdentificationProjet identificationProjet = identificationProjetRepository.findByIdProjet(idProjetIdentification)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'ID Projet: " + idProjetIdentification));
        identificationProjetRepository.delete(identificationProjet);
        System.out.println("IdentificationProjet avec l'ID Projet '" + idProjetIdentification + "' a été supprimée avec succès");
    }

    @Override
    public void deleteIdentificationProjetByIntituleProjet(String intituleIdentificationProjet) throws IdentificationProjetNotFoundException {
        IdentificationProjet identificationProjet = identificationProjetRepository.findByIntituleProjet(intituleIdentificationProjet)
                .orElseThrow(() -> new IdentificationProjetNotFoundException("IdentificationProjet non trouvée avec l'intitule Projet: " + intituleIdentificationProjet));
        identificationProjetRepository.delete(identificationProjet);
        System.out.println("IdentificationProjet avec l'intitulé '" + intituleIdentificationProjet + "' a été supprimée avec succès");
    }
}
