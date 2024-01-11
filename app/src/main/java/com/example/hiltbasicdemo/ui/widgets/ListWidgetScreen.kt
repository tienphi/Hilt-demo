package com.example.hiltbasicdemo.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hiltbasicdemo.ui.LandscapePortraitPreviews
import com.example.hiltbasicdemo.ui.WidgetType
import com.example.hiltbasicdemo.ui.theme.HiltBasicDemoTheme


@Composable
fun WidgetsScreen(modifier: Modifier, viewModel: WidgetsViewModel = hiltViewModel()) {

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