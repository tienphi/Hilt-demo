package com.example.hiltbasicdemo.ui.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.hiltbasicdemo.data.Widget
import com.example.hiltbasicdemo.data.WidgetsRepository
import com.example.hiltbasicdemo.ui.viewmodel.ListWidgetsUiState.Success
import com.example.hiltbasicdemo.ui.viewmodel.ListWidgetsUiState.Error
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WidgetsViewModel @Inject constructor(
    private val widgetsRepository: WidgetsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState: MutableStateFlow<ListWidgetsUiState> =
        MutableStateFlow(ListWidgetsUiState.Loading)
    val uiState: StateFlow<ListWidgetsUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value =
                widgetsRepository.getWidgets().map<List<Widget>, ListWidgetsUiState>(::Success)
                    .catch { emit(Error(it)) }.stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.WhileSubscribed(5_000),
                        initialValue = ListWidgetsUiState.Loading
                    ).value
        }
    }
}

sealed interface ListWidgetsUiState {
    object Loading : ListWidgetsUiState
    data class Error(val throwable: Throwable) : ListWidgetsUiState
    data class Success(val data: List<Widget>) : ListWidgetsUiState
}
