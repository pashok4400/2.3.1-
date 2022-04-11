fun main() {
    println("Hello Netology=)")
}


object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        if (!posts.isEmpty()) {
            val oldId = posts.last().id
            val postCopy = post.copy(id = oldId + 1);
            posts += postCopy
        } else {
            posts += post.copy(1)
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

    val postSource: Object?,
    val geo: Geo,
    val copyHistory: Array<Object>?,

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
        val place: Object?
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
            val date: Integer
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
            val date: Integer,
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
}