package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        // val user = User("1")
        val user2 = User("2", "John", "Cena")
        //val user3 = User("3", "John", "Silverhand", null, lastVisit = Date(), isOnline = true)

        // user.printMe()
        //user2.printMe()
        // user3.printMe()

        // println("$user ")
    }

    @Test
    fun testFactory() {
        //val user = User.makeUser("John Cena")
        //val user2 = User.makeUser("")
        val user = User.makeUser("John Wick")
        val user2 = user.copy(id = "2", lastname = "Cena", lastVisit = Date())
        print("$user \n$user2")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")
        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user3 = user.copy(lastname = "Cena", lastVisit = Date().add(3, TimeUnits.HOUR))
        val user4 = user.copy(lastname = "Cena", lastVisit = Date())

        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
            """.trimIndent()
        )
    }
    @Test
    fun test_data_mapping() {
        val user = User.makeUser("John Doe")
        println(user)
        val userView = user.toUserView()
        userView.printMe()
    }
    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("John Doe")
        val textMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "any text message" , type = "text")
        val imageMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "any image url" , type = "image")

        when(imageMessage){
            is BaseMessage -> println("FUCK! This is a base message!")
            is TextMessage -> println("FUCK! This is a text message!".truncate())
            is ImageMessage -> println("FUCK! This is an image message!".truncate(12))

        }
        println(textMessage.formatMessage())
        println(imageMessage.formatMessage())

    }

}
