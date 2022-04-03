package codejam2022

class Question3 {
    companion object {
        val input = getIoInput().chunked(2).map {
            Input(it[0].toInt(), it[1].split(' ').map { value ->
                value.toInt()
            }.sorted())
        }

        fun getIoInput(): List<String> {
            val numberOfInput = readln().toInt()
            val result = mutableListOf<String>()
            for (x in 1..(numberOfInput * 2)) {
                result.add(readln())
            }
            return result
        }

        fun solution3() {
            input.forEachIndexed { index, value ->
                var counter = 0
                for (x in 1..value.numberOfDice) {
                    if(counter < value.dices[x-1]) {
                        counter++
                    }
                }
                println("Case #${index+1}: $counter")
            }
        }

    }
}

class Input(val numberOfDice: Int, val dices: List<Int>)