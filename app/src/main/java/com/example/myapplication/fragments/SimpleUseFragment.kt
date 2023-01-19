package com.example.myapplication.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.silencedut.expandablelayout.ExpandableLayout


class SimpleUseFragment : Fragment() {
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_simple_use, container, false)
        val expandableLayout =
            rootView.findViewById<View>(R.id.expandable_layout) as ExpandableLayout
        expandableLayout.setOnExpandListener { expanded ->
            Toast.makeText(
                activity,
                "expand?$expanded",
                Toast.LENGTH_SHORT
            ).show()
        }
        return rootView
    }

    companion object {
        fun newInstance(): RecyclerViewFragment {
            return RecyclerViewFragment()
        }
    }
}