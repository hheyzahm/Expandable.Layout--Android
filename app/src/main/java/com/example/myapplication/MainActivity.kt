package com.example.myapplication



import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.fragments.ListViewFragment
import com.example.myapplication.fragments.RecyclerViewFragment
import com.example.myapplication.fragments.SimpleUseFragment
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tabLayout = findViewById<View>(R.id.tableLayout) as TabLayout
        val viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SamplePageAdapter(supportFragmentManager)

        val fragment1: Fragment = RecyclerViewFragment()
        val data1 = Bundle()
        data1.putInt("id", 0)
        fragment1.setArguments(data1)
        adapter.addFrag(fragment1, getString(R.string.UsageOne))

        val fragment2: Fragment = ListViewFragment()
        val data2 = Bundle()
        data2.putInt("id", 0)
        fragment2.setArguments(data2)
        adapter.addFrag(fragment2, getString(R.string.UsageTwo))

        val fragment3: Fragment = SimpleUseFragment()
        val data3 = Bundle()
        data3.putInt("id", 0)
        fragment3.setArguments(data3)
        adapter.addFrag(fragment3, getString(R.string.UsageThree))

        viewPager.adapter = adapter

    }
}