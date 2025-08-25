package ma.onep.gestionportefeuilleprojet.enums;

public enum TypeDocument {
    // Documents images
    IMAGE_JPEG,
    IMAGE_PNG,
    IMAGE_GIF,
    IMAGE_BMP,
    IMAGE_TIFF,
    IMAGE_SVG,

    // Documents PDF
    PDF,

    // Documents texte
    DOCUMENT_TXT,
    DOCUMENT_CSV,
    DOCUMENT_HTML,
    DOCUMENT_XML,
    DOCUMENT_JSON,

    // Documents Microsoft Office
    DOCUMENT_DOC,
    DOCUMENT_DOCX,
    DOCUMENT_XLS,
    DOCUMENT_XLSX,
    DOCUMENT_PPT,
    DOCUMENT_PPTX,

    // Documents OpenOffice/LibreOffice
    DOCUMENT_ODT,
    DOCUMENT_ODS,
    DOCUMENT_ODP,

    // Archives et compression
    ARCHIVE_ZIP,
    ARCHIVE_RAR,
    ARCHIVE_7Z,
    ARCHIVE_TAR,
    ARCHIVE_GZIP,

    // Autres types de documents
    AUDIO_MP3,
    AUDIO_WAV,
    AUDIO_FLAC,
    VIDEO_MP4,
    VIDEO_AVI,
    VIDEO_MKV,
    VIDEO_MOV,

    // Types génériques (fallback)
    AUTRE,
    INCONNU
}