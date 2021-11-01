package uz.unzosoft.zozochat.ui.common.channel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.unzosoft.zozochat.databinding.FragmentChannelBinding
import io.getstream.chat.android.client.ChatClient
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import uz.unzosoft.zozochat.ui.base.BaseFragment
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 30/10/21 15:26.
 * company QQBank
 * shahzod9933@gmail.com
 */
class ChannelViewModel @Inject constructor(
    private val chatClient: ChatClient
) : ViewModel() {
    fun logout() {
        chatClient.disconnect()
    }

    private val _channelState = MutableSharedFlow<ChannelState>()
    val channelState = _channelState.asSharedFlow()




}

sealed class ChannelState() {
    object Success : ChannelState()
    object Network : ChannelState()
    data class Error(val errorChannel:String) : ChannelState()
}