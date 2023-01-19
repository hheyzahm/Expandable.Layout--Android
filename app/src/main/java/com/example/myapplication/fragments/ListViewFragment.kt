package com.example.myapplication.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.myapplication.ListViewAdapter
import com.example.myapplication.R


class ListViewFragment : Fragment() {

    fun newInstance(): ListViewFragment? {
        return ListViewFragment()
    }

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_list_view, container, false)
        val summonerList: ListView
        summonerList = rootView.findViewById<View>(R.id.listView) as ListView
        summonerList.setAdapter(ListViewAdapter(activity))
        return rootView
    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_view, container, false)
    }
*/

}