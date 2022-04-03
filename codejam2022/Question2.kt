package codejam2022

import kotlin.math.min

class Question2 {
    companion object {
        val input = getIoInput().map {
            val value = it.split(' ')
            Printer(
                mutableSetOf(
                    Colour.Cyan(value[0].toInt()),
                    Colour.Magenta(value[1].toInt()),
                    Colour.Yellow(value[2].toInt()),
                    Colour.Black(value[3].toInt())
                )
            )
        }.chunked(3)

        fun getIoInput(): List<String> {
            val numberOfInput = readln().toInt()
            val result = mutableListOf<String>()
            for (x in 1..(numberOfInput * numberOfInput)) {
                result.add(readln())
            }
            return result
        }

        fun solution2() {
            input.forEachIndexed { index, list ->
                    println("Case #${index+1}: ${getInkValues(list)}")
            }

        }

        fun getInkValues(printers: List<Printer>): String {
            var m = 0
            var c = 0
            var y = 0
            var b = 0
            val maxValue = 1000_000
            var valueLeft = maxValue
            for (x in 1..4) {
                val lowestInk1 = printers[0].colours.minByOrNull {
                    it.value
                }!!
                val lowestInk2 = printers[1].colours.minByOrNull {
                    it.value
                }!!
                val lowestInk3 = printers[2].colours.minByOrNull {
                    it.value
                }!!

                val finalLowest = listOf(lowestInk1, lowestInk2, lowestInk3).minByOrNull {
                    it.value
                }!!
                val valueToTake = min(finalLowest.value, valueLeft)
                valueLeft -= valueToTake

                when (finalLowest) {
                    is Colour.Black -> b = valueToTake
                    is Colour.Cyan -> c = valueToTake
                    is Colour.Magenta -> m = valueToTake
                    is Colour.Yellow -> y = valueToTake
                }

                printers.forEach { printer ->
                    printer.colours.removeIf { color ->
                        color.javaClass == finalLowest.javaClass
                    }
                }

            }
            return if (valueLeft > 0) {
                ("IMPOSSIBLE")
            } else {
                ("$c $m $y $b")
            }
        }
    }
}

data class Printer(val colours: MutableSet<Colour> = mutableSetOf())

sealed class Colour(open val value: Int) {
    data class Cyan(override val value: Int) : Colour(value)
    data class Magenta(override val value: Int) : Colour(value)
    data class Yellow(override val value: Int) : Colour(value)
    data class Black(override val value: Int) : Colour(value)
}
