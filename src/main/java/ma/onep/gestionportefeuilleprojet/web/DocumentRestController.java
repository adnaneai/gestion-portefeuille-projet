package ma.onep.gestionportefeuilleprojet.web;

import ma.onep.gestionportefeuilleprojet.dto.DocumentDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DocumentNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/documents")
public interface DocumentRestController {

    @GetMapping
    List<DocumentDTO> getAllDocuments();

    @GetMapping("/id/{id}")
    DocumentDTO getDocumentById(@PathVariable Long id) throws DocumentNotFoundException;

    @GetMapping("/nom/{nom}")
    DocumentDTO getDocumentByNom(@PathVariable String nom) throws DocumentNotFoundException;

    @PostMapping
    DocumentDTO createDocument(@RequestBody DocumentDTO documentDTO) throws DocumentNotFoundException;

    @PutMapping("/id/{id}")
    DocumentDTO updateDocument(@PathVariable Long id, @RequestBody DocumentDTO documentDTO) throws DocumentNotFoundException;

    @DeleteMapping("/id/{id}")
    void deleteDocument(@PathVariable Long id) throws DocumentNotFoundException;
}