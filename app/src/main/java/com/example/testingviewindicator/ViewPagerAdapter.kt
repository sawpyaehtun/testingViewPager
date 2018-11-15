package com.example.testingviewindicator

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.view_indicator_item.view.*

class ViewPagerAdapter(val list : Array<String>,val context : Context) : PagerAdapter() {

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0===p1
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
       val view =  LayoutInflater.from(context).inflate(
            R.layout.view_indicator_item, container, false
        ) as View

        view.title.text = context.resources.getString(R.string.onboarding_one)//list[position]
        view.btdone.visibility = if(position==3) View.VISIBLE else View.GONE

        view.btclose.setOnClickListener {
            Toast.makeText(context,"close",Toast.LENGTH_SHORT).show()
        }

        view.btdone.setOnClickListener {
            Toast.makeText(context,"Done",Toast.LENGTH_SHORT).show()
        }
        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }
}