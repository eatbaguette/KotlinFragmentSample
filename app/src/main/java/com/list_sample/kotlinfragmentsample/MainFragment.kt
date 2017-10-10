package com.list_sample.kotlinfragmentsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by monkey on 2017/10/10.
 */
class MainFragment : Fragment() {
    lateinit var textShown: String
    lateinit var textView: TextView

    val TEXT_SHOWN = "textShow"

    companion object {
        fun newInstance(): Fragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    //Bundleを作成。値もここで渡す
    fun createBundle(bundle: Bundle, textShown: String?): Bundle {
        bundle.putString(TEXT_SHOWN, textShown)

        return bundle
    }

    //主にViewのセットアップをする。
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        this.textShown = arguments[TEXT_SHOWN] as String

        textView = view.findViewById<TextView>(R.id.text_view_fragment_main) as TextView
        textView.text = textShown

        return view
    }


}