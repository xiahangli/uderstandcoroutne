package org.example
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.intrinsics.createCoroutineUnintercepted
import kotlin.coroutines.resume

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    launch3 {
        print("before")
        delay(1_000)
        print("\nmiddle")
        delay(1_000)
        print("\nafter")
    }
    while (true) {

    }
}

fun  <T> launch3(block: suspend () -> T) {
//    // 1、传入代码块block，使用block创建协程，
//    // 2、同时自行创建一个续体，「resumeWith」最终会被调用
    val coroutine = block.createCoroutineUnintercepted(object: Continuation<T> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
           println("111111")
        }

    })
//    // 3、执行block协程
    coroutine.resume(Unit)
}

