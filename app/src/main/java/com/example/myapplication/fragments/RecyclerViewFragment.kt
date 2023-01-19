package com.example.myapplication.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.SummonerAdapter


class RecyclerViewFragment : Fragment() {
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        val summonerList: RecyclerView
        summonerList = rootView.findViewById<View>(R.id.recyclerView) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(activity)
        summonerList.layoutManager = linearLayoutManager
        val summonerAdapter = SummonerAdapter(activity)
        summonerList.adapter = summonerAdapter
        return rootView
    }

    companion object {
        fun newInstance(): RecyclerViewFragment {
            return RecyclerViewFragment()
        }
    }
}