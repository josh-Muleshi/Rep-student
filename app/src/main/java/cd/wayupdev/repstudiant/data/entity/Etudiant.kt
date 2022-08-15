package cd.wayupdev.repstudiant.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Etudiant(
    val nom_etudiant: String?,
    val prenom_etudiant: String?,
    val biographie: String?,
    val date_naissance: String?,
    val date_enregistrement: String?,
    val promotion_etudiant: String?,
    var degre_etudiant: Int?

){
    @PrimaryKey(autoGenerate = true)
    var id_etudiant: Int = 0
}