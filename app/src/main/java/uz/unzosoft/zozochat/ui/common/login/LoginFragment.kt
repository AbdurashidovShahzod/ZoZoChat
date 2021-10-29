package uz.unzosoft.zozochat.ui.common.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.unzosoft.zozochat.R
import com.unzosoft.zozochat.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uz.unzosoft.zozochat.ui.base.BaseFragment
import uz.unzosoft.zozochat.ui.events.LoginEvent
import uz.unzosoft.zozochat.ui.extensions.showSnackBar
import uz.unzosoft.zozochat.ui.extensions.showToast
import uz.unzosoft.zozochat.ui.utils.Constants.MIN_LENGTH


/**
 * Created by Abdurashidov Shahzod on 29/10/21 23:10.
 * company QQBank
 * shahzod9933@gmail.com
 */
@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val loginViewModel: LoginViewModel by viewModels()
    override val inflaterBinding: (LayoutInflater) -> ViewBinding
        get() = FragmentLoginBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            connectUiState()
            loginViewModel.loadUser(binding.etUsername.text.toString())
        }

        binding.etUsername.addTextChangedListener {
            binding.etUsername.error = null
        }
        observerStateEvents()

    }

    private fun observerStateEvents() {
        lifecycleScope.launchWhenStarted {
            loginViewModel.loginStateEvent.collect { event ->
                when (event) {
                    is LoginEvent.CheckInternet -> {
                        connectIdUiState()
                        showSnackBar(getString(R.string.no_connect))
                    }
                    is LoginEvent.ErrorShort -> {
                        connectIdUiState()
                        binding.etUsername.error =
                            getString(R.string.error_username_too_short, MIN_LENGTH)
                    }
                    is LoginEvent.ErrorLogin -> {
                        connectIdUiState()
                        showToast(event.errorLogin)
                    }
                    is LoginEvent.Success -> {
                        connectIdUiState()
                        showToast("Success!!!!!!")
                    }
                }
            }
        }
    }

    private fun connectUiState() {
        binding.progressBar.isVisible = true
        binding.btnConfirm.isVisible = false
    }

    private fun connectIdUiState() {
        binding.progressBar.isVisible = false
        binding.btnConfirm.isVisible = true
    }

}