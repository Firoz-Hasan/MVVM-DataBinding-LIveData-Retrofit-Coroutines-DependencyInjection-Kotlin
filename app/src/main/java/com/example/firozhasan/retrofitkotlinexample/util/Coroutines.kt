package com.example.firozhasan.retrofitkotlinexample.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object Coroutines {
    fun main(work : suspend (() -> Unit)){
        CoroutineScope(Dispatchers.Main).launch {
            work()
            //when we say launch this will fire up a new coroutine
        }
    }

    fun io(work : suspend (() -> Unit)){
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }
    }

    suspend fun withContextMain(work : suspend (() -> Unit)){
        withContext(Dispatchers.Main) {
            work()
            // when we say withcontext that means we are using already existed
            // coroutine not firing any new coroutine.
        }
    }

    suspend fun withContextIO(work : suspend (() -> Unit)){
        withContext(Dispatchers.IO) {
            work()
        }
    }
}