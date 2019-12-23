package com.rs.gobble.ui

import android.content.res.Resources
import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import com.rs.gobble.R

private enum class Sections(val title: String, val icon: Int) {
    Discover("Discover", android.R.drawable.ic_menu_search),
    Favorites("My favorites", android.R.drawable.star_on)
}

@Composable
@Preview
fun GobbleApp(res: Resources) {

    var section by +state { Sections.Discover }
    val sections = Sections.values().map { it }

    Column {
        TopAppBar(title = {
            Text(res.getString(R.string.app_name))
        }, navigationIcon = {
            VectorImage(id = R.drawable.ic_home_24px)
        })

        TabRow(items = sections, selectedIndex = section.ordinal) { index, _section ->
            Tab(
                text = _section.title,
                icon = +imageResource(_section.icon),
                selected = section.ordinal == index
            ) {
                section = Sections.values()[index]
            }
        }

        Container(modifier = Flexible(1f)) {
            when (section) {
                Sections.Discover -> DiscoverTab()
                Sections.Favorites -> favoritesTab()
            }
        }
    }
}

@Composable
private fun DiscoverTab() {
    Text("1")
}

@Composable
private fun favoritesTab() {
    Text("2")
}

@Composable
private fun BottomBarAction(
    @DrawableRes id: Int,
    onClick: () -> Unit
) {
    Ripple(
        bounded = false,
        radius = 24.dp
    ) {
        Clickable(onClick = onClick) {
            Container(modifier = Spacing(12.dp) wraps Size(24.dp, 24.dp)) {
                DrawVector(+vectorResource(id))
            }
        }
    }
}