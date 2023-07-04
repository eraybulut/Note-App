package com.eraybulut.noteapp.di

import android.content.Context
import androidx.room.Room
import com.eraybulut.noteapp.data.local.NoteDao
import com.eraybulut.noteapp.data.local.NoteDatabase
import com.eraybulut.noteapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Code With 💚
 * Created by Eray BULUT on 19.06.2023
 * eraybulutlar@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
object RoomDBModule {
    @Provides
    @Singleton
    fun provideNoteRoomDB(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            NoteDatabase::class.java,
            Constants.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideNoteDAO(recipeRoomDB: NoteDatabase): NoteDao {
        return recipeRoomDB.noteDao()
    }
}