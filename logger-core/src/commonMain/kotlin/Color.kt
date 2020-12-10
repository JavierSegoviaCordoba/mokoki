package com.javiersc.logger.core

public enum class LoggerForegroundColor(public val value: String) {
    Reset("\u001B[0m"),
    Black("\u001B[30m"),
    Red("\u001B[31m"),
    Green("\u001B[32m"),
    Yellow("\u001B[33m"),
    Blue("\u001B[34m"),
    Purple("\u001B[35m"),
    Cyan("\u001B[36m"),
    White("\u001B[37m"),

    BrightBlack("\u001B[90m"),
    BrightRed("\u001B[91m"),
    BrightGreen("\u001B[92m"),
    BrightYellow("\u001B[93m"),
    BrightBlue("\u001B[94m"),
    BrightPurple("\u001B[95m"),
    BrightCyan("\u001B[96m"),
    BrightWhite("\u001B[97m"),
}

public enum class LoggerBackgroundColor(public val value: String) {
    Reset("\u001B[0m"),
    Black("\u001B[40m"),
    Red("\u001B[41m"),
    Green("\u001B[42m"),
    Yellow("\u001b[43m"),
    Blue("\u001B[44m"),
    Purple("\u001B[45m"),
    Cyan("\u001B[46m"),
    Gray("\u001B[47m"),
}
