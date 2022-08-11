package cd.wayupdev.repstudiant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cd.wayupdev.repstudiant.data.entity.Filiere
import kotlinx.coroutines.flow.Flow

@Dao
interface FiliereDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(filiere: Filiere)

    @Query("SELECT * FROM Filiere ORDER BY id_filiere ASC")
    fun findAll(): Flow<List<Filiere>>
}