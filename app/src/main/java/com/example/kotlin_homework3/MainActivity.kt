package com.example.kotlin_homework3

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //宣告要顯示在的列表上的字串
        val array = arrayOf("message1", "message2", "message3", "message4", "message5")
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            //宣告AlertDialog物件，setButton可以在Dialog對應位置顯示按鈕
            AlertDialog.Builder(this)
                    .setTitle("請選擇功能") //顯示標題
                    .setMessage("請選擇下方按鈕選擇要顯示的物件")    //顯示文字內容
                    .setNeutralButton("取消") { dialog, which ->
                        showToast("dialog關閉")
                    }
                    .setNegativeButton("自定義Toast") { dialog, which ->
                        showToast("自定義Toast")
                        //宣告Toast物件
                        val toast = Toast(this)
                        //設定Toast的顯示位置
                        toast.setGravity(Gravity.TOP, 0, 50)
                        //設定Toast持續時間
                        toast.duration = Toast.LENGTH_SHORT
                        //設定自定義的Toast畫面
                        toast.view = View.inflate(this, R.layout.toast_layout,null)
                        //顯示Toast
                        toast.show()
                    }
                    .setPositiveButton("顯示List") { dialog, which ->
                        AlertDialog.Builder(this)
                                .setItems(array) { dialogInterface, i ->
                                    showToast("你選的是" + array[i])
                                }.show()
                    }.show()
        }
    }
    //使用預設Toast顯示文字訊息
    private fun showToast(text: String) =
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

}