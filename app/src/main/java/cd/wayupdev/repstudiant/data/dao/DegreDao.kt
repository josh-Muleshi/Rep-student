package cd.wayupdev.repstudiant.data.dao

import androidx.room.*
import cd.wayupdev.repstudiant.data.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DegreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(degre: Degre)

    @Query("SELECT * FROM Degre ORDER BY id_degre ASC")
    fun findAll(): Flow<List<Degre>>

    @Query("SELECT * FROM Degre WHERE class_degre LIKE :searchQuery")
    fun searchOne(searchQuery: String): Flow<Degre>

    @Transaction
    @Query("SELECT * FROM Degre")
    fun findDegreAndEtudiant() : Flow<List<EtudiantDegre>>
}