package com.rs.gobble.ui

import android.content.res.Resources
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import com.rs.gobble.R
import com.rs.gobble.ui.widgets.searchForm

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
    Column {
        searchForm("") { query ->

            if (query.isEmpty()) {
                return@searchForm
            }
            // TODO send the query to viewModel and update the UI
        }
        VerticalScroller(modifier = Flexible(1f)) {
            Column {
                arrayListOf<String>("1", "2", "3").map {
                    Row {
                        Padding(10.dp, 2.dp, 2.dp, 10.dp) {
                            Text(it, style = Typography().body1)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun favoritesTab() {
    Text("2")
}
