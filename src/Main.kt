object Main {
    /**
     * The main function is the entry point of the program.
     */
    @JvmStatic
    fun main(args: Array<String>) {
        run()
    }

    /**
     * This function handles the running of the program.
     */
    private fun run() {
        var input: String
        var finished = false
        var timeCount = Time(0, 0)
        while (!finished) {
            input = readln()
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

    /**
     * This function adds the time difference between the two values in the input String to the timeCount.
     */
    private fun processTimeInput(input: String, timeCount: Time) {
        try {
            val times = input.split(" ")
            checkIfListSizeEqualsTwo(times) // Error-handling
            val firstTimeString = times[0].split(":")
            val secondTimeString = times[1].split(":")
            checkIfListSizeEqualsTwo(firstTimeString) // Error-handling
            checkIfListSizeEqualsTwo(secondTimeString) // Error-handling
            val firstTime = Time(Time.hourStringToInt(firstTimeString[0]), Time.minuteStringToInt(firstTimeString[1]))
            val secondTime = Time(Time.hourStringToInt(secondTimeString[0]), Time.minuteStringToInt(secondTimeString[1]))
            timeCount.addToTime(Time.subtractTimes(firstTime, secondTime))
            println(timeCount)
        } catch (exception: NumberFormatException) {
            println("Wrong format. Please try again.")
        } catch (exception: TimeOutOfBoundsException) {
            println("Wrong format!" + exception.message)
        } catch (exception: Exception) {
            println(exception.message)
        }
    }

    /**
     * This little utility function checks, whether a list has exactly two inputs.
     * If this is not the case, an exception is thrown.
     */
    private fun checkIfListSizeEqualsTwo(list: List<String>) {
        if (list.size != 2) {
            throw Exception("Wrong number of parameters! 2 Parameters are expected.")
        }
    }
}