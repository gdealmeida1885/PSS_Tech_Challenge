package utils

enum class Timeouts(val waitTime: Long) {
    SMALL(5), MEDIUM(10), LONG(15)
}