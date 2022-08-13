package cd.wayupdev.repstudiant.ui.addEtudiant.business

import cd.wayupdev.repstudiant.data.repository.EtudiantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEtudiantViewModel @Inject constructor(
    private val etudiantRepository: EtudiantRepository
){

}