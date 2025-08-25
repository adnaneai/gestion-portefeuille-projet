package ma.onep.gestionportefeuilleprojet.services;

import lombok.AllArgsConstructor;
import ma.onep.gestionportefeuilleprojet.dto.DocumentDTO;
import ma.onep.gestionportefeuilleprojet.entities.Document;
import ma.onep.gestionportefeuilleprojet.entities.AutresInformation;
import ma.onep.gestionportefeuilleprojet.exceptions.DocumentNotFoundException;
import ma.onep.gestionportefeuilleprojet.mappers.DocumentMapper;
import ma.onep.gestionportefeuilleprojet.mappers.AutresInformationMapper;
import ma.onep.gestionportefeuilleprojet.repository.DocumentRepository;
import ma.onep.gestionportefeuilleprojet.repository.AutresInformationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DocumentServiceImp implements DocumentService {

    private DocumentRepository documentRepository;
    private AutresInformationRepository autresInformationRepository;
    private DocumentMapper documentMapper;
    private AutresInformationMapper autresInformationMapper;

    @Override
    public List<DocumentDTO> findAllDocuments() {
        List<Document> documents = documentRepository.findAll();
        return documents.stream()
                .map(documentMapper::fromDocument)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentDTO findDocumentById(Long id) throws DocumentNotFoundException {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException("Document non trouvé avec l'ID: " + id));
        return documentMapper.fromDocument(document);
    }

    @Override
    public DocumentDTO findDocumentByName(String nom) throws DocumentNotFoundException {
        Document document = documentRepository.findByNom(nom)
                .orElseThrow(() -> new DocumentNotFoundException("Document non trouvé avec le nom: " + nom));
        return documentMapper.fromDocument(document);
    }

    @Override
    public DocumentDTO saveDocument(DocumentDTO documentDTO) throws DocumentNotFoundException {
        Document document = documentMapper.fromDocumentDTO(documentDTO);

        // Gestion de la relation avec AutresInformation si le DTO est fourni
        if (documentDTO.getAutresInformationDTO() != null) {
            // Convertir le DTO en entité pour récupérer l'ID
            AutresInformation autresInformation = autresInformationMapper.fromAutresInformationDTO(documentDTO.getAutresInformationDTO());

            // Si l'entité a un ID (existant en base), on l'associe
            if (autresInformation.getIdAutresInformation() != null) {
                // Vérifier que l'entité existe en base
                AutresInformation existingAutresInformation = autresInformationRepository
                        .findById(autresInformation.getIdAutresInformation())
                        .orElseThrow(() -> new DocumentNotFoundException(
                                "AutresInformation non trouvé avec l'ID: " + autresInformation.getIdAutresInformation()));

                document.setAutresInformation(existingAutresInformation);
            } else {
                // Si c'est une nouvelle AutresInformation, on la sauvegarde d'abord
                AutresInformation savedAutresInformation = autresInformationRepository.save(autresInformation);
                document.setAutresInformation(savedAutresInformation);
            }
        }

        Document savedDocument = documentRepository.save(document);
        return documentMapper.fromDocument(savedDocument);
    }

    @Override
    public DocumentDTO updateDocument(Long id, DocumentDTO documentDTO) throws DocumentNotFoundException {
        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException("Document non trouvé avec l'ID: " + id));

        // Mise à jour du nom
        if (documentDTO.getNom() != null) {
            existingDocument.setNom(documentDTO.getNom());
        }

        // Mise à jour du type de document
        if (documentDTO.getTypeDocument() != null) {
            existingDocument.setTypeDocument(documentDTO.getTypeDocument());
        }

        // Mise à jour de l'URL
        if (documentDTO.getUrl() != null) {
            existingDocument.setUrl(documentDTO.getUrl());
        }

        // Mise à jour de la relation AutresInformation si fournie
        if (documentDTO.getAutresInformationDTO() != null) {
            // Convertir le DTO en entité pour récupérer l'ID
            AutresInformation autresInformation = autresInformationMapper.fromAutresInformationDTO(documentDTO.getAutresInformationDTO());

            if (autresInformation.getIdAutresInformation() != null) {
                // Vérifier que l'entité existe en base
                AutresInformation existingAutresInformation = autresInformationRepository
                        .findById(autresInformation.getIdAutresInformation())
                        .orElseThrow(() -> new DocumentNotFoundException(
                                "AutresInformation non trouvé avec l'ID: " + autresInformation.getIdAutresInformation()));

                existingDocument.setAutresInformation(existingAutresInformation);
            } else {
                // Si c'est une nouvelle AutresInformation, on la sauvegarde d'abord
                AutresInformation savedAutresInformation = autresInformationRepository.save(autresInformation);
                existingDocument.setAutresInformation(savedAutresInformation);
            }
        } else {
            // Si aucun AutresInformation n'est fourni, on supprime la relation
            existingDocument.setAutresInformation(null);
        }

        Document updatedDocument = documentRepository.save(existingDocument);
        return documentMapper.fromDocument(updatedDocument);
    }

    @Override
    public void deleteDocument(Long id) throws DocumentNotFoundException {
        if (!documentRepository.existsById(id)) {
            throw new DocumentNotFoundException("Document non trouvé avec l'ID: " + id);
        }
        documentRepository.deleteById(id);
    }
}