fun main() {

}
object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        if (posts.isNotEmpty()) {
            val oldId = posts.last().id
            val postCopy = post.copy(id = oldId + 1);
            posts += postCopy
        } else {
            posts += post.copy(id = 1)
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val id = post.id
        for ((index, oldPost) in posts.withIndex()) {
            if (id == oldPost.id) {
                val tempPost = oldPost
                posts[index] = post.copy(date = oldPost.date);
                return true
            }
        }
        return false
    }
}


data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val view: View,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int,

    val postSource: Any?,
    val geo: Geo,
    val copyHistory: Array<Any>?,

    val attachments: Array<Attachment>?


) {
    data class Comments(
        val count: Int,
        val canPost: Boolean,
        val groupsCanPost: Boolean,
        val canClose: Boolean,
        val canOpen: Boolean
    )

    data class Copyright(
        val id: Int,
        val link: String,
        val name: String,
        val type: String
    )

    data class Likes(
        val count: Int,
        val userLikes: Boolean,
        val canLike: Boolean,
        val canPublish: Boolean
    )

    data class Reposts(
        val count: Int,
        val userReposted: Boolean
    )

    data class View(
        val count: Int
    )

    data class Donut(
        val isDonut: Boolean,
        val paidDuration: Int,
        val placeholder: Placeholder,
        val canPublishFreeCopy: Boolean,
        val editMode: String
    ) {
        class Placeholder(
            val text: String
        )
    }

    data class Geo(
        val type: String,
        val coordinates: String,
        val place: Any?
    )

    sealed interface Attachment

    sealed class Type : Attachment {
        class Video(
            val id: Int,
            val ownerId: Int,
            val title: String,
            val description: String,
            val duration: Int,
            val image: () -> Unit = {
                val height: Int
                val url: String
                val width: Int
                val withPadding: Int = 1
            },
            val firstName: () -> Unit = {
                val height: Int
                val url: String
                val width: Int
                val withPadding: Int = 1
            },
            val date: Int
            // остальные поля не включил
        ) : Type()

        class Audio(
            val id: Int,
            val ownerId: Int,
            val artist: String,
            val title: String,
            val duration: Int,
            val url: String
            // остальные поля не включил
        ) : Type()

        class Photo(
            val id: Int,
            val albumId: Int,
            val ownerId: Int,
            val userId: Int,
            val text: String,
            val date: Int,
            val sizes: () -> Unit = {
                val typeC: String
                val url: String
                val width: Int
                val height: Int
            },
            val widthZ: Int,
            val heightZ: Int
        ) : Type()

        class Doc(
            val id: Int,
            val ownerId: Int,
            val title: String,
            val size: Int,
            val ext: String,
            val utl: String,
            val date: Int,
            val fType: String
        ) : Type()

        // Остальные классы не включил

        fun infoAsFun(type: Attachment) = when (type) {
            is Video -> {
                println("Type: $type.class, id: $type.id, owner_id: $type.ownerId, title: $type.title, " +
                        "description: $type.description, duration: $type.duration, image: $type.image" +
                        "first_name: $type.firstName")
            }
            is Audio -> {
                println("Type: $type.class, id: $type.id, owner_id: $type.ownerId, artist: $type.artist, " +
                        "title: $type.title, duration: $type.duration, url: $type.url")
            }
            is Photo -> {
                println(
                    "Type: $type.class, id: $type.id, album_id: $type.albumId, owner_id: $type.ownerId, " +
                            "user_id: $type.userId, text: $type.text, date: $type.date, sizes: $type.sizes, " +
                            "width: $type.width," + "height: $type.height"
                )
            }
            is Doc -> {
                println("Type: $type.class, id: $type.id, owner_id: $type.ownerId, title: $type.title, " +
                        "size: $type.size, ext: $type.ext, url: $type.utl, date: $type.date, file: $type.fType  "
                )
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (createdBy != other.createdBy) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (comments != other.comments) return false
        if (copyright != other.copyright) return false
        if (likes != other.likes) return false
        if (reposts != other.reposts) return false
        if (view != other.view) return false
        if (postType != other.postType) return false
        if (signerId != other.signerId) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (isFavorite != other.isFavorite) return false
        if (donut != other.donut) return false
        if (postponedId != other.postponedId) return false
        if (postSource != other.postSource) return false
        if (geo != other.geo) return false
        if (copyHistory != null) {
            if (other.copyHistory == null) return false
            if (!copyHistory.contentEquals(other.copyHistory)) return false
        } else if (other.copyHistory != null) return false
        if (attachments != null) {
            if (other.attachments == null) return false
            if (!attachments.contentEquals(other.attachments)) return false
        } else if (other.attachments != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + fromId
        result = 31 * result + createdBy
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + replyOwnerId
        result = 31 * result + replyPostId
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + comments.hashCode()
        result = 31 * result + copyright.hashCode()
        result = 31 * result + likes.hashCode()
        result = 31 * result + reposts.hashCode()
        result = 31 * result + view.hashCode()
        result = 31 * result + postType.hashCode()
        result = 31 * result + signerId
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + donut.hashCode()
        result = 31 * result + postponedId
        result = 31 * result + (postSource?.hashCode() ?: 0)
        result = 31 * result + geo.hashCode()
        result = 31 * result + (copyHistory?.contentHashCode() ?: 0)
        result = 31 * result + (attachments?.contentHashCode() ?: 0)
        return result
    }
}