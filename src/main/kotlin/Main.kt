package org.example
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime
import kotlin.coroutines.intrinsics.createCoroutineUnintercepted
import kotlin.coroutines.resume

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() =  runBlocking {
//    flow {
//        println("`11111 $this")
//        emit(1)
//        println(4)
//        emit(2)
//    }.map {
//        it+1
//        println(2)
//    }.collect { str ->
//        println(3)
//    }

    GlobalScope.launch {
        println("new continuation todo something. current thread: ${Thread.currentThread().name}")
    }

    while (true){}
}

//fun main(args : Array<String>) {
//    GlobalScope.launch {
//        println("1")
//    }
//}


//fun <T> launch3(block: suspend () -> T) {
//    // 1、传入代码块block，使用block创建协程，
//    // 2、同时自行创建一个续体，「resumeWith」最终会被调用
//    val coroutine = block.createCoroutineUnintercepted(object : Continuation<T> {
//        override val context: CoroutineContext
//            get() = EmptyCoroutineContext
//
//        override fun resumeWith(result: Result<T>) {
//            println("11111111")
//        }
//
//    })
//    // 3、执行block协程
//    coroutine.resume(Unit)
//}

//fun main() {
//    println("start")
//    launch3 {
//        println("end")
//    }
//    val coroutineDispatcher = newSingleThreadContext("ctx")
    // 启动协程 1

//    GlobalScope.async {
//        println("the second coroutine 11111")
//        delay(100)
//        println("the second coroutine 222222")
//    }
//
//    CoroutineScope(Dispatchers.IO
//    ).launch{
//
//    }






//    GlobalScope.launch {
//        runBlocking {
//            println("CoroutineScope.launch111")
//            delay(1000)
//            println("CoroutineScope.launch222")
//        }
//
//        //在协程内创建子协程
//        launch {
//            println("CoroutineScope.333")
//            delay(1500)
//            println("launch 子协程")
//        }
//    }

//    runBlocking {
//        launch {
//            runBlocking {
//                println("11111111")
//                delay(1000)
//                println("2222222")
//            }
//            println("-----")
//        }
        /*launch(Dispatchers.IO) {
            runBlocking {
                println("44444444")
                delay(1000)
                println("5555")
            }
        }*/

//    }



//    GlobalScope.launch(coroutineDispatcher) {
//        println("the first coroutine")
//        async (Dispatchers.IO) {
//
//        }.await()
//        println("the first coroutine end end end")
//    }
//    println("end")
//
//    println("end")
//    runBlocking {
//        val time = measureTimeMillis {
//            runBlocking {
//                launch {
//                    println("1111")
//                    doSomethingUsefulOne()
//                    println("3333")
//                } // Launches first coroutine does NOT wait
//                launch {
//
//                    println("2222")
//                    doSomethingUsefulTwo()
//                } // Launches second coroutine does NOT wait
//            }
//
//        }
//        launch {
//            println("Completed in $time ms")
//        }
//    }
//    while (true){}
//}

suspend fun doSomethingUsefulTwo() {
// withContext(Dispatchers.IO){
//
// }
}


//suspend fun doSomethingUsefulOne() {
//    delay(10000)
//}

