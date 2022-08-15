package cd.wayupdev.repstudiant.data.repository

import cd.wayupdev.repstudiant.data.dao.FiliereDao
import cd.wayupdev.repstudiant.data.entity.Degre
import cd.wayupdev.repstudiant.data.entity.DegreFiliere
import cd.wayupdev.repstudiant.data.entity.Filiere
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FiliereRepository @Inject constructor(
    private val filiereDao: FiliereDao
) {
    suspend fun insertData(filiere: Filiere){
        filiereDao.insertData(filiere)
    }

    fun findAll(): Flow<List<Filiere>>{
        return filiereDao.findAll()
    }

    fun searchOne(searchQuery: String): Flow<Filiere>{
        return filiereDao.searchOne(searchQuery)
    }

    fun findFiliereAndDegre() : Flow<List<DegreFiliere>>{
        return filiereDao.findFiliereAndDegre()
    }
}