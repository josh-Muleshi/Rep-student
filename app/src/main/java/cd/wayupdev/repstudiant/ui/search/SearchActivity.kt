package cd.wayupdev.repstudiant.ui.search

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import cd.wayupdev.repstudiant.R
import cd.wayupdev.repstudiant.adapter.MyAdapter
import cd.wayupdev.repstudiant.ui.search.business.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val searchViewModel: SearchViewModel by viewModels()
    private val myAdapter: MyAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = myAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"

        searchViewModel.searchDatabase(searchQuery).observe(this) { list ->
            list.let {
                myAdapter.setData(it)
            }
        }
    }
}