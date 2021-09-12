@file:Suppress("TooManyFunctions")

package com.javiersc.mokoki.serialization.extensions

import com.javiersc.mokoki.serialization.MokokiSerialization

public fun logJsonV(tag: String, json: String): Unit = MokokiSerialization.jsonV(tag, json)

public fun logJsonV(json: String): Unit = MokokiSerialization.jsonV(json)

public fun logJsonD(tag: String, json: String): Unit = MokokiSerialization.jsonD(tag, json)

public fun logJsonD(json: String): Unit = MokokiSerialization.jsonD(json)

public fun logJsonI(tag: String, json: String): Unit = MokokiSerialization.jsonI(tag, json)

public fun logJsonI(json: String): Unit = MokokiSerialization.jsonI(json)

public fun logJsonW(tag: String, json: String): Unit = MokokiSerialization.jsonW(tag, json)

public fun logJsonW(json: String): Unit = MokokiSerialization.jsonW(json)

public fun logJsonE(tag: String, json: String): Unit = MokokiSerialization.jsonE(tag, json)

public fun logJsonE(json: String): Unit = MokokiSerialization.jsonE(json)
