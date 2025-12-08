package com.aavidsoft.recyclerview02.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aavidsoft.recyclerview02.R
import com.aavidsoft.recyclerview02.models.City
import org.w3c.dom.Text
import java.util.Random

class CitiesAdapter(
    private val cities: ArrayList<City>
) : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    inner class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtCityName: TextView = view.findViewById(R.id.txtCityName)
        val imgCity: ImageView = view.findViewById(R.id.imgCity)
        val txtCityPopulation: TextView = view.findViewById(R.id.txtCityPopulation)

        init {
            txtCityName.setOnClickListener {
                Toast.makeText(it.context, "${cities[adapterPosition].title}", Toast.LENGTH_LONG)
                    .show()
            }

            txtCityPopulation.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "${cities[adapterPosition].title} ${cities[adapterPosition].population}",
                    Toast.LENGTH_LONG
                ).show()
            }

            imgCity.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "${cities[adapterPosition].title} image",
                    Toast.LENGTH_LONG
                ).show()
            }
            /*view.setOnClickListener {
                Toast.makeText(it.context, "${cities[adapterPosition].title} clicked - 0", Toast.LENGTH_LONG).show()
            }*/
        }
    }

    override fun getItemCount() = cities.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.city_layout1, null)

        val random = Random()
        view.setBackgroundColor(
            Color.argb(
                89,
                Math.abs(random.nextInt()) % 256,
                Math.abs(random.nextInt()) % 256,
                Math.abs(random.nextInt()) % 256
            )
        )

        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities[position]
        holder.imgCity.setImageResource(city.imageResourceId)
        holder.txtCityName.text = city.title
        holder.txtCityPopulation.text = "${city.population}"
    }
}