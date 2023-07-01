/**
 * This class manages time.
 */
class Time(private var hour: Int, private var minute: Int) {
    /**
     * This function adds the given time to the time of the object.
     */
    fun addToTime(time: Time) {
        hour += time.hour
        minute += time.minute
        if (minute >= 60) {
            minute -= 60
            hour++
        }
    }

    /**
     * This function converts the time object to a String with the time.
     */
    override fun toString(): String {
        return String.format("Stunden: %d, Minuten: %d", hour, minute)
    }

    companion object {
        /**
         * This function subtracts two times from another and returns the difference.
         */
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

        /**
         * This function converts a String to int while checking whether the int is between 0 and 24 (both inclusive).
         * If the int is outside those values, an exception is thrown.
         */
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

        /**
         * This function converts a String to int while checking whether the int is between 0 and 60 (both inclusive).
         * If the int is outside those values, an exception is thrown.
         */
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
