package com.example.firstexperience

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    //保存抽奖名单
    var names= listOf<String>("小杨人","王小王","emmmm")
    //定时器 每隔一段时间切换一次名字
    lateinit var timer:Timer
    //记录当前索引
    var index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        //设置默认显示第一个人
        mNameTextView.text=names[index]

        //相应点击事件
        mStartBtn.setOnClickListener{
            //判断标题
            if(mStartBtn.text.toString()=="Start"){
                mStartBtn.text="Stop"
                //创建定时器
                timer= Timer()
                //分配一个任务
                timer.schedule(object :TimerTask(){
                    override fun run(){
                        //判断是否越界
                        index=if(index+1>names.size-1) 0 else index++
                        Log.v("emmm","$index")
                        //取出对应的名字
                        mNameTextView.text=names[index]
                    }

                },0,100)
            }else{
                mStartBtn.text="Start"
                timer.cancel()
            }
        }
    }
}