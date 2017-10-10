package com.list_sample.kotlinfragmentsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabShowFragment = findViewById(R.id.fab_show_fragment_main_activity)
        fabShowFragment.setOnClickListener { showFragment() }
    }

    fun showFragment() {
        val bundle = MainFragment().createBundle(Bundle(), "hoge")
        val fragment = MainFragment.newInstance()
        fragment.arguments = bundle

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction
                .replace(R.id.activity_main, fragment)// addを使うとスタックで積み重なっていく。replaceだと一つだけ。
                .addToBackStack(null) // バックスタックを使うとバックキーでfragmentから呼び出し元のActivityに戻れる
                .commit()
    }
}
