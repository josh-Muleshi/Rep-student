package cd.wayupdev.repstudiant.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cd.wayupdev.repstudiant.R
import cd.wayupdev.repstudiant.ui.addEtudiant.AddEtudaintActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        floatingActionButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, AddEtudaintActivity::class.java)
            startActivity(intent)
        }
    }
}