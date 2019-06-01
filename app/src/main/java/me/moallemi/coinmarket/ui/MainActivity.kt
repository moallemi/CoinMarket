package me.moallemi.coinmarket.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.moallemi.coinmarket.R
import me.moallemi.coinmarket.ui.browse.BrowseFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager?.beginTransaction()
            ?.replace(R.id.contentFrame, BrowseFragment())
            ?.commit()
    }
}
