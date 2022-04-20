package attachments

data class ArchiveAttachments(val archive: Archive?, override val type: String = "archive"): Attachment
