package cd.wayupdev.repstudiant.data

import androidx.room.Database
import androidx.room.RoomDatabase
import cd.wayupdev.repstudiant.data.dao.DegreDao
import cd.wayupdev.repstudiant.data.dao.EtudiantDao
import cd.wayupdev.repstudiant.data.dao.FiliereDao
import cd.wayupdev.repstudiant.data.entity.Degre
import cd.wayupdev.repstudiant.data.entity.Etudiant
import cd.wayupdev.repstudiant.data.entity.Filiere

@Database(
    entities = [Etudiant::class, Filiere::class, Degre::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun etudiantDao(): EtudiantDao
    abstract fun filiereDao(): FiliereDao
    abstract fun degreDao(): DegreDao
}