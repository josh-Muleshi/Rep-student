package cd.wayupdev.repstudiant.ui.addEtudiant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import cd.wayupdev.repstudiant.R
import cd.wayupdev.repstudiant.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_add_etudaint.*

class AddEtudaintActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_etudaint)

        backHandel()

        spinerFuction(DegreSpinner, R.array.degre)
        spinerFuction(FiliereSpinner, R.array.filiere)

    }

    private fun spinerFuction(spinner: Spinner, res : Int){
        ArrayAdapter.createFromResource(this, res, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this
    }

    private fun backHandel(){
        btnBack.setOnClickListener{
            val intent = Intent(this@AddEtudaintActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, p3: Long) {
        val text = parent?.getItemAtPosition(position).toString()
        Toast.makeText(parent?.context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}