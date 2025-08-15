package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DemandeurDTO;
import ma.onep.gestionportefeuilleprojet.dto.ResponsablePMODTO;
import ma.onep.gestionportefeuilleprojet.dto.UtilisateurDTO;
import ma.onep.gestionportefeuilleprojet.entities.Demandeur;
import ma.onep.gestionportefeuilleprojet.entities.ResponsablePMO;
import ma.onep.gestionportefeuilleprojet.entities.Utilisateur;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeurNotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.ResponsablePMONotFoundException;
import ma.onep.gestionportefeuilleprojet.exceptions.UtilisateurNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.UtilisateurMapper;
import ma.onep.gestionportefeuilleprojet.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UtilisateurServiceImp implements UtilisateurService{
    private UtilisateurRepository  utilisateurRepository;
    private UtilisateurMapper utilisateurMapper;

    @Override
    public List<UtilisateurDTO> findAll() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();

        return utilisateurs.stream()
                .map(utilisateurMapper::fromUtilisateur)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeurDTO> findAllDemandeur() {

        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();

        return utilisateurs.stream()
                .filter(utilisateur -> utilisateur instanceof Demandeur)
                .map(utilisateur -> (Demandeur) utilisateur)
                .map(utilisateurMapper::fromDemandeur)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponsablePMODTO> findAllResponsablePMO() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();

        return utilisateurs.stream()
                .filter(utilisateur -> utilisateur instanceof ResponsablePMO)
                .map(utilisateur -> (ResponsablePMO) utilisateur)
                .map(utilisateurMapper::fromResponsablePMO)
                .collect(Collectors.toList());
    }

    @Override
    public DemandeurDTO findDemandeurById(Long id) throws UtilisateurNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        if (!(utilisateur instanceof Demandeur)) {
            throw new DemandeurNotFoundException("L'utilisateur trouvé n'est pas un demandeur");
        }
        Demandeur demandeur = (Demandeur) utilisateur;
        return utilisateurMapper.fromDemandeur(demandeur);
    }
    @Override
    public DemandeurDTO findDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException {

        Utilisateur utilisateur = utilisateurRepository.findByMatricule(idMatricule)
                .orElseThrow(() -> new DemandeurNotFoundException("Utilisateur non trouvé avec le matricule : " + idMatricule));
        if (!(utilisateur instanceof Demandeur)) {
            throw new DemandeurNotFoundException("L'utilisateur trouvé n'est pas un demandeur");
        }
        Demandeur demandeur = (Demandeur) utilisateur;
        return  utilisateurMapper.fromDemandeur(demandeur);
    }

    @Override
    public ResponsablePMODTO findResponsablePMOById(Long id) throws UtilisateurNotFoundException {

        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResponsablePMONotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        if (!(utilisateur instanceof ResponsablePMO)) {
            throw new ResponsablePMONotFoundException("L'utilisateur trouvé n'est pas un ResponsablePMO");
        }
        ResponsablePMO responsablePMO = (ResponsablePMO) utilisateur;
        return utilisateurMapper.fromResponsablePMO(responsablePMO);
    }

    @Override
    public DemandeurDTO saveDemandeur(DemandeurDTO demandeurDTO) {
        Demandeur demandeur = utilisateurMapper.fromDemandeurDTO(demandeurDTO);
        Demandeur savedDemandeur = utilisateurRepository.save(demandeur);
        return utilisateurMapper.fromDemandeur(savedDemandeur);
    }

    @Override
    public ResponsablePMODTO saveResponsablePMO(ResponsablePMODTO responsablePMODTO) {
        ResponsablePMO responsablePMO = utilisateurMapper.fromResponsablePMODTO(responsablePMODTO);
        ResponsablePMO savedResponsablePMO = utilisateurRepository.save(responsablePMO);
        return utilisateurMapper.fromResponsablePMO(savedResponsablePMO);
    }

    @Override
    public DemandeurDTO updateDemandeurById(DemandeurDTO demandeurDTO, Long id) throws UtilisateurNotFoundException {
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        if(!(existingUtilisateur instanceof Demandeur)) {
            throw new UtilisateurNotFoundException("L'utilisateur trouvé n'est pas un demandeur");
        }

        existingUtilisateur.setNom(demandeurDTO.getNom());
        existingUtilisateur.setPrenom(demandeurDTO.getPrenom());
        existingUtilisateur.setDdn(demandeurDTO.getDdn());
        existingUtilisateur.setEmail(demandeurDTO.getEmail());
        existingUtilisateur.setTelephone(demandeurDTO.getTelephone());
        existingUtilisateur.setMdp(demandeurDTO.getMdp());
        ((Demandeur) existingUtilisateur).setMatricule(demandeurDTO.getMatricule());
        ((Demandeur) existingUtilisateur).setDirection(demandeurDTO.getDirection());

        Utilisateur updateUtilisateur = utilisateurRepository.save((Demandeur)  existingUtilisateur);

        return utilisateurMapper.fromDemandeur((Demandeur) updateUtilisateur);
    }

    @Override
    public DemandeurDTO updateDemandeurByMatricule(DemandeurDTO demandeurDTO, Long idMatricule) throws  DemandeurNotFoundException {
        Utilisateur existingUtilisateur = utilisateurRepository.findByMatricule(idMatricule)
                .orElseThrow(() -> new DemandeurNotFoundException("Utilisateur non trouvé avec le matricule : " + idMatricule));
        if(!(existingUtilisateur instanceof Demandeur)) {
            throw new DemandeurNotFoundException("L'utilisateur trouvé n'est pas un demandeur");
        }

        existingUtilisateur.setNom(demandeurDTO.getNom());
        existingUtilisateur.setPrenom(demandeurDTO.getPrenom());
        existingUtilisateur.setDdn(demandeurDTO.getDdn());
        existingUtilisateur.setEmail(demandeurDTO.getEmail());
        existingUtilisateur.setTelephone(demandeurDTO.getTelephone());
        existingUtilisateur.setMdp(demandeurDTO.getMdp());
        ((Demandeur) existingUtilisateur).setDirection(demandeurDTO.getDirection());

        Utilisateur updateUtilisateur = utilisateurRepository.save((Demandeur)  existingUtilisateur);

        return utilisateurMapper.fromDemandeur((Demandeur) updateUtilisateur);
    }

    @Override
    public ResponsablePMODTO updateResponsablePMOById(ResponsablePMODTO responsablePMODTO, Long id) throws UtilisateurNotFoundException {
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id)
                .orElseThrow(()->new UtilisateurNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        if(!(existingUtilisateur instanceof ResponsablePMO)) {
            throw new ResponsablePMONotFoundException("L'utilisateur trouvé n'est pas un ResponsablePMO");
        }
        existingUtilisateur.setNom(responsablePMODTO.getNom());
        existingUtilisateur.setPrenom(responsablePMODTO.getPrenom());
        existingUtilisateur.setDdn(responsablePMODTO.getDdn());
        existingUtilisateur.setEmail(responsablePMODTO.getEmail());
        existingUtilisateur.setTelephone(responsablePMODTO.getTelephone());
        existingUtilisateur.setMdp(responsablePMODTO.getMdp());
        ((ResponsablePMO) existingUtilisateur).setDomaineExpertise(responsablePMODTO.getDomaineExpertise());
        ((ResponsablePMO) existingUtilisateur).setNiveauCertification(responsablePMODTO.getNiveauCertification());

        Utilisateur updateUtilisateur = utilisateurRepository.save((ResponsablePMO)  existingUtilisateur);
        return utilisateurMapper.fromResponsablePMO((ResponsablePMO) updateUtilisateur);
    }

    @Override
    public void deleteDemandeurById(Long id) throws UtilisateurNotFoundException {

        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        if (!(utilisateur instanceof Demandeur)) {
            throw new UtilisateurNotFoundException("L'utilisateur trouvé n'est pas un demandeur");
        }
        utilisateurRepository.delete(utilisateur);
        System.out.println("Demandeur avec ID "+id+" a été supprimé avec succès");
    }

    @Override
    public void deleteResponsablePMOById(Long id) throws UtilisateurNotFoundException {

        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        if (!(utilisateur instanceof ResponsablePMO)) {
            throw new ResponsablePMONotFoundException("L'utilisateur trouvé n'est pas un ResponsablePMO");
        }
        utilisateurRepository.delete(utilisateur);
        System.out.println("ResponsablePMO avec ID "+id+" a été supprimé avec succès");
    }

    @Override
    public void deleteDemandeurByMatricule(Long idMatricule) throws DemandeurNotFoundException {

        Utilisateur utilisateur = utilisateurRepository.findByMatricule(idMatricule)
                .orElseThrow(() -> new DemandeurNotFoundException("Utilisateur non trouvé avec le matricule : " + idMatricule));
        if (!(utilisateur instanceof Demandeur)) {
            throw new DemandeurNotFoundException("L'utilisateur trouvé n'est pas un demandeur");
        }
        utilisateurRepository.deleteByMatricule(idMatricule);
        System.out.println("Demandeur avec le matricule "+idMatricule+" a été supprimé avec succès");
    }
}
