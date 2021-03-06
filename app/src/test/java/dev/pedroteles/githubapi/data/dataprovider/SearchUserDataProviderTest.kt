package dev.pedroteles.githubapi.data.dataprovider

import dev.pedroteles.githubapi.data.repository.UserRepository
import dev.pedroteles.githubapi.domain.exception.GitHubUserNotFoundException
import dev.pedroteles.githubapi.domain.gateway.dataprovider.SearchUserDataProviderGateway
import dev.pedroteles.githubapi.factory.UserFactory
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchUserDataProviderTest {

    @Mock
    lateinit var repository: UserRepository

    private lateinit var dataProvider: SearchUserDataProviderGateway

    @Before
    fun setup() {
        dataProvider = SearchUserDataProvider(repository)
    }

    @Test
    fun whenDoesNotFoundUserShouldThrowException() = runBlocking {
        //given
        val username = "Test"

        Mockito.`when`(repository.searchUser(anyString())).thenReturn(null)

        //then
        try {
            dataProvider.searchUser(username)
            fail()
        } catch (e: GitHubUserNotFoundException) {
            //NOT IMPLEMENTED
        }
    }

    @Test
    fun whenFoundUserShouldReturnUserCore() = runBlocking {
        //given
        val username = "Test"
        Mockito.`when`(repository.searchUser(anyString())).thenReturn(UserFactory.validUserEntity())

        //when
        val userCore = dataProvider.searchUser(username)

        //then
        assertEquals(1, userCore.id)
        assertEquals("Test", userCore.name)
    }
}