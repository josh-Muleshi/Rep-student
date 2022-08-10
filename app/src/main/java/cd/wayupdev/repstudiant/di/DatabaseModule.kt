package cd.wayupdev.repstudiant.di

import android.content.Context
import androidx.room.Room
import cd.wayupdev.repstudiant.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "rep_student"
    ).build()

    @Singleton
    @Provides
    fun provideEtudiantDao(database: AppDatabase) = database.etudiantDao()

    @Singleton
    @Provides
    fun provideFiliereDao(database: AppDatabase) = database.filiereDao()

    @Singleton
    @Provides
    fun provideDegreDao(database: AppDatabase) = database.degreDao()

}