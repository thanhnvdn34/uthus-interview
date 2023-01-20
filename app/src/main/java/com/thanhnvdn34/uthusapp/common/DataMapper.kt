package com.thanhnvdn34.uthusapp.common

import com.thanhnvdn34.uthusapp.data.model.Beer

object DataMapper {

    fun convertList(currentList: List<Beer>, localList: List<Beer>): List<Beer> {
        when (localList.isNotEmpty()) {
            true -> {
                localList.forEach { localItem ->
                    currentList.find {
                        it.id == localItem.id
                    }?.description = localItem.description
                }
            }
            else -> return emptyList()
        }
        return currentList
    }
}