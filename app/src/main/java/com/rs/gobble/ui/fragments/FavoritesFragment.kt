package com.rs.gobble.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Composable
import androidx.fragment.app.Fragment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.layout.*
import com.rs.gobble.R
import com.rs.gobble.di.Injectable
import com.rs.gobble.ui.widgets.Image

class FavoritesFragment : Fragment(), Injectable {

    companion object {
        fun newInstance() = FavoritesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.view_fragment, container, false)
        (fragmentView as ViewGroup).setContent {
            favContent()
        }
        return fragmentView
    }

    @Composable
    private fun favContent() {

        Padding(4.dp, 4.dp, 4.dp, 4.dp) {
            FlexRow {
                inflexible {
                    Row(modifier = Size(96.dp, 144.dp), arrangement = Arrangement.SpaceEvenly) {
                        Image(
                            "https://spoonacular.com/recipeImages/corn-and-tomato-salad-with-cilantro-dressing-2-96104.jpg",
                            144.dp,
                            96.dp
                        )
                    }
                }
                flexible(1.0f) {
                    Text("some")
                    Text("one")
                }
            }
        }
    }
}
