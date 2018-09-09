package au.com.doan.qantas.base

import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

interface BaseDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: MenuView.ItemView)
}