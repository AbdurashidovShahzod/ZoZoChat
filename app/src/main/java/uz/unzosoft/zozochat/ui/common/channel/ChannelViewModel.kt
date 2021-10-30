package uz.unzosoft.zozochat.ui.common.channel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.unzosoft.zozochat.databinding.FragmentChannelBinding
import io.getstream.chat.android.client.ChatClient
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

}