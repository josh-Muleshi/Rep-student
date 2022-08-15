package cd.wayupdev.repstudiant.data.dao

import androidx.room.*
import cd.wayupdev.repstudiant.data.entity.DegreFiliere
import cd.wayupdev.repstudiant.data.entity.Etudiant
import cd.wayupdev.repstudiant.data.entity.Filiere
import kotlinx.coroutines.flow.Flow

@Dao
interface FiliereDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(filiere: Filiere)

    @Query("SELECT * FROM Filiere ORDER BY id_filiere ASC")
    fun findAll(): Flow<List<Filiere>>

    @Query("SELECT * FROM Filiere WHERE nom_filiere LIKE :searchQuery")
    fun searchOne(searchQuery: String): Flow<Filiere>

    @Transaction
    @Query("SELECT * FROM Filiere")
    fun findFiliereAndDegre() : Flow<List<DegreFiliere>>
}