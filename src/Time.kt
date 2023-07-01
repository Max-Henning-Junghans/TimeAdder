class Time(private var hour: Int, private var minute: Int) {
    fun addToTime(time: Time) {
        hour += time.hour
        minute += time.minute
        if (minute >= 60) {
            minute -= 60
            hour++
        }
    }

    override fun toString(): String {
        return String.format("Stunden: %d, Minuten: %d", hour, minute)
    }

    companion object {
        fun subtractTimes(firstTime: Time, secondTime: Time): Time {
            var newHours = secondTime.hour - firstTime.hour
            var newMinutes = secondTime.minute - firstTime.minute
            if (newHours < 0) {
                newHours += 24
            }
            if (newMinutes < 0) {
                newMinutes += 60
                newHours--
            }
            return Time(newHours, newMinutes)
        }

        fun hourStringToInt(hourInput: String): Int {
            val hour = hourInput.toInt()
            if (hour < 0) {
                throw TimeOutOfBoundsException("The hour has to be greater or equal to 0")
            }
            if (hour > 24) {
                throw TimeOutOfBoundsException("The hour has to be smaller or equal to 24")
            }
            return hour
        }

        fun minuteStringToInt(minuteInput: String): Int {
            val minute = minuteInput.toInt()
            if (minute < 0) {
                throw TimeOutOfBoundsException("The hour has to be greater or equal to 0")
            }
            if (minute > 60) {
                throw TimeOutOfBoundsException("The hour has to be smaller or equal to 60")
            }
            return minute
        }
    }
}
