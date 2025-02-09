package org.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

class Test {

}

fun main() {

   val interceptopr = object : ContinuationInterceptor {
       override val key: CoroutineContext.Key<*>
           get() = ContinuationInterceptor


       override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
           return object : Continuation<T>  by continuation {

               override fun resumeWith(result: Result<T>) {
                    thread { //新线程
                        println("running in thread=${Thread.currentThread().name} - ${result.getOrNull()} before resumeWith")
                        continuation.resumeWith(result)
                        println("running in thread=${Thread.currentThread().name} - ${result.getOrNull()} after resumeWith")
                    }
               }

           }
       }
   }
    GlobalScope.launch(interceptopr) {
        println("111")
        val a = withContext(Dispatchers.IO) {
            println("222")
            1
        }
        println(a)
        println("333")
    }
    while (true){}
}