package cd.wayupdev.repstudiant.ui.addEtudiant.business

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import cd.wayupdev.repstudiant.data.entity.Degre
import cd.wayupdev.repstudiant.data.entity.Etudiant
import cd.wayupdev.repstudiant.data.entity.EtudiantDegre
import cd.wayupdev.repstudiant.data.entity.Filiere
import cd.wayupdev.repstudiant.data.repository.DegreRepository
import cd.wayupdev.repstudiant.data.repository.EtudiantRepository
import cd.wayupdev.repstudiant.data.repository.FiliereRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEtudiantViewModel @Inject constructor(
    private val filiereRepository: FiliereRepository,
    private val degreRepository: DegreRepository,
    private val etudiantRepository: EtudiantRepository
) : ViewModel() {
    fun insertData(etudiant: Etudiant){
        viewModelScope.launch(Dispatchers.IO){
            etudiantRepository.insertData(etudiant)
        }
    }

    fun insertData(degre: Degre){
        viewModelScope.launch(Dispatchers.IO){
            degreRepository.insertData(degre)
        }
    }

    fun insertData(filiere: Filiere){
        viewModelScope.launch(Dispatchers.IO){
            filiereRepository.insertData(filiere)
        }
    }

    fun searchOneDegre(searchQuery: String): LiveData<Degre>{
        return degreRepository.searchOne(searchQuery).asLiveData()
    }

    fun searchOneFiliere(searchQuery: String): LiveData<Filiere>{
        return filiereRepository.searchOne(searchQuery).asLiveData()
    }

    fun findDegreAndEtudiant() : LiveData<List<EtudiantDegre>>{
        return degreRepository.findDegreAndEtudiant().asLiveData()
    }
}