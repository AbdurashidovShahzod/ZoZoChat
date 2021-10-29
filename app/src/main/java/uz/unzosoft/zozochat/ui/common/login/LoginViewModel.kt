package uz.unzosoft.zozochat.ui.common.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.getstream.chat.android.client.ChatClient
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

}