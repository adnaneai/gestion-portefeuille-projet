package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.DemandeDTO;
import ma.onep.gestionportefeuilleprojet.enums.Statut;
import ma.onep.gestionportefeuilleprojet.exceptions.DemandeNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/demandes")
public interface DemandeRestController {

    @GetMapping
    List<DemandeDTO> findAll();

    @GetMapping("/{id}")
    DemandeDTO findById(@PathVariable Long id) throws DemandeNotFoundException;

    @GetMapping("/statut/{statut}")
    List<DemandeDTO> findByStatut(@PathVariable Statut statut) throws DemandeNotFoundException;

    @GetMapping("/demandeur/{id}")
    DemandeDTO findByDemandeurId(@PathVariable Long id) throws DemandeNotFoundException;

    @GetMapping("/responsable/{id}")
    DemandeDTO findByResponsablePMOId(@PathVariable Long id) throws DemandeNotFoundException;

    @PostMapping
    DemandeDTO save(@RequestBody DemandeDTO demandeDTO);

    @PutMapping("/{id}")
    DemandeDTO updateById(@RequestBody DemandeDTO demandeDTO, @PathVariable Long id) throws DemandeNotFoundException;

    @PutMapping("/demandeur/{id}")
    DemandeDTO updateByDemandeurId(@RequestBody DemandeDTO demandeDTO, @PathVariable Long id) throws DemandeNotFoundException;

    @PutMapping("/responsable/{id}")
    DemandeDTO updateByResponsablePMO(@RequestBody DemandeDTO demandeDTO, @PathVariable Long id) throws DemandeNotFoundException;

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) throws DemandeNotFoundException;

    @DeleteMapping("/demandeur/{id}")
    void deleteByDemandeurId(@PathVariable Long id) throws DemandeNotFoundException;

    @DeleteMapping("/responsable/{id}")
    void deleteByResponsablePMO(@PathVariable Long id) throws DemandeNotFoundException;
}
