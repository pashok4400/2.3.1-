package attachments

data class Archive (
    var id: Int = 0,
    var owner_id: Int = 0,
    var name: String = "none",
    var size: Int = 0
)