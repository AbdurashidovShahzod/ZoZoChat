package uz.unzosoft.zozochat.ui.common.channel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.unzosoft.zozochat.databinding.FragmentChannelBinding
import uz.unzosoft.zozochat.ui.base.BaseFragment


/**
 * Created by Abdurashidov Shahzod on 30/10/21 15:26.
 * company QQBank
 * shahzod9933@gmail.com
 */
class ChannelFragment : BaseFragment<FragmentChannelBinding>() {
    private val chatViewModel: ChannelViewModel by viewModels()
    override val inflaterBinding: (LayoutInflater) -> ViewBinding
        get() = FragmentChannelBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}