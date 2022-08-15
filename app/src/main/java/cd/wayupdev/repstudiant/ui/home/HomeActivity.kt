package cd.wayupdev.repstudiant.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import cd.wayupdev.repstudiant.R
import cd.wayupdev.repstudiant.adapter.MyAdapter
import cd.wayupdev.repstudiant.ui.addEtudiant.AddEtudaintActivity
import cd.wayupdev.repstudiant.ui.home.business.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val myAdapter: MyAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = myAdapter

        homeViewModel.findAll.observe(this) {
            myAdapter.setData(it)
        }

        floatingActionButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, AddEtudaintActivity::class.java)
            startActivity(intent)
        }
    }
}