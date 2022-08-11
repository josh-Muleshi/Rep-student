package cd.wayupdev.repstudiant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cd.wayupdev.repstudiant.data.entity.Degre
import kotlinx.coroutines.flow.Flow

@Dao
interface DegreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(degre: Degre)

    @Query("SELECT * FROM Degre ORDER BY id_degre ASC")
    fun findAll(): Flow<List<Degre>>
}