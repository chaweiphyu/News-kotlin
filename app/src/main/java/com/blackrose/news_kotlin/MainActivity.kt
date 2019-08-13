package com.blackrose.news_kotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.blackrose.news_kotlin.models.Article
import com.blackrose.news_kotlin.remote.RemoteDataSource
import com.list.rados.fast_list.bind
import com.list.rados.fast_list.update

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.list_item_news.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        news_swipe_refresh.setOnRefreshListener {
            getNews()
        }

        news_swipe_refresh.isRefreshing = true
        getNews()
        rvNews.bind(emptyList(), R.layout.list_item_news){ data : Article ->
            this.tv_news_title.text = data.title
        }.layoutManager(LinearLayoutManager(applicationContext))



    }

    private fun getNews() {
        RemoteDataSource.loadNews({
            // TODO update ui
            news_swipe_refresh.isRefreshing = false
            rvNews.update(it)

        }, {
            news_swipe_refresh.isRefreshing = false
            // TODO show toast
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
