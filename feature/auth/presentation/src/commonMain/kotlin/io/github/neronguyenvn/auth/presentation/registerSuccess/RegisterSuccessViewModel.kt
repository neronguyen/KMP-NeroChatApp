package io.github.neronguyenvn.auth.presentation.registerSuccess

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Inject
@ViewModelKey
@ContributesIntoMap(AppScope::class)
class RegisterSuccessViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RegisterSuccessUiState())
    val uiState = _uiState.asStateFlow()

    fun onIntent(intent: RegisterSuccessIntent) {
        // TODO: Handle intents
    }
}