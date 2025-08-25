package ma.onep.gestionportefeuilleprojet.services;

import ma.onep.gestionportefeuilleprojet.dto.DocumentDTO;
import ma.onep.gestionportefeuilleprojet.exceptions.DocumentNotFoundException;

import java.util.List;

public interface DocumentService {
    List<DocumentDTO> findAllDocuments();
    DocumentDTO findDocumentById(Long id) throws DocumentNotFoundException;
    DocumentDTO findDocumentByName(String nom) throws DocumentNotFoundException;
    DocumentDTO saveDocument(DocumentDTO documentDTO);
    DocumentDTO updateDocument(Long id, DocumentDTO documentDTO) throws DocumentNotFoundException;
    void deleteDocument(Long id) throws DocumentNotFoundException;
}