package com.example.labaratory_3_1.data

import android.provider.BaseColumns



class StudentsContract {
    class StudentEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "student"

            const val ID = BaseColumns._ID
            const val COLUMN_NAME = "fio"
            const val COLUMN_ADDED = "added"
        }
    }
}