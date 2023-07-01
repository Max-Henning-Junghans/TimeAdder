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
                newHours = 24 + newHours
            }
            if (newMinutes < 0) {
                newMinutes = 60 + newMinutes
                newHours--
            }
            return Time(newHours, newMinutes)
        }
    }
}
