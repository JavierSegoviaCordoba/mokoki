@file:Suppress("TooManyFunctions")

package com.javiersc.mokoki.extensions

import com.javiersc.mokoki.Mokoki

public fun logV(tag: String, message: String): Unit = Mokoki.v(tag, message)

public fun logV(tag: String, throwable: Throwable): Unit = Mokoki.v(tag, throwable)

public fun logV(tag: String, any: Any): Unit = Mokoki.v(tag, "$any")

public fun logV(message: String): Unit = Mokoki.v(message)

public fun logV(throwable: Throwable): Unit = Mokoki.v(throwable)

public fun logV(any: Any): Unit = Mokoki.v("$any")

public fun logD(tag: String, message: String): Unit = Mokoki.d(tag, message)

public fun logD(tag: String, throwable: Throwable): Unit = Mokoki.d(tag, throwable)

public fun logD(tag: String, any: Any): Unit = Mokoki.d(tag, "$any")

public fun logD(message: String): Unit = Mokoki.d(message)

public fun logD(throwable: Throwable): Unit = Mokoki.d(throwable)

public fun logD(any: Any): Unit = Mokoki.d("$any")

public fun logI(tag: String, message: String): Unit = Mokoki.i(tag, message)

public fun logI(tag: String, throwable: Throwable): Unit = Mokoki.i(tag, throwable)

public fun logI(tag: String, any: Any): Unit = Mokoki.i(tag, "$any")

public fun logI(message: String): Unit = Mokoki.i(message)

public fun logI(throwable: Throwable): Unit = Mokoki.i(throwable)

public fun logI(any: Any): Unit = Mokoki.i("$any")

public fun logW(tag: String, message: String): Unit = Mokoki.w(tag, message)

public fun logW(tag: String, throwable: Throwable): Unit = Mokoki.w(tag, throwable)

public fun logW(tag: String, any: Any): Unit = Mokoki.w(tag, "$any")

public fun logW(message: String): Unit = Mokoki.w(message)

public fun logW(throwable: Throwable): Unit = Mokoki.w(throwable)

public fun logW(any: Any): Unit = Mokoki.w("$any")

public fun logE(tag: String, message: String): Unit = Mokoki.e(tag, message)

public fun logE(tag: String, throwable: Throwable): Unit = Mokoki.e(tag, throwable)

public fun logE(tag: String, any: Any): Unit = Mokoki.e(tag, "$any")

public fun logE(message: String): Unit = Mokoki.e(message)

public fun logE(throwable: Throwable): Unit = Mokoki.e(throwable)

public fun logE(any: Any): Unit = Mokoki.e("$any")
