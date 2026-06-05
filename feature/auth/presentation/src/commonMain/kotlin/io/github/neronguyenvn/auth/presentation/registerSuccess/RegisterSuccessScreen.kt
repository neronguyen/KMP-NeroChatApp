package io.github.neronguyenvn.auth.presentation.registerSuccess

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.zacsweers.metrox.viewmodel.metroViewModel
import io.github.neronguyenvn.core.designsystem.components.NeroButton
import io.github.neronguyenvn.core.designsystem.components.NeroButtonStyle
import io.github.neronguyenvn.core.designsystem.components.NeroSuccessIcon
import io.github.neronguyenvn.core.designsystem.layouts.NeroResultLayout
import io.github.neronguyenvn.core.designsystem.layouts.NeroSuccessLayout
import io.github.neronguyenvn.core.designsystem.theme.NeroTheme
import kmpnerochatapp.feature.auth.presentation.generated.resources.Res
import kmpnerochatapp.feature.auth.presentation.generated.resources.account_successfully_created
import kmpnerochatapp.feature.auth.presentation.generated.resources.login
import kmpnerochatapp.feature.auth.presentation.generated.resources.resend_verification_email
import kmpnerochatapp.feature.auth.presentation.generated.resources.verification_email_sent_to_x
import org.jetbrains.compose.resources.stringResource

@Composable
fun RegisterSuccessRoute(viewModel: RegisterSuccessViewModel = metroViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    RegisterSuccessScreen(
        uiState = uiState,
        onIntent = viewModel::onIntent
    )
}

@Composable
private fun RegisterSuccessScreen(
    uiState: RegisterSuccessUiState,
    onIntent: (RegisterSuccessIntent) -> Unit
) {
    NeroResultLayout {
        NeroSuccessLayout(
            title = stringResource(Res.string.account_successfully_created),
            description = stringResource(
                Res.string.verification_email_sent_to_x,
                uiState.registeredEmail
            ),
            icon = { NeroSuccessIcon() },
            primaryButton = {
                NeroButton(
                    text = stringResource(Res.string.login),
                    onClick = { onIntent(RegisterSuccessIntent.ResendVerificationEmail) },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            secondaryButton = {
                NeroButton(
                    text = stringResource(Res.string.resend_verification_email),
                    onClick = { onIntent(RegisterSuccessIntent.NavigateToLogin) },
                    style = NeroButtonStyle.Secondary,
                    isLoading = uiState.isResendingVerificationEmail,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        )
    }
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
private fun RegisterSuccessScreenPreview() {
    NeroTheme {
        RegisterSuccessScreen(
            uiState = RegisterSuccessUiState(
                registeredEmail = "james.madison@examplepetstore.com"
            ),
            onIntent = {}
        )
    }
}
