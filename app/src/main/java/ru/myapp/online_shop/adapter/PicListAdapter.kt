package ru.myapp.online_shop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.myapp.online_shop.databinding.ViewholderPicListBinding

class PicListAdapter(val items: MutableList<String>, var picMin: ImageView): RecyclerView.Adapter<PicListAdapter.Viewholder>() {

    private var selectPosition = -1
    private var lastSelectPosition = -1
    private lateinit var context: Context

    inner class Viewholder(val binding: ViewholderPicListBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicListAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderPicListBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: PicListAdapter.Viewholder, position: Int) {
        Glide.with(context)
            .load(items[position])
            .into(holder.binding.picList)

        holder.binding.root.setOnClickListener {
            lastSelectPosition = selectPosition
            selectPosition = position
            notifyItemChanged(lastSelectPosition)
            notifyItemChanged(selectPosition)

            Glide.with(context)
                .load(items[position])
                .into(picMin)
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}