package cd.wayupdev.repstudiant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Filiere (
    @PrimaryKey(autoGenerate = true)
    val id_filiere: Int,
    val nom_filiere: String,
    val Description: String,
    val date_creation: Date
)

