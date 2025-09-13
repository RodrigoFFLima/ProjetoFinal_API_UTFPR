package com.example.whereisthecar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whereisthecar.R
import com.example.whereisthecar.model.Car
import com.example.whereisthecar.ui.loadUrl

class CarAdapter(
    private val cars: List<Car>,
    private val carClickListener: (Car) -> Unit
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car_layout, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]

        holder.name.text = holder.itemView.context.getString(R.string.car_model, car.name.toString())
        holder.year.text = holder.itemView.context.getString(R.string.car_year, car.year.toString())
        holder.licence.text = holder.itemView.context.getString(R.string.car_licence, car.licence.toString())
        holder.imageView.loadUrl(car.imageUrl)

        holder.itemView.setOnClickListener {
            carClickListener(car)
        }
    }

    override fun getItemCount(): Int = cars.size

    class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.name)
        val year: TextView = view.findViewById(R.id.year)
        val licence: TextView = view.findViewById(R.id.licence)
    }
}
