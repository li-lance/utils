package com.seraphim.utils

import io.github.aakira.napier.Napier
import kotlin.time.Clock

/**
 * 业务侧只依赖此 Logger，不直接依赖 Napier。
 */
object Logger {
    enum class Level { VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT }

    data class LogEvent(
        val level: Level,
        val tag: String?,
        val message: String,
        val throwable: Throwable? = null,
        val fields: Map<String, Any?> = emptyMap(),
        val timestamp: Long = Clock.System.now().toEpochMilliseconds()
    )

    interface Backend {
        fun log(event: LogEvent)
    }

    @PublishedApi
    internal var backend: Backend = NapierBackend()

    fun configureBackend(newBackend: Backend) { backend = newBackend }

    inline fun v(tag: String? = null, throwable: Throwable? = null, fields: Map<String, Any?> = emptyMap(), msg: () -> String) =
        log(Level.VERBOSE, tag, throwable, fields, msg)
    inline fun d(tag: String? = null, throwable: Throwable? = null, fields: Map<String, Any?> = emptyMap(), msg: () -> String) =
        log(Level.DEBUG, tag, throwable, fields, msg)
    inline fun i(tag: String? = null, throwable: Throwable? = null, fields: Map<String, Any?> = emptyMap(), msg: () -> String) =
        log(Level.INFO, tag, throwable, fields, msg)
    inline fun w(tag: String? = null, throwable: Throwable? = null, fields: Map<String, Any?> = emptyMap(), msg: () -> String) =
        log(Level.WARN, tag, throwable, fields, msg)
    inline fun e(tag: String? = null, throwable: Throwable? = null, fields: Map<String, Any?> = emptyMap(), msg: () -> String) =
        log(Level.ERROR, tag, throwable, fields, msg)
    inline fun wtf(tag: String? = null, throwable: Throwable? = null, fields: Map<String, Any?> = emptyMap(), msg: () -> String) =
        log(Level.ASSERT, tag, throwable, fields, msg)

    inline fun <reified T> dOf(vararg kv: Pair<String, Any?>, noinline msg: () -> String) =
        d(tag = T::class.simpleName, fields = mapOf(*kv), msg = msg)

    @PublishedApi
    internal inline fun log(
        level: Level,
        tag: String?,
        throwable: Throwable?,
        fields: Map<String, Any?>,
        msg: () -> String
    ) {
        val base = msg() // 单次求值
        val event = LogEvent(level, tag, buildMessage(base, fields), throwable, fields)
        backend.log(event)
    }

    @PublishedApi
    internal fun buildMessage(base: String, fields: Map<String, Any?>): String {
        if (fields.isEmpty()) return base
        val extras = fields.entries.joinToString(prefix = "{", postfix = "}") { (k, v) -> "$k=" + (v ?: "null") }
        return "$base $extras"
    }
}

/**
 * 默认 Backend 使用 Napier，实现隐藏。
 */
internal class NapierBackend : Logger.Backend {
    override fun log(event: Logger.LogEvent) {
        val t = event.throwable
        when (event.level) {
            Logger.Level.VERBOSE -> Napier.v(event.message, t, event.tag)
            Logger.Level.DEBUG -> Napier.d(event.message, t, event.tag)
            Logger.Level.INFO -> Napier.i(event.message, t, event.tag)
            Logger.Level.WARN -> Napier.w(event.message, t, event.tag)
            Logger.Level.ERROR -> Napier.e(event.message, t, event.tag)
            Logger.Level.ASSERT -> Napier.wtf(event.message, t, event.tag)
        }
    }
}

// 业务侧使用示例（不要直接引入 Napier）：
// Logger.d(tag = "Login") { "login success" }
// Logger.e(tag = "Api", throwable = e, fields = mapOf("code" to code)) { "request failed" }
