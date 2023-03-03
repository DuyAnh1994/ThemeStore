package ai.ftech.themestore.login

import android.util.Patterns

class LoginPresenter : ILoginContract.Presenter {
    var view: ILoginContract.View? = null
    override fun handleLogin(email: String, password: String) {
        when {
            isTrueAccount(email, password) -> {
                view?.onLoginResult(
                    LoginState.SUCCESS,
                    "Đăng nhập thành công!"
                )
            }
            !isTrueAccount(email, password) -> view?.onLoginResult(
                LoginState.WRONG_EMAIL_OR_PASSWORD,
                "Sai email hoặc mật khẩu!"
            )
            email.isEmpty() -> view?.onLoginResult(
                LoginState.EMPTY_EMAIL,
                "Email không thể bỏ trống!"
            )
            password.isEmpty() -> view?.onLoginResult(
                LoginState.EMPTY_PASSWORD,
                "Mật khẩu không thể bỏ trống!"
            )
            !isValidEmail(email) -> view?.onLoginResult(
                LoginState.INVALID_EMAIL_FORMAT,
                "Email không hợp lệ!"
            )
            !isValidPassword(password) -> view?.onLoginResult(
                LoginState.INVALID_PASSWORD_FORMAT,
                "Mật khẩu không đúng, mật khẩu cần nhiều hơn 8 kí tự !"
            )
        }
    }

    private fun isTrueAccount(email: String, password: String): Boolean {
        return email == "thomnt@gmail.com" && password == "12345678"
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }
}
