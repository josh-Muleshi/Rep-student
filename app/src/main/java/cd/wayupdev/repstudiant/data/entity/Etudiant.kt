package cd.wayupdev.repstudiant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Etudiant(
    val nom_etudiant: String? = null,
    val prenom_etudiant: String? = null,
    val biographie: String? = null,
    val date_naissance: String? = null,
    val date_enregistrement: String? = null,
    val degre_etudiant: String?
){
    @PrimaryKey(autoGenerate = true)
    var id_etudiant: Int = 0
}