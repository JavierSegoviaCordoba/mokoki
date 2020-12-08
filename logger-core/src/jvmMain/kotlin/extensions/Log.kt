package com.javiersc.logger.core.extensions

import com.javiersc.logger.core.Logger

public actual fun logV(tag: String, message: Any): Unit = Logger.v(tag, message)
public actual fun logV(message: Any): Unit = Logger.v(null, message)

public actual fun logD(tag: String, message: Any): Unit = Logger.d(tag, message)
public actual fun logD(message: Any): Unit = Logger.d(null, message)

public actual fun logI(tag: String, message: Any): Unit = Logger.i(tag, message)
public actual fun logI(message: Any): Unit = Logger.i(null, message)

public actual fun logW(tag: String, message: Any): Unit = Logger.w(tag, message)
public actual fun logW(message: Any): Unit = Logger.w(null, message)

public actual fun logE(tag: String, message: Any): Unit = Logger.e(tag, message)
public actual fun logE(message: Any): Unit = Logger.e(null, message)
