package cd.wayupdev.repstudiant.data.dao

import androidx.room.*
import cd.wayupdev.repstudiant.data.entity.DegreFiliere
import cd.wayupdev.repstudiant.data.entity.Filiere
import kotlinx.coroutines.flow.Flow

@Dao
interface FiliereDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(filiere: Filiere)

    @Query("SELECT * FROM Filiere ORDER BY id_filiere ASC")
    fun findAll(): Flow<List<Filiere>>

    @Transaction
    @Query("SELECT * FROM Filiere")
    fun findFiliereAndDegre() : Flow<List<DegreFiliere>>
}