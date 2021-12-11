@file:Suppress("EmptyDefaultConstructor")

package com.javiersc.mokoki

public expect class MokokiLogger constructor() {

    public var isEnabled: Boolean

    public var enableCompatibleMode: Boolean

    public fun v(tag: String, message: String)

    public fun d(tag: String, message: String)

    public fun i(tag: String, message: String)

    public fun w(tag: String, message: String)

    public fun e(tag: String, message: String)
}
