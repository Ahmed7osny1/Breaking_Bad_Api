package com.sriyank.breakingbad.dp
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sriyank.breakingbad.model.BreakingBadCharacter

@Dao
interface CharacterDao {

    @Query("select * from character")
    fun findAllCharacters(): LiveData<List<BreakingBadCharacter>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacter(characterList: List<BreakingBadCharacter>)

}