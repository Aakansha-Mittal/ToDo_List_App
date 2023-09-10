package com.example.todolist_app

import android.app.Activity
import android.graphics.Paint
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(val context : Activity, val taskList : MutableList<String>)
    : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    class TaskViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val taskText = itemView.findViewById<TextView>(R.id.taskText)!!
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return TaskViewHolder(view)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currTask = taskList[position]
        holder.taskText.text = currTask

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                holder.checkBox.isChecked = true
                holder.taskText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}