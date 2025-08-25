package ma.onep.gestionportefeuilleprojet.web;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DocumentDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DocumentNotFoundException;
import ma.onep.gestionportefeuilleprojet.services.DocumentService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DocumentRestControllerImp implements DocumentRestController {

    private DocumentService documentService;

    @Override
    public List<DocumentDTO> getAllDocuments() {
        return documentService.findAllDocuments();
    }

    @Override
    public DocumentDTO getDocumentById(Long id) throws DocumentNotFoundException {
        return documentService.findDocumentById(id);
    }

    @Override
    public DocumentDTO getDocumentByNom(String nom) throws DocumentNotFoundException {
        return documentService.findDocumentByName(nom);
    }

    @Override
    public DocumentDTO createDocument(DocumentDTO documentDTO) throws DocumentNotFoundException {
        return documentService.saveDocument(documentDTO);
    }

    @Override
    public DocumentDTO updateDocument(Long id, DocumentDTO documentDTO) throws DocumentNotFoundException {
        return documentService.updateDocument(id, documentDTO);
    }

    @Override
    public void deleteDocument(Long id) throws DocumentNotFoundException {
        documentService.deleteDocument(id);
    }
}