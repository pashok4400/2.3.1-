object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var properties: Int = 1



    fun add(post: Post): Post {
        post.id = properties
        posts += post
        properties += 1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (postArr in posts) {
            if (post.id == postArr.id) {
                val newPost: Post = postArr.copy(
                    ownerId = post.ownerId,
                    createdBy = post.createdBy,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    copyright = post.copyright,
                    likes = post.likes,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    postSource = post.postSource,
                    geo = post.geo,
                    signerId = post.signerId,
                    copyHistory = post.copyHistory,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    ifFavorite = post.ifFavorite,
                    donut = post.donut,
                    postponedId = post.postponedId
                )
                posts += newPost
                return true
            }
        }
        return false
    }


    fun createComment(comment: Comment): Comment {
        for (postArr in posts) {
            if (comment.postId == postArr.id) {
                comments += comment
            } else {
                throw PostNotFoundException("Post is not found")
            }
        }
        return comments.last()
    }

}