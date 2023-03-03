package ai.ftech.themestore.login

enum class LoginState {
    SUCCESS,
    WRONG_EMAIL_OR_PASSWORD,
    EMPTY_EMAIL,
    INVALID_EMAIL_FORMAT,
    EMPTY_PASSWORD,
    INVALID_PASSWORD_FORMAT,
}
