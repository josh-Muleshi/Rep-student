package cd.wayupdev.repstudiant.ui.addEtudiant.business

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.wayupdev.repstudiant.data.entity.Etudiant
import cd.wayupdev.repstudiant.data.repository.EtudiantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEtudiantViewModel @Inject constructor(
    private val etudiantRepository: EtudiantRepository
) : ViewModel() {
    fun insertData(etudiant: Etudiant){
        viewModelScope.launch(Dispatchers.IO){
            etudiantRepository.insertData(etudiant)
        }
    }
}