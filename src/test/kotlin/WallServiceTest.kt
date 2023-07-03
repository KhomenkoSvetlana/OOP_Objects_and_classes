import org.junit.Test

import org.junit.Assert.*
import java.util.*

class WallServiceTest {
    @Test
    fun add() {
        val service = WallService
        val add = service.add(Post(12, 1, 1, date = Date(), "test1", 1, 1))

        val addResult = add.id

        assertEquals(addResult,13)
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
        service.add(Post(1, 2, 2, date = Date(), "test2", 2, 2))

        val update = Post(1, 2, 2, date = Date(), "test2", 2, 2)

        val result = service.update(update)

        assertFalse(result)
    }

}
