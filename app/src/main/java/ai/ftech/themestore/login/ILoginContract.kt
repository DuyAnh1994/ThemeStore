package ai.ftech.themestore.login

interface ILoginContract{
    interface View{
        fun onLoginResult(state: LoginState, message: String)
    }
    interface Presenter{
        fun handleLogin(email: String, password: String)
    }

}
