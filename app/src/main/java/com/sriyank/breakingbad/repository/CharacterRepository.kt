package com.sriyank.breakingbad.repository

import androidx.lifecycle.LiveData
import com.sriyank.breakingbad.dp.CharacterDao
import com.sriyank.breakingbad.model.BreakingBadCharacter
import com.sriyank.breakingbad.service.BreakingBadNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository(private val characterDao: CharacterDao) {

    var characters: LiveData<List<BreakingBadCharacter>> = characterDao.findAllCharacters()

    suspend fun refreshCharacters(){
        withContext(Dispatchers.IO){
            val characters = BreakingBadNetwork.serviceApi.getCharacters()

            characterDao.insertAllCharacter(characters)
        }
    }
}