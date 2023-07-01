import java.util.*

object Main {
    private val scanner = Scanner(System.`in`)
    @JvmStatic
    fun main(args: Array<String>) {
        runProgram()
    }

    private fun runProgram() {
        var input: String
        var finished = false
        var timeCount = Time(0, 0)
        while (!finished) {
            input = scanner.nextLine()
            when (input) {
                "--stop" -> finished = true
                "--reset" -> timeCount = Time(0, 0)
                "--show" -> println(timeCount)
                "--help" -> {
                    println("This program has the following commands.")
                    println("--help: Show all commands.")
                    println("--stop: Stop the program.")
                    println("--reset: Reset the counter to 0.")
                    println("--show: Show the current value.")
                    println("Inputs for this program have the following format.")
                    println("<Hour of the first time>:<Minute of the first time> <Hour of the second time>:<Minute of the second time>")
                    println("The times follow the 24-hour format. Here are some examples.")
                    println("00:00 11:45")
                    println("22:50 02:21")
                    println("The program cannot count single durations longer than 24 hours.")
                }

                else -> processTimeInput(input, timeCount)
            }
        }
    }

    private fun processTimeInput(input: String, timeCount: Time) {
        try {
            val times = input.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val firstTimeString = times[0].split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val secondTimeString = times[1].split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val firstTime = Time(firstTimeString[0].toInt(), firstTimeString[1].toInt())
            val secondTime = Time(secondTimeString[0].toInt(), secondTimeString[1].toInt())
            timeCount.addToTime(Time.Companion.subtractTimes(firstTime, secondTime))
            println(timeCount)
        } catch (ignored: NumberFormatException) {
            println("Wrong format. Please try again.")
        } catch (ignored: ArrayIndexOutOfBoundsException) {
            println("Wrong format. Please try again.")
        }
    }
}