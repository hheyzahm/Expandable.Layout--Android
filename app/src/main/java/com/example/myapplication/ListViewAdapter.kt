package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.silencedut.expandablelayout.ExpandableLayout
import com.silencedut.expandablelayout.ExpandableLayout.OnExpandListener


/*
class ListViewAdapter(activity: FragmentActivity?) : ListAdapter {

}
*/
class ListViewAdapter internal constructor(context: Context?) : BaseAdapter() {
    private val mLayoutInflater: LayoutInflater
    private val mExpandedPositionSet = HashSet<Int>()

    init {
        mLayoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return 16
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        val expandableLayout: ExpandableLayout?
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                if (position % 2 == 0) R.layout.item_jinx else R.layout.item_ezreal,
                parent,
                false
            )
            expandableLayout =
                convertView!!.findViewById<View>(R.id.expandable_layout) as ExpandableLayout?
            expandableLayout!!.setExpandWithParentScroll(false)
            convertView.setTag(expandableLayout)
        } else {
            expandableLayout = convertView.tag as ExpandableLayout
        }
        if (expandableLayout != null) {
            expandableLayout.setOnExpandListener(OnExpandListener { registerExpand(position) })
        }
        expandableLayout!!.setExpand(mExpandedPositionSet.contains(position))
        return convertView
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