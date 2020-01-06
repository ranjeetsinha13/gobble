package com.rs.gobble.ui.widgets

import androidx.compose.Composable
import androidx.ui.core.Opacity
import androidx.ui.core.dp
import androidx.ui.graphics.Color
import androidx.ui.layout.Spacing
import androidx.ui.material.Divider

@Composable
internal fun divider() {
    Opacity(0.5f) {
        Divider(modifier = Spacing(left = 14.dp, right = 14.dp), color = Color.LightGray)
    }
}