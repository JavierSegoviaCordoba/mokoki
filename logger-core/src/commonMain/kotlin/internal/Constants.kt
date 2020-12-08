package com.javiersc.logger.core.internal

internal enum class Color(val value: String) {
    Reset("\u001B[0m"),
    Black("\u001B[30m"),
    Red("\u001B[31m"),
    Green("\u001B[32m"),
    Yellow("\u001B[33m"),
    Blue("\u001B[34m"),
    Purple("\u001B[35m"),
    Cyan("\u001B[36m"),
    White("\u001B[37m"),

    BlackBG("\u001B[40m"),
    RedBG("\u001B[41m"),
    GreenBG("\u001B[42m"),
    YellowBG("\u001b[43m"),
    BlueBG("\u001B[44m"),
    PurpleBG("\u001B[45m"),
    CyanBG("\u001B[46m"),
    GrayBG("\u001B[47m"),

    BrightBlack("\u001B[90m"),
    BrightRed("\u001B[91m"),
    BrightGreen("\u001B[92m"),
    BrightYellow("\u001B[93m"),
    BrightBlue("\u001B[94m"),
    BrightPurple("\u001B[95m"),
    BrightCyan("\u001B[96m"),
    BrightWhite("\u001B[97m"),
}

internal enum class Level {
    Verbose,
    Debug,
    Info,
    Warning,
    Error,
}
