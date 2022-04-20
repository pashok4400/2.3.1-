package attachments

data class Photo (
    var id: Int = 0,
    var owner_id: Int = 0,
    var name: String = "none",
    var resolution: String = "none"
)