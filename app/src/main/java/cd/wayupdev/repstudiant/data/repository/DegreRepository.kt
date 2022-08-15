package cd.wayupdev.repstudiant.data.repository

import androidx.room.Query
import cd.wayupdev.repstudiant.data.dao.DegreDao
import cd.wayupdev.repstudiant.data.entity.Degre
import cd.wayupdev.repstudiant.data.entity.Etudiant
import cd.wayupdev.repstudiant.data.entity.EtudiantDegre
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DegreRepository @Inject constructor(
    private val degreDao: DegreDao
) {
    suspend fun insertData(degre: Degre){
        degreDao.insertData(degre)
    }

    fun findAll(): Flow<List<Degre>>{
        return degreDao.findAll()
    }

    fun searchOne(searchQuery: String): Flow<Degre>{
        return degreDao.searchOne(searchQuery)
    }

    fun findDegreAndEtudiant() : Flow<List<EtudiantDegre>>{
        return degreDao.findDegreAndEtudiant()
    }
}