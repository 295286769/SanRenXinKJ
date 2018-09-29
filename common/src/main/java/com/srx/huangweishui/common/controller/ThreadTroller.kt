package com.srx.huangweishui.common.controller

import android.content.Context
import com.srx.huangweishui.common.utils.Logger
import java.util.concurrent.*
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

/**
 * Created by huangweishui on 2018/9/18.
 */
class ThreadTroller {
    private var context:Context?=null
    private lateinit var  excouter:ScheduledThreadPoolExecutor;
    var lockObject=Any()
    var lock=ReentrantLock()
    @Volatile private  var  number=0
    constructor(context: Context){
        this.context=context;
    }
    init {
        excouter=ScheduledThreadPoolExecutor(3)
    }

    fun excut(): Unit {
        for (i in 0..19){
            thread(start = true) {
                for (i in 0..99){
                    number++
                    Logger.i("thread",Thread.currentThread().name+":"+number)
                }


            }

        }

        var thread:Thread= Thread(object :Runnable{
            override fun run() {
                synchronized(lockObject){

                }
                Logger.i("TTT","线程_1")
                lock.lock()
                try {

                }catch (e:Exception){

                }finally {
                    lock.unlock()
                }

            }

        })
        thread.start()
        thread.join()
        var thread_2:Thread= Thread(object :Runnable{
            override fun run() {
                Logger.i("TTT","线程_2")
            }
        })
        thread_2.start()
        thread_2.join()
        var thread_3:Thread= Thread(object :Runnable{
            override fun run() {
                Logger.i("TTT","线程_3")
            }
        })
        thread_3.start()
        thread_3.join()



            excouter.scheduleWithFixedDelay(object :Runnable{
                override fun run() {

                }

            },1000,1000,TimeUnit.SECONDS)

    }

    fun setClear(): Unit {
        if(excouter!=null){
            excouter.shutdown()
        }
    }

}