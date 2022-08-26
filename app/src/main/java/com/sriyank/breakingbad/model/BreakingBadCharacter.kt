package com.sriyank.breakingbad.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class BreakingBadCharacter(

    @PrimaryKey
    val id: Int,
    val name:String,
    val birthday:String,
    val occupation: Array<String>,
    val img:String?,
    val status:String,
    val nickname:String

) {
}