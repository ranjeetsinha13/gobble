package com.rs.gobble.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.ui.core.Text
import androidx.ui.core.setContent
import com.rs.gobble.R
import com.rs.gobble.di.Injectable

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
            Text("Favorites Compose")
        }
        return fragmentView
    }
}