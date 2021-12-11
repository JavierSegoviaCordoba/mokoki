@file:Suppress("TopLevelPropertyNaming", "FunctionName")

package com.javiersc.mokoki

public fun LoggerSeparator(enableCompatibleMode: Boolean = false): String =
    if (enableCompatibleMode) "|" else "├"
