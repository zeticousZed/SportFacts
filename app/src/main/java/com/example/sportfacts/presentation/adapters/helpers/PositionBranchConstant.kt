package com.example.sportfacts.presentation.adapters.helpers

import com.example.sportfacts.data.constant.CategorySport

object PositionBranchConstant {
    fun mapPositionToCategory(position: Int): CategorySport {
        return when (position) {
            0 -> CategorySport.BASEBALL
            1 -> CategorySport.FOOTBALL
            2 -> CategorySport.BASKETBALL
            3 -> CategorySport.CHESS
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}