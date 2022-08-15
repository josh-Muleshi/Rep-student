package cd.wayupdev.repstudiant.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DegreFiliere(
    @Embedded val filiere: Filiere,
    @Relation(
        parentColumn = "nom_filiere",
        entityColumn = "filiere_degre"
    )
    val degre: Degre
)
