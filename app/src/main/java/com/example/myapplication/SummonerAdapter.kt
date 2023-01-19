package com.example.myapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silencedut.expandablelayout.ExpandableLayout


public class SummonerAdapter(context: Context?) : RecyclerView.Adapter<SummonerAdapter.SummonerHolder>() {
    private val mInflater: LayoutInflater
    private val mExpandedPositionSet: HashSet<Int> = HashSet()

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummonerHolder {
        val item: View = mInflater.inflate(
            if (viewType == 0) R.layout.item_ezreal else R.layout.item_jinx,
            parent,
            false
        )
        return SummonerHolder(item)
    }

    override fun onBindViewHolder(holder: SummonerHolder, position: Int) {
        holder.updateItem(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    override fun getItemCount(): Int {
        return 20
    }

    inner class SummonerHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val expandableLayout: ExpandableLayout

        init {
            expandableLayout = itemView.findViewById(R.id.expandable_layout)
        }

        fun updateItem(position: Int) {
            expandableLayout.setOnExpandListener { registerExpand(position) }
            expandableLayout.setExpand(mExpandedPositionSet.contains(position))
        }
    }

    private fun registerExpand(position: Int) {
        if (mExpandedPositionSet.contains(position)) {
            removeExpand(position)
        } else {
            addExpand(position)
        }
    }

    private fun removeExpand(position: Int) {
        mExpandedPositionSet.remove(position)
    }

    private fun addExpand(position: Int) {
        mExpandedPositionSet.add(position)
    }
}