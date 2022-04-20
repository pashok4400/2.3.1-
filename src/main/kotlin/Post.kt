import attachments.Attachment

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: String,
    val copyright: String,
    val likes: Int?,
    val reposts: Int?,
    val views: Int?,
    val postType: String,
    val postSource: String,
    var attachments: ArrayList<Attachment>?,
    val geo: String,
    val signerId: Int,
    val copyHistory: String,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val ifFavorite: Boolean,
    val donut: String,
    val postponedId: Int

) {
}