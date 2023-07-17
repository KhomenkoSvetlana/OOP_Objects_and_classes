import org.junit.Test
import org.junit.Assert.*
import java.util.*

class WallServiceTest {
    @Test
    fun add() {
        val service = WallService
        val add = service.add(Post(5, 1, 1, date = Date(), "test1", 1, 1))

        val addResult = add.id

        assertEquals(addResult,5)
    }

    @Test
    fun updateTrue() {
        val service = WallService
        service.add(Post(1, 1, 1, date = Date(), "test1", 1, 1))
        service.add(Post(2, 2, 2, date = Date(), "test2", 2, 2))
        service.add(Post(3, 3, 3, date = Date(), "test3", 2, 2))

        val update = Post(2, 4, 3, date = Date(), "test4", 2, 2)

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val service = WallService
        service.add(Post(1, 1, 1, date = Date(), "test1", 1, 1))
        service.add(Post(2, 2, 2, date = Date(), "test2", 2, 2))

        val update = Post(3, 2, 2, date = Date(), "test2", 2, 2)

        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun createComment () {
        val service = WallService
        service.add(Post(1, 1, 1, date = Date(), "test1", 1, 1))
        val create = service.createComment(1, comment = Comment(1,0,date = Date(), "test"))

        val createResult = create.postId

        assertEquals(createResult, 1)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService
        service.add(Post(1, 1, 1, date = Date(), "test1", 1, 1))
        val create = service.createComment(3, comment = Comment(1,0,date = Date(), "test"))
    }

    @Test
    fun reportComment () {
        val service = WallService
        service.add(Post(1, 1, 1, date = Date(), "test1", 1, 1))
        service.createComment(1, comment = Comment(1,1, date = Date(), "test"))

        val reportComment = service.reportComment(complainNew = Complain(1, 7))
        val result = reportComment //не понимаю как присовоить переменной result значение commentId сщзданной жалобы???

    }

    @Test(expected = ComplainArgumentException::class)
    fun ComplainArgumentException() {
        val service = WallService
        service.add(Post(1, 1, 1, date = Date(), "test1", 1, 1))
        service.createComment(1, comment = Comment(1,1, date = Date(), "test"))
        val report = service.reportComment(complainNew = Complain(1, 9))
    }

    @Test (expected = ComplainNotFoundId::class)
    fun ComplainNotFoundId() {
        val service = WallService
        service.add(Post(1, 1, 1, date = Date(), "test1", 1, 1))
        service.createComment(1, comment = Comment(1,1, date = Date(), "test"))
        val report = service.reportComment(complainNew = Complain(2, 1))
    }


}
