package com.javiersc.mokoki.test.internal

public actual val String?.lineNumberForTest: Int
    get() = this?.substringAfter(".kt:")?.substringBefore(")")?.toIntOrNull() ?: 1
