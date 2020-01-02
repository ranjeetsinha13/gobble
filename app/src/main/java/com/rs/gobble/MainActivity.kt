package com.rs.gobble

import android.os.Bundle
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.layout.Column
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.material.TopAppBar
import androidx.ui.res.imageResource
import com.rs.gobble.extensions.replaceFragment
import com.rs.gobble.ui.VectorImage
import com.rs.gobble.ui.fragments.FavoritesFragment
import com.rs.gobble.ui.fragments.SearchFragment
import kotlinx.android.synthetic.main.main_activity.*

private enum class Sections(val title: String, val icon: Int) {
    Discover("Discover", android.R.drawable.ic_menu_search),
    Favorites("My favorites", android.R.drawable.star_on)
}

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initViews()
    }

    private fun initViews() {
        top_bar.setContent {
            gobbleApp()
        }
    }

    @Composable
    fun gobbleApp() {
        var section by +state { Sections.Discover }
        val sections = Sections.values().map { it }

        Column {
            TopAppBar(title = {
                Text(resources.getString(R.string.app_name))
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

            when (section) {
                Sections.Discover -> {
                    this@MainActivity.replaceFragment(
                        R.id.content_tab,
                        supportFragmentManager.findFragmentByTag(SearchFragment::class.java.name)
                            ?: SearchFragment.newInstance()
                    )
                }
                Sections.Favorites -> {
                    this@MainActivity.replaceFragment(
                        R.id.content_tab,
                        supportFragmentManager.findFragmentByTag(FavoritesFragment::class.java.name)
                            ?: FavoritesFragment.newInstance()
                    )
                }
            }
        }
    }
}