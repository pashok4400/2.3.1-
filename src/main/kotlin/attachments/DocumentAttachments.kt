package attachments

data class DocumentAttachments(val document: Document?, override val type: String = "document"): Attachment