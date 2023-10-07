package com.example.todoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoItem::class], version = 4)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao

    companion object {
        private var dbINSTANCE: ToDoDatabase? = null

        fun getAppDB(context: Context): ToDoDatabase {
            if (dbINSTANCE == null) {
                synchronized(ToDoDatabase::class) {
                    dbINSTANCE = Room.databaseBuilder<ToDoDatabase>(
                        context.applicationContext,
                        ToDoDatabase::class.java,
                        "todo_database"
                    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                    //If you don’t want to provide migrations and you specifically want your database to be cleared when you upgrade the version, call fallbackToDestructiveMigration in the database builder.
                }
            }
            return dbINSTANCE!!
        }
    }
}