import java.util.Date

data class Post(
    val id: Int, // Идентификатор записи
    val ownerId: Int, // Id владельца стены
    val fromId: Int, // Id автора записи
    val date: Date = Date(),
    val text: String,
    val replyOwnerId: Int, // Id владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int, // Id записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean = false, // 1, если запись была создана с опцией «Только для друзей».
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val likes: Likes = Likes(),
    val views: Views = Views()
)

class Likes(
    val count: Int = 0, // число пользователей, которым понравилась запись
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

class Views(
    val count: Int = 0 //число просмотров записи
)

object WallService {
    private var postsOnTheWall = emptyArray<Post>()

    fun add(post: Post): Post {
        var lastId = post.id
        postsOnTheWall += post.copy(id = ++lastId)
        return postsOnTheWall.last()
    }

    fun update(updatePost: Post): Boolean {
        for ((index, post) in postsOnTheWall.withIndex()) {
            if (post.id == updatePost.id) {
                postsOnTheWall[index] = post.copy()
                return true
            }
        }
        return false
    }

}

fun main(args: Array<String>) {
  println(WallService.add(Post(1,0,0, date = Date(), "First post", 5, 6)))
    val x = WallService.add(Post(1,0,0, date = Date(), "First post", 5, 6))

    println(x)

}
