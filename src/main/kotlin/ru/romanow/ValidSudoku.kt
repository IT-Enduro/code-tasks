package ru.romanow

import java.util.BitSet

/**
 * Требуется проверить корректность заполнения доски `9x9` для судоку.
 * Проверки подлежат только заполненные ячейки согласно следующим правилам:
 * * Каждая строка должна содержать цифры от 1 до 9 без повторений.
 * * Каждый столбец должен содержать цифры 1–9 без повторений.
 * * Каждый из девяти подполей сетки размером `3х3` должен содержать цифры от 1 до 9 без повторений.
 *
 * Примечание:
 * * Доска может быть допустимой, но не обязательно решаемой.
 * * Требуется проверять только заполненные ячейки.
 *
 * [https://leetcode.com/problems/valid-sudoku/](https://leetcode.com/problems/valid-sudoku/)
 */
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        if (board.size != GRID_SIZE) {
            return false
        }
        for (i in 0 until GRID_SIZE) {
            if (board[i].size != GRID_SIZE) {
                return false
            }

            val columnDigits = BitSet()
            val rowDigits = BitSet()
            val subgridDigits = BitSet()
            for (j in 0 until GRID_SIZE) {
                val row = (3 * (i % 3)) + j / 3 // 0, 0, 0, 1, 1, 1, 2, 2, 2
                val col = (3 * (i / 3)) + j % 3 // 0, 1, 2, 0, 1, 2, 0, 1, 2

                if (!checkDigit(board[i][j], rowDigits) ||
                    !checkDigit(board[j][i], columnDigits) ||
                    !checkDigit(board[row][col], subgridDigits)
                ) {
                    return false
                }
            }
        }
        return true
    }

    private fun checkDigit(chr: Char, occurrences: BitSet): Boolean {
        var valid = false
        if (chr != '.') {
            if (chr in '1'..'9') {
                if (!occurrences[chr.code]) {
                    occurrences.set(chr.code)
                    valid = true
                }
            }
        } else {
            valid = true
        }
        return valid
    }

    companion object {
        private const val GRID_SIZE = 9
    }
}
