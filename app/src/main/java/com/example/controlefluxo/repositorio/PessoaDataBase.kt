@file:OptIn(InternalCoroutinesApi::class)

package com.example.controlefluxo.repositorio

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.controlefluxo.constants.DataBaseConstants
import com.example.controlefluxo.model.PessoaModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [PessoaModel::class], version = 1)
abstract class PessoaDataBase : RoomDatabase() {

    abstract fun pessoaDao(): PessoaDao
    companion object {
        private lateinit var INSTANCE: PessoaDataBase

        fun getDatabase(context: Context): PessoaDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(PessoaDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, PessoaDataBase::class.java, "pessoadb")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                TODO("Not yet implemented")
            }

        }
    }
}
