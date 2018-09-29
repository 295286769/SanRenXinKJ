package com.srx.huangweishui.common.utils

/**
 * Created by huangweishui on 2018/8/23.
 */
 class ActivityConstantPathUtil {
    //实质上经过const修饰的常量，才是java中理解的常量
     companion object{
         const  val STARTKOTLINACTIVITY :String="/homeproject/WellComActivity"
         const  val HOMEACTIVITY :String="/homeproject/HomeActivity"
        //fragment
        const  val HOMEFRAGMENT:String="/main/HomeFragment"
        const  val MINEFRAGMENT:String="/mine/MineFragment"
    }
}