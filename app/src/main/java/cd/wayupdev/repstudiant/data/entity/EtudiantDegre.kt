package cd.wayupdev.repstudiant.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class EtudiantDegre (
    @Embedded val degre: Degre,
    @Relation(
        parentColumn = "id_degre",
        entityColumn = "degre_etudiant"
    )
    val etudiant: Etudiant
)