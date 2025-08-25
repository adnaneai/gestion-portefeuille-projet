package ma.onep.gestionportefeuilleprojet.mappers;

import ma.onep.gestionportefeuilleprojet.dto.DocumentDTO;
import ma.onep.gestionportefeuilleprojet.entities.Document;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DocumentMapperImp implements DocumentMapper{
    @Override
    public DocumentDTO fromDocument(Document document) {
        DocumentDTO documentDTO = new DocumentDTO();
        BeanUtils.copyProperties(document,documentDTO);
        return documentDTO;
    }

    @Override
    public Document fromDocumentDTO(DocumentDTO documentDTO) {
        Document document = new Document();
        BeanUtils.copyProperties(documentDTO,document);
        return document;
    }
}
