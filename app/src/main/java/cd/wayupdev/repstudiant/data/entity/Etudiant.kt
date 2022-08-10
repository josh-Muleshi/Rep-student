package cd.wayupdev.repstudiant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Etudiant(
    @PrimaryKey(autoGenerate = true)
    val id_etudiant: Int,
    val nom_etudiant: String,
    val prenom_etudiant: String,
    val biographie: String,
    val date_naissance: String,
    val date_enregistrement: Date,
    val degre_etudiant: Int
)