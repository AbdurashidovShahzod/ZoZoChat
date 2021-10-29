package uz.unzosoft.zozochat.ui.common.login

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.unzosoft.zozochat.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.unzosoft.zozochat.ui.base.BaseFragment


/**
 * Created by Abdurashidov Shahzod on 29/10/21 23:10.
 * company QQBank
 * shahzod9933@gmail.com
 */
@AndroidEntryPoint
class LoginFragment:BaseFragment<FragmentLoginBinding>() {

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentLoginBinding::inflate

}