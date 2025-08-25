package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.InformationsProjetDTO;
import ma.onep.gestionportefeuilleprojet.entities.InformationsProjet;
import ma.onep.gestionportefeuilleprojet.exceptions.InformationsProjetNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.DemandeMapper;
import ma.onep.gestionportefeuilleprojet.mappers.InformationsProjetMapper;
import ma.onep.gestionportefeuilleprojet.repository.InformationsProjetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InformationsProjetServiceImp implements InformationsProjetService {

    private InformationsProjetRepository informationsProjetRepository;
    private InformationsProjetMapper informationsProjetMapper;
    private DemandeMapper demandeMapper;

    @Override
    public List<InformationsProjetDTO> findAllInformationsProjets() {
        List<InformationsProjet> informationsProjets = informationsProjetRepository.findAll();
        return informationsProjets.stream()
                .map(informationsProjetMapper::fromInformationsProjet)
                .collect(Collectors.toList());
    }

    @Override
    public InformationsProjetDTO findInformationsProjetById(Long id) throws InformationsProjetNotFoundException {
        InformationsProjet informationsProjet = informationsProjetRepository.findById(id)
                .orElseThrow(() -> new InformationsProjetNotFoundException("InformationsProjet non trouvé avec l'ID: " + id));
        return informationsProjetMapper.fromInformationsProjet(informationsProjet);
    }

    @Override
    public List<InformationsProjetDTO> findInformationProjetByDateDemarrage(Date date) throws InformationsProjetNotFoundException {
        List<InformationsProjet> informationsProjets = informationsProjetRepository.findByDateDemarrage(date);
        if (informationsProjets.isEmpty()) {
            throw new InformationsProjetNotFoundException("Aucun InformationsProjet trouvé avec la date de démarrage: " + date);
        }
        return informationsProjets.stream()
                .map(informationsProjetMapper::fromInformationsProjet)
                .collect(Collectors.toList());
    }

    @Override
    public List<InformationsProjetDTO> findInformationProjetByDuree(String duree) throws InformationsProjetNotFoundException {
        List<InformationsProjet> informationsProjets = informationsProjetRepository.findByDureeContainingIgnoreCase(duree);
        if (informationsProjets.isEmpty()) {
            throw new InformationsProjetNotFoundException("Aucun InformationsProjet trouvé avec la durée: " + duree);
        }
        return informationsProjets.stream()
                .map(informationsProjetMapper::fromInformationsProjet)
                .collect(Collectors.toList());
    }

    @Override
    public List<InformationsProjetDTO> findInformationsProjetCout(float cout) throws InformationsProjetNotFoundException {
        List<InformationsProjet> informationsProjets = informationsProjetRepository.findByCout(cout);
        if (informationsProjets.isEmpty()) {
            throw new InformationsProjetNotFoundException("Aucun InformationsProjet trouvé avec le coût: " + cout);
        }
        return informationsProjets.stream()
                .map(informationsProjetMapper::fromInformationsProjet)
                .collect(Collectors.toList());
    }

    @Override
    public InformationsProjetDTO saveInformationsProjet(InformationsProjetDTO informationsProjetDTO) {
        // Vérification que les trois attributs ne sont pas null
        if (informationsProjetDTO.getDateDemarrage() == null ||
                informationsProjetDTO.getDuree() == null ||
                informationsProjetDTO.getCout() == 0.0f) {
            throw new IllegalArgumentException("Les champs dateDemarrage, duree et cout doivent être renseignés");
        }

        InformationsProjet informationsProjet = informationsProjetMapper.fromInformationsProjetDTO(informationsProjetDTO);
        InformationsProjet savedInformationsProjet = informationsProjetRepository.save(informationsProjet);
        return informationsProjetMapper.fromInformationsProjet(savedInformationsProjet);
    }

    @Override
    public InformationsProjetDTO updateInformationsProjet(Long id, InformationsProjetDTO informationsProjetDTO) throws InformationsProjetNotFoundException {
        InformationsProjet existingInformationsProjet = informationsProjetRepository.findById(id)
                .orElseThrow(() -> new InformationsProjetNotFoundException("InformationsProjet non trouvé avec l'ID: " + id));

        // Vérification que les trois attributs ne sont pas null
        if (informationsProjetDTO.getDateDemarrage() == null ||
                informationsProjetDTO.getDuree() == null ||
                informationsProjetDTO.getCout() == 0.0f) {
            throw new IllegalArgumentException("Les champs dateDemarrage, duree et cout doivent être renseignés");
        }

        // Mise à jour des champs
        if (informationsProjetDTO.getDateDemarrage() != null) {
            existingInformationsProjet.setDateDemarrage(informationsProjetDTO.getDateDemarrage());
        }
        if (informationsProjetDTO.getDuree() != null) {
            existingInformationsProjet.setDuree(informationsProjetDTO.getDuree());
        }
        if (informationsProjetDTO.getCout() != 0.0f) {
            existingInformationsProjet.setCout(informationsProjetDTO.getCout());
        }
        if (informationsProjetDTO.getDemandeDTO() != null) {
            existingInformationsProjet.setDemande(demandeMapper.fromDemandeDTO(informationsProjetDTO.getDemandeDTO()));
        }

        InformationsProjet updatedInformationsProjet = informationsProjetRepository.save(existingInformationsProjet);
        return informationsProjetMapper.fromInformationsProjet(updatedInformationsProjet);
    }

    @Override
    public void deleteInformationsProjet(Long id) throws InformationsProjetNotFoundException {
        if (!informationsProjetRepository.existsById(id)) {
            throw new InformationsProjetNotFoundException("InformationsProjet non trouvé avec l'ID: " + id);
        }
        informationsProjetRepository.deleteById(id);
    }
}