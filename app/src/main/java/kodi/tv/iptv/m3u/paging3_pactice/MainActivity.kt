package kodi.tv.iptv.m3u.paging3_pactice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kodi.tv.iptv.m3u.paging3_pactice.Paging.QuotePageAdapter
import kodi.tv.iptv.m3u.paging3_pactice.View_Model.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var adapter: QuotePageAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_Qute)
        adapter = QuotePageAdapter()
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        viewModel.data.observe(this, Observer {
            adapter.submitData(lifecycle, it)
            Log.e("data", it.toString())
        })
    }
}