package uz.unzosoft.zozochat.ui.common.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.call.await
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import uz.unzosoft.zozochat.ui.events.LoginEvent
import uz.unzosoft.zozochat.ui.utils.Constants.MIN_LENGTH
import uz.unzosoft.zozochat.ui.utils.isConnected
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 29/10/21 23:16.
 * company QQBank
 * shahzod9933@gmail.com
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val chatClient: ChatClient
) : ViewModel() {
    private val _loginStateEvent = MutableSharedFlow<LoginEvent>()
    val loginStateEvent = _loginStateEvent.asSharedFlow()

    private fun isValidateUser(name: String) = name.length >= MIN_LENGTH


    fun loadUser(name: String) {
        val userName = name.trim()
        viewModelScope.launch {
            if (isConnected()) {
                if (isValidateUser(userName)) {
                    val resultUser = chatClient.connectGuestUser(
                        userId = userName,
                        username = userName
                    ).await()
                    if (resultUser.isError) {
                        _loginStateEvent.emit(LoginEvent.ErrorLogin(resultUser.error().message!!))
                        return@launch
                    }
                    _loginStateEvent.emit(LoginEvent.Success)
                } else {
                    _loginStateEvent.emit(LoginEvent.ErrorShort)
                }
            } else {
                _loginStateEvent.emit(LoginEvent.CheckInternet)
            }
        }
    }
}