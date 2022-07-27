package com.example.recyclerviewkotlin

import android.graphics.Color
import android.graphics.Color.argb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.RecyclerViewKotlin.LessonAdapter.*
import com.example.RecyclerViewKotlin.databinding.ActivityMainBinding
import com.example.RecyclerViewKotlin.databinding.ItemRecyclerBinding
import java.util.*
import java.util.Arrays.asList
import kotlin.collections.ArrayList
import kotlin.random.Random

class LessonAdapter(val data : ArrayList<LessonModel>): RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class LessonViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lessonModel: LessonModel) {

            binding.txtLesson.text = lessonModel.text
            Glide.with(binding.image).load(lessonModel.image).into(binding.image)
            val color = (Math.random() * 16777215).toInt() or (0xFF shl 24)
            binding.background.setBackgroundColor(color)
        }

    }
}