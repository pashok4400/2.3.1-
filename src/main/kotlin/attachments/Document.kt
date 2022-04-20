package attachments

data class Document (
    var id: Int = 0,
    var owner_id: Int = 0,
    var name: String = "none",
    var date: String = "none"
)