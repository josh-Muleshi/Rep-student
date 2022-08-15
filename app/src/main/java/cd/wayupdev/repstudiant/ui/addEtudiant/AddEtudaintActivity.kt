package cd.wayupdev.repstudiant.ui.addEtudiant

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import cd.wayupdev.repstudiant.R
import cd.wayupdev.repstudiant.data.entity.Degre
import cd.wayupdev.repstudiant.data.entity.Etudiant
import cd.wayupdev.repstudiant.data.entity.Filiere
import cd.wayupdev.repstudiant.ui.addEtudiant.business.AddEtudiantViewModel
import cd.wayupdev.repstudiant.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_add_etudaint.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.sql.Date

@AndroidEntryPoint
class AddEtudaintActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var etudiant: Etudiant
    lateinit var filiereObj: Filiere
    lateinit var degreObj: Degre
    private val addEtudiantViewModel: AddEtudiantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_etudaint)

        backHandel()
        onEnregistrerBtnClicked()

        spinerFuction(DegreSpinner, R.array.degre)
        spinerFuction(FiliereSpinner, R.array.filiere)

    }

    private fun onEnregistrerBtnClicked(){
        btnAdd.setOnClickListener {
            val nom = etNom.text.toString()
            val prenom = etPrenom.text.toString()
            val bio = etBio.text.toString()
            val dateNaissance = etDateNaissance.text.toString()
            val desc = etDesc.text.toString()

            if(nom.isEmpty()){
                toast("champ nom ne doit pas etre vide")
            }else if (prenom.isEmpty()){
                toast("champ prenom ne doit pas etre vide")
            }else if (bio.isEmpty()){
                toast("champ bio ne doit pas etre vide")
            }else if (dateNaissance.isEmpty()){
                toast("champ dateNaissance ne doit pas etre vide")
            }else if (desc.isEmpty()){
                toast("champ decription ne doit pas etre vide")
            }else{
                val filiere = spinerFuction(FiliereSpinner, R.array.filiere)
                val degre = spinerFuction(DegreSpinner, R.array.degre)
                addStudent(nom, prenom, bio, dateNaissance, degre, filiere, desc)
                finish()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun addStudent(
        nom : String,
        prenom : String,
        bio : String,
        dateNaissance : String,
        degre : String,
        filiere : String?,
        desc : String
    ){
        filiereObj = Filiere(nom_filiere = filiere, Description = desc, date_creation = Date(System.currentTimeMillis()).toString())
        degreObj = Degre(class_degre = degre, filiere_degre = filiereObj.id_filiere)
        etudiant = Etudiant(nom_etudiant = nom, prenom_etudiant = prenom, biographie = bio, date_naissance = dateNaissance, date_enregistrement = Date(System.currentTimeMillis()).toString(), promotion_etudiant = degre,degreObj.id_degre)

        GlobalScope.launch(Dispatchers.Main){
            addEtudiantViewModel.insertData(filiereObj)
            addEtudiantViewModel.insertData(degreObj)
            addEtudiantViewModel.insertData(etudiant)
        }
    }

    private fun spinerFuction(spinner: Spinner, res : Int) : String{
        ArrayAdapter.createFromResource(this, res, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this
        spinner.selectedItemId
        return  spinner.selectedItem.toString()
    }

    private fun backHandel() {
        btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}