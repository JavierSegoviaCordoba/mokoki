@file:Suppress("TopLevelPropertyNaming", "FunctionName")

package com.javiersc.mokoki

public fun LoggerSeparator(useCompatibleMode: Boolean = false): String =
    if (useCompatibleMode) "|" else "├"
