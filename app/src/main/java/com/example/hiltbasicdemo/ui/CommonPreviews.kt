package com.example.hiltbasicdemo.ui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    showBackground = true,
    widthDp = 900,
    heightDp = 450
)
@Preview(
    showBackground = true,
    widthDp = 450,
    heightDp = 900
)
annotation class LandscapePortraitPreviews

@Preview(
    showBackground = true
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class LightDarkPreviews

@Preview(
    showBackground = true
)
annotation class BackgroundPreviews
