package com.template.montiel.visual.ui.compose.theme

import LightColors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun TemplateTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        content = content
    )
}
