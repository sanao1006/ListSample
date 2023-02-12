package com.example.listsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ListViewオブジェクト取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
//        ListViewに表示するデータ
        var menuList = mutableListOf(
            "から揚げ定食",
            "ハンバーグ 定食",
            "生姜 焼き定食",
            "ステーキ定食",
            "野菜炒め定食",
            "とんかつ定食",
            "ミンチかつ定食",
            "チキンカツ定食",
            "コロッケ 定食",
            "回鍋肉 定食",
            "麻婆豆腐 定食",
            "青 椒 肉 絲 定食",
            "八宝菜 定食",
            "酢豚 定食",
            "豚 の 角煮",
            "焼き鳥",
            "焼き魚 定食",
            "焼肉 定食"
        )
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, menuList)

        lvMenu.adapter = adapter
        lvMenu.onItemClickListener=ListenItemClickListener()

    }
    private inner class ListenItemClickListener: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            var dialogFragment = OrderConfirmDialogFragment()
            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
}