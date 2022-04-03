package codejam2022


class Question1{
    companion object{
        private val input = getIoInput().map {
            val value = it.split(' ')
            Pair(value[0].toInt(), value[1].toInt())
        }

        fun getIoInput(): List<String> {
            val numberOfInput = readln().toInt()
            val result = mutableListOf<String>()
            for (x in 1..numberOfInput) {
                result.add(readln())
            }
            return result
        }

        fun solution() {
            input.forEachIndexed { index, value ->
                printPunchCards(value.first, value.second, index + 1)
            }
        }

        fun printPunchCards(rows: Int, column: Int, index: Int) {
            println("Case #$index:")
            for (x in 0 until rows) {
                val start = if (x == 0) 1 else 2
                for (k in start..3) {
                    for (y in 0 until column) {
                        if (k == 1) {
                            if (x == 0 && y == 0) {
                                print("..")
                            } else {
                                if (y == column - 1) {
                                    print("+-+")
                                } else {
                                    print("+-")
                                }
                            }
                        } else if (k == 2) {
                            if (x == 0 && y == 0) {
                                print("..")
                            } else {
                                if (y == column - 1) {
                                    print("|.|")
                                } else {
                                    print("|.")
                                }
                            }
                        } else {
                            if (y == column - 1) {
                                print("+-+")
                            } else {
                                print("+-")
                            }
                        }
                    }
                    if (x != rows - 1 || k != 3 || index != input.lastIndex + 1) {
                        println()
                    }
                }
            }
        }
    }

}

//..+-+-+-+
//..|.|.|.|
//+-+-+-+-+
//|.|.|.|.|
//+-+-+-+-+
//|.|.|.|.|
//+-+-+-+-+


//Case #1:
//..+-+-+-+
//..|.|.|.|
//+-+-+-+-+
//|.|.|.|.|
//+-+-+-+-+
//|.|.|.|.|
//+-+-+-+-+
//Case #2:
//..+-+
//..|.|
//+-+-+
//|.|.|
//+-+-+
//Case #3:
//..+-+-+
//..|.|.|
//+-+-+-+
//|.|.|.|
//+-+-+-+
