package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DocumentDTO;
import ma.onep.gestionportefeuilleprojet.entities.Document;

public interface DocumentMapper {
    public DocumentDTO fromDocument(Document document);
    public Document fromDocumentDTO(DocumentDTO documentDTO);
}
