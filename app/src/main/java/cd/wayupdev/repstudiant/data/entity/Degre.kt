package cd.wayupdev.repstudiant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Degre (
    @PrimaryKey(autoGenerate = true)
    val id_degre: Int,
    val class_degre: String,
    val filiere_degre: Int
)

