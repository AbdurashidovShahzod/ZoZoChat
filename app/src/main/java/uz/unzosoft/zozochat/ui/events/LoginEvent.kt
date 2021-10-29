package uz.unzosoft.zozochat.ui.events


/**
 * Created by Abdurashidov Shahzod on 29/10/21 23:45.
 * company QQBank
 * shahzod9933@gmail.com
 */
sealed class LoginEvent {
    object Success : LoginEvent()
    object ErrorShort : LoginEvent()
    object CheckInternet : LoginEvent()
    data class ErrorLogin(val errorLogin: String) : LoginEvent()
}
