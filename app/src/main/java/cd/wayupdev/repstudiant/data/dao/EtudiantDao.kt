package cd.wayupdev.repstudiant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cd.wayupdev.repstudiant.data.entity.Etudiant
import kotlinx.coroutines.flow.Flow

@Dao
interface EtudiantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(etudiant: Etudiant)

    @Query("SELECT * FROM Etudiant ORDER BY id_etudiant ASC")
    fun findAll(): Flow<List<Etudiant>>

    @Query("SELECT * FROM Etudiant WHERE id_etudiant =:etudiantID")
    fun findByid(etudiantID : Int): Flow<Etudiant>

    @Query("SELECT * FROM Etudiant WHERE nom_etudiant LIKE :searchQuery OR prenom_etudiant LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Etudiant>>
}