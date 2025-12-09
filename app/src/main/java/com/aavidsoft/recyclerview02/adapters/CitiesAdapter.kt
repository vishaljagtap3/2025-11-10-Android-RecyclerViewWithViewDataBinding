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
import com.aavidsoft.recyclerview02.databinding.AdvLayoutBinding
import com.aavidsoft.recyclerview02.databinding.CityLayoutBinding
import com.aavidsoft.recyclerview02.models.Advertisement
import com.aavidsoft.recyclerview02.models.City
import org.w3c.dom.Text
import java.util.Random

class CitiesAdapter(
    private val cities: ArrayList<City>,
    private val advertisements: ArrayList<Advertisement>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val VIEW_TYPE_POST = 1
    val VIEW_TYPE_ADV = 2

    inner class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cityLayoutBinding = CityLayoutBinding.bind(view)

        init {
            cityLayoutBinding.txtCityName.setOnClickListener {
                Toast.makeText(it.context, "${cities[adapterPosition/2].title}", Toast.LENGTH_LONG)
                    .show()
            }

            cityLayoutBinding.txtCityPopulation.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "${cities[adapterPosition/2].title} ${cities[adapterPosition/2].population}",
                    Toast.LENGTH_LONG
                ).show()
            }

            cityLayoutBinding.imgCity.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "${cities[adapterPosition/2].title} image",
                    Toast.LENGTH_LONG
                ).show()
            }
            /*view.setOnClickListener {
                Toast.makeText(it.context, "${cities[adapterPosition].title} clicked - 0", Toast.LENGTH_LONG).show()
            }*/
        }
    }

    inner class AdvViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val advLayoutBinding = AdvLayoutBinding.bind(view)
        init {
            advLayoutBinding.txtAdvTitle.setOnClickListener {
                //Do something here
            }
        }
    }

    override fun getItemCount() = cities.size + advertisements.size
    //override fun getItemCount() = 2

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            VIEW_TYPE_POST
        } else {
            VIEW_TYPE_ADV
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_POST) {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.city_layout, null)

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


        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.adv_layout, null)
        return AdvViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CityViewHolder) {
            holder.cityLayoutBinding.city = cities[position/2]
            /*holder.cityLayoutBinding.imgCity.setImageResource(city.imageResourceId)
            holder.cityLayoutBinding.txtCityName.text = city.title
            holder.cityLayoutBinding.txtCityPopulation.text = "${city.population}"*/
        }

        if(holder is AdvViewHolder) {
            holder.advLayoutBinding.txtAdvTitle.text = advertisements[position/2].title
        }
    }
}