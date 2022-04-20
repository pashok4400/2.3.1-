package attachments

data class PhotoAttachments(val photo: Photo?, override val type: String = "photo"): Attachment