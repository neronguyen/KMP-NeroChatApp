package io.github.neronguyenvn.auth.presentation.registerSuccess

data class RegisterSuccessUiState(
    val registeredEmail: String = "",
    val isResendingVerificationEmail: Boolean = false
)

sealed interface RegisterSuccessIntent {
    data object NavigateToLogin : RegisterSuccessIntent
    data object ResendVerificationEmail : RegisterSuccessIntent
}
