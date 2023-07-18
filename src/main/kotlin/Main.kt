import java.lang.RuntimeException
import java.util.Date

data class Post(
        val id: Int, // Идентификатор записи
        val ownerId: Int = 0, // Id владельца стены
        val fromId: Int = 0, // Id автора записи
        val date: Date = Date(),
        val text: String,
        val replyOwnerId: Int = 0, // Id владельца записи, в ответ на которую была оставлена текущая
        val replyPostId: Int = 0, // Id записи, в ответ на которую была оставлена текущая
        val friendsOnly: Boolean = false, // 1, если запись была создана с опцией «Только для друзей».
        val canPin: Boolean = false,
        val canDelete: Boolean = false,
        val likes: Likes? = Likes(),
        val views: Views? = Views(),
        val comment: Comment? = Comment()
)

data class Comment(
        val postId: Int = 0,
        val commentId: Int = 0,
        val date: Date = Date(),
        val text: String? = null
)

data class Complain(
        val commentId: Int = 0,
        val reason: Int = 0
)

data class Likes(
        val count: Int = 0, // число пользователей, которым понравилась запись
        val userLikes: Boolean = false,
        val canLike: Boolean = true,
        val canPublish: Boolean = true
)

data class Views(
        val count: Int = 0 //число просмотров записи
)

object WallService {
    private var postsOnTheWall = emptyArray<Post>()
    private var commentOnThePost = emptyArray<Comment>()
    private var complain = emptyArray<Complain>()
    private var lastId = 0

    fun add(post: Post): Post {
        postsOnTheWall += post.copy(id = post.id + lastId, likes = post.likes?.copy())
        return postsOnTheWall.last()
    }

    fun update(updatePost: Post): Boolean {
        for ((index, post) in postsOnTheWall.withIndex()) {
            if (post.id == updatePost.id) {
                postsOnTheWall[index] = post.copy(likes = post.likes?.copy())
                return true
            }
        }
        return false
    }

    fun print() {
        for (post in postsOnTheWall) {
            println(post)
        }
        println()
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, post) in postsOnTheWall.withIndex()) {
            if (post.id == postId) {
                commentOnThePost += comment.copy()
                return commentOnThePost.last()
            }
        }
        throw PostNotFoundException("Post Not Found Exception")
    }

    fun reportComment(complainNew: Complain): Complain {
        var sum: Int = 0

        for ((index, comment) in commentOnThePost.withIndex()) {
            if (comment.commentId == complainNew.commentId) {

                require(complainNew.reason in 1..8) {
                    throw ComplainArgumentException("Invalid parameter")
                }

                complain += complainNew.copy()

                val report: String = when (complainNew.reason) {
                    1 -> "спам"
                    2 -> "детская порнография"
                    3 -> "экстремизм"
                    4 -> "насилие"
                    5 -> "пропаганда наркотиков"
                    6 -> "материал для взрослых"
                    7 -> "оскорбление"
                    else -> "призывы к суициду"
                }
                println("Комментарий содержит $report.")
                sum ++
                return complain.last()
            }
        }

        return throw ComplainNotFoundId ("Complain Not Found Id")
    }
}


class PostNotFoundException(message: String) : RuntimeException(message)
class ComplainArgumentException(message: String) : RuntimeException(message)
class ComplainNotFoundId(message: String) : RuntimeException(message)

fun main(args: Array<String>) {
    WallService.add(Post(1, text = "First post"))
    WallService.add(Post(2, text = "Second post"))
    WallService.print()
    WallService.createComment(1, comment = Comment(1, text = "comment"))
    WallService.createComment(1, comment = Comment(1, 1, text = "second comment"))
    WallService.reportComment(complainNew = Complain(1, 5))
}
