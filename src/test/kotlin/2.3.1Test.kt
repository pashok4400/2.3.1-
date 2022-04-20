import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addTest() {
        val actualExpected = 1

        val post = Post(
            id = 1, ownerId = 34, fromId = 2, createdBy = 7, date = 987654321,
            text = "text", replyOwnerId = 98, replyPostId = 35, friendsOnly = true,
            comments = "comments", copyright = "copyright", likes = 22,
            reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
            copyHistory = "232", canPin = true, canDelete = true, canEdit = true, isPinned = true,
            markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 345, attachments = null
        )

        assertEquals(post.id, actualExpected)
    }

    @Test
    fun updateTestTrue() {
        val result = WallService
        result.add(
            Post(
                id = 101, ownerId = 34, fromId = 2, createdBy = 7, date = 987654321,
                text = "text", replyOwnerId = 98, replyPostId = 35, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 22,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
                copyHistory = "232", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 345, attachments = null
            )
        )

        result.add(
            Post(
                id = 101, ownerId = 34, fromId = 2, createdBy = 7, date = 987654321,
                text = "text", replyOwnerId = 98, replyPostId = 35, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 22,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
                copyHistory = "232", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 345, attachments = null
            )
        )

        val resultUpdate = Post(
            id = 1, ownerId = 34, fromId = 2, createdBy = 7, date = 987654321,
            text = "text", replyOwnerId = 98, replyPostId = 35, friendsOnly = true,
            comments = "comments", copyright = "copyright", likes = 22,
            reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
            copyHistory = "232", canPin = true, canDelete = true, canEdit = true, isPinned = true,
            markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 345, attachments = null
        )
        val finishResult = result.update(resultUpdate)
        assertTrue(finishResult)
    }

    @Test
    fun updateTestFalse() {
        val result = WallService
        result.add(
            Post(
                id = 134, ownerId = 76, fromId = 54, createdBy = 137, date = 987654321,
                text = "text", replyOwnerId = 65, replyPostId = 45, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 3,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
                copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
            )
        )

        result.add(
            Post(
                id = 134, ownerId = 76, fromId = 54, createdBy = 137, date = 987654321,
                text = "text", replyOwnerId = 65, replyPostId = 45, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 3,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
                copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
            )
        )

        val resultUpdate = Post(
            id = 12, ownerId = 222, fromId = 44, createdBy = 117, date = 13456789,
            text = "text1", replyOwnerId = 7777, replyPostId = 15, friendsOnly = true,
            comments = "comments", copyright = "copyright", likes = 222,
            reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
            copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
            markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
        )
        val finishResult = result.update(resultUpdate)
        assertFalse(finishResult)
    }

    @Test
    fun createCommentTest() {
        val result = WallService
        val actualExpected = 1
        result.add(
            Post(
                id = 12, ownerId = 222, fromId = 44, createdBy = 117, date = 13456789,
                text = "text1", replyOwnerId = 7777, replyPostId = 15, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 222,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
                copyHistory = "121", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 123, attachments = null
            )
        )

        val comment = Comment(
            id = 22, postId = 1, text = "Не простое это дело..."
        )

        val finishResult = result.createComment(comment)
        assertEquals(finishResult.postId, actualExpected)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentExceptionTest() {
        val result = WallService
        val actualExpected = 1
        result.add(
            Post(
                id = 1, ownerId = 34, fromId = 2, createdBy = 7, date = 987654321,
                text = "text", replyOwnerId = 98, replyPostId = 35, friendsOnly = true,
                comments = "comments", copyright = "copyright", likes = 22,
                reposts = 44, views = 1717, postType = "reply", postSource = "sms", geo = "Самара", signerId = 123,
                copyHistory = "232", canPin = true, canDelete = true, canEdit = true, isPinned = true,
                markedAsAds = true, ifFavorite = true, donut = "donut", postponedId = 345, attachments = null
            )
        )

        val comment = Comment(
            id = 22, postId = 0, text = "Не простое это дело..."
        )

        val finishResult = result.createComment(comment)
        assertEquals(finishResult.postId, actualExpected)
    }
}