package cd.wayupdev.repstudiant.data.repository

import cd.wayupdev.repstudiant.data.dao.EtudiantDao
import cd.wayupdev.repstudiant.data.entity.Etudiant
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EtudiantRepository @Inject constructor(
    private val etudiantDao: EtudiantDao
) {
    suspend fun insertData(etudiant: Etudiant){
        etudiantDao.insertData(etudiant)
    }

    fun findAll(): Flow<List<Etudiant>>{
        return etudiantDao.findAll()
    }

    fun findByid(etudiantID : Int): Flow<Etudiant>{
        return etudiantDao.findByid(etudiantID)
    }

    fun searchDatabase(searchQuery: String): Flow<List<Etudiant>>{
        return etudiantDao.searchDatabase(searchQuery)
    }
}