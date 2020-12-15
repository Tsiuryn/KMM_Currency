package by.st.generatorforms.athis.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import by.st.generatorforms.athis.androidApp.adapter.CurrencyAdapter
import by.st.generatorforms.athis.shared.model.Currency
import by.st.generatorforms.athis.shared.network.MyNet
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    private lateinit var launchesRecyclerView: RecyclerView
    private lateinit var progressBarView: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout


    private val launchesRvAdapter = CurrencyAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "NBRB"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        launchesRecyclerView = findViewById(R.id.launchesListRv)
        progressBarView = findViewById(R.id.progressBar)
        swipeRefreshLayout = findViewById(R.id.swipeContainer)

        launchesRecyclerView.adapter = launchesRvAdapter
        launchesRecyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            displayLaunches(true)
        }

        displayLaunches(false)

    }
    private fun displayLaunches(needReload: Boolean) {
        progressBarView.visibility = ProgressBar.VISIBLE
        var myList: List<Currency>
        mainScope.launch {
            kotlin.runCatching {
                myList = MyNet().getAllLaunches()
                launchesRvAdapter.updateAdapter(myList)
            }.onSuccess { it ->
                Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_SHORT).show()
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            progressBarView.visibility = ProgressBar.INVISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
