package cd.wayupdev.repstudiant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Filiere (
    val nom_filiere: String?,
    val Description: String?,
    val date_creation: String?
){
    @PrimaryKey(autoGenerate = true)
    var id_filiere: Int = 0
}

