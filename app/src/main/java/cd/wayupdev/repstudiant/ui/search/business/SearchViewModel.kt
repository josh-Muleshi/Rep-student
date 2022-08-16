package cd.wayupdev.repstudiant.ui.search.business

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cd.wayupdev.repstudiant.data.entity.Etudiant
import cd.wayupdev.repstudiant.data.repository.EtudiantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
        private val etudiantRepository : EtudiantRepository
    ) : ViewModel() {

    fun findAll(isAcs: Boolean): LiveData<List<Etudiant>>{
        return etudiantRepository.findAll(isAcs).asLiveData()
    }

    fun findByid(etudiantID : Int): LiveData<Etudiant> {
        return etudiantRepository.findByid(etudiantID).asLiveData()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Etudiant>> {
        return etudiantRepository.searchDatabase(searchQuery).asLiveData()
    }
}