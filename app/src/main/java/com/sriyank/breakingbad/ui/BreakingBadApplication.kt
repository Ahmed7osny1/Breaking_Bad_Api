package com.sriyank.breakingbad.ui

import android.app.Application
import com.sriyank.breakingbad.dp.CharacterDatabase
import com.sriyank.breakingbad.repository.CharacterRepository

class BreakingBadApplication : Application() {

    val database by lazy {
        CharacterDatabase.createDatabase(this)
    }

    val characterRepository by lazy {
        CharacterRepository(database.createCharacterDao())
    }

}