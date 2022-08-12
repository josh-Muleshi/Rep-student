package cd.wayupdev.repstudiant.data.dao

import androidx.room.*
import cd.wayupdev.repstudiant.data.entity.Degre
import cd.wayupdev.repstudiant.data.entity.DegreFiliere
import cd.wayupdev.repstudiant.data.entity.EtudiantDegre
import kotlinx.coroutines.flow.Flow

@Dao
interface DegreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(degre: Degre)

    @Query("SELECT * FROM Degre ORDER BY id_degre ASC")
    fun findAll(): Flow<List<Degre>>

    @Transaction
    @Query("SELECT * FROM Degre")
    fun findDegreAndEtudiant() : Flow<List<EtudiantDegre>>
}