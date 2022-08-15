package cd.wayupdev.repstudiant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Degre (
    val class_degre: String?,
    val filiere_degre: String?
){
    @PrimaryKey(autoGenerate = true)
    var id_degre: Int = 0
}

