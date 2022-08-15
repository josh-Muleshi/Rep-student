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

    @Query("SELECT * FROM Etudiant ORDER BY CASE WHEN :isAsc = 1 THEN id_etudiant END ASC," +
            "CASE WHEN :isAsc = 0 THEN id_etudiant END DESC")
    fun findAll(isAsc: Boolean): Flow<List<Etudiant>>

    @Query("SELECT * FROM Etudiant WHERE id_etudiant =:etudiantID")
    fun findByid(etudiantID : Int): Flow<Etudiant>

    @Query("SELECT count(*) FROM Etudiant")
    fun count(): Flow<Int>

    @Query("SELECT * FROM Etudiant WHERE nom_etudiant LIKE :searchQuery OR prenom_etudiant LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Etudiant>>
}