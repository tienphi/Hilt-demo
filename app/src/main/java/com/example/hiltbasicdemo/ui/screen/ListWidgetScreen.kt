package com.example.hiltbasicdemo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hiltbasicdemo.ui.LandscapePortraitPreviews
import com.example.hiltbasicdemo.ui.WidgetType
import com.example.hiltbasicdemo.ui.theme.HiltBasicDemoTheme
import com.example.hiltbasicdemo.ui.viewmodel.ListWidgetsUiState
import com.example.hiltbasicdemo.ui.viewmodel.WidgetsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WidgetsScreen(modifier: Modifier, viewModel: WidgetsViewModel = hiltViewModel()) {
    val items by viewModel.uiState.collectAsStateWithLifecycle()
    if (items is ListWidgetsUiState.Success) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("List widgets")
                    }
                )
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                ListWidgets(widgets = (items as ListWidgetsUiState.Success).data.map {
                    it.name
                }, modifier = modifier)
            }
        }
    }
}

@Composable
fun ListWidgets(widgets: List<String>, modifier: Modifier = Modifier) {
    if (widgets.isEmpty()) {
        Text(text = "Not have any widgets!")
    } else {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
        ) {
            items(widgets) { widget ->
                WidgetType(name = widget)
            }
        }
    }
}

@LandscapePortraitPreviews
@Composable
fun ListWidgetsPreview() {
    HiltBasicDemoTheme {
        ListWidgets(widgets = listOf("Weather", "Music", "Compass"))
    }
}

@LandscapePortraitPreviews
@Composable
fun ListWidgetsEmptyPreview() {
    HiltBasicDemoTheme {
        ListWidgets(widgets = listOf())
    }
}
