package dev.pedroteles.githubapi.domain.usecase

import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import dev.pedroteles.githubapi.domain.gateway.dataprovider.SearchUserDataProviderGateway
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SearchUserUseCaseTest {

    @Mock
    private lateinit var dataProvider: SearchUserDataProviderGateway

    @Captor
    lateinit var nameCaptor: ArgumentCaptor<String>

    private lateinit var useCase: SearchUserUseCase

    @Before
    fun setup() {
        useCase = SearchUserUseCase(dataProvider)
    }

    @Test
    fun whenPassUserNameShouldPassItToDataProvider() = runBlocking {
        //given
        val username = "test"

        Mockito.`when`(dataProvider.searchUser(capture(nameCaptor))).thenReturn(null)

        //when
        useCase.searchUser(username)

        //then
        verify(dataProvider, times(1)).searchUser(capture(nameCaptor))
        assertEquals(username, nameCaptor.value)
    }
}