package com.example.todolist_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

var taskList = mutableListOf<String>()

class AddTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val etTask = findViewById<TextInputEditText>(R.id.etTask)
        val addTask = findViewById<FloatingActionButton>(R.id.addTask)

        addTask.setOnClickListener{
            val task = etTask.text.toString()

            if(task.isNotEmpty()){
                taskList.add(task)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter the task", Toast.LENGTH_SHORT).show()
            }
        }

    }
}