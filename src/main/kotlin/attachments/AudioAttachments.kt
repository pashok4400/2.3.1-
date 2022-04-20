package attachments

data class AudioAttachments(val audio: Audio?, override val type: String = "audio"): Attachment