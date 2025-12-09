package com.aavidsoft.recyclerview02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aavidsoft.recyclerview02.adapters.CitiesAdapter
import com.aavidsoft.recyclerview02.databinding.ActivityMainBinding
import com.aavidsoft.recyclerview02.models.Advertisement
import com.aavidsoft.recyclerview02.models.City

class MainActivity : AppCompatActivity() {
   private val cities = arrayListOf(
        City(
            "Mumbai \n Capital of Maharashtra and economical capital of India",
            R.drawable.mumbai,
            20411000
        ),
        City("Delhi", R.drawable.delhi, 19000000),
        City("Bengaluru", R.drawable.bengaluru, 12700000),
        City("Hyderabad", R.drawable.hyderabad, 10500000),
        City("Ahmedabad", R.drawable.ahmedabad, 8400000),
        City("Chennai \n Capital of Tamilnadu", R.drawable.chennai, 11300000),
        City("Kolkata", R.drawable.kolkata, 14600000),
        City("Pune", R.drawable.pune, 7430000),
        City("Jaipur", R.drawable.jaipur, 4000000),
        City("Surat", R.drawable.surat, 6800000),
        City("Lucknow", R.drawable.lucknow, 3600000),
        City("Kanpur", R.drawable.kanpur, 3200000),
        City("Nagpur", R.drawable.nagpur, 2900000),
        City("Indore - Cleanest city of India", R.drawable.indore, 3100000),
        City("Thane", R.drawable.thane, 1800000),
        City("Bhopal", R.drawable.bhopal, 2500000),
        City("Visakhapatnam", R.drawable.visakhapatnam, 2300000),
        City("Patna", R.drawable.patna, 2100000),
        City("Vadodara", R.drawable.vadodara, 2100000),
        City("Ghaziabad", R.drawable.ghaziabad, 2400000),
        City("Ludhiana", R.drawable.ludhiana, 1600000),
        City("Agra", R.drawable.agra, 1700000),
        City("Nashik", R.drawable.nashik, 1500000),
        City("Faridabad", R.drawable.faridabad, 1400000),
        City("Meerut", R.drawable.meerut, 1300000),
        City("Rajkot", R.drawable.rajkot, 1300000),
        City("Varanasi", R.drawable.varanasi, 1200000),
        City("Srinagar", R.drawable.srinagar, 1200000),
        City("SambhajiNagar", R.drawable.sambhaji_nagar, 1200000),
        City("Ranchi", R.drawable.ranchi, 1100000)
    )
    val advertisements = arrayListOf(
        Advertisement(1, "50% Off on Electronics"),
        Advertisement(2, "Buy 1 Get 1 Free – Pizza Deal"),
        Advertisement(3, "Holiday Sale – Up to 70% Off"),
        Advertisement(4, "New Arrivals: Fashion Trends 2025"),
        Advertisement(5, "Mega Furniture Clearance"),
        Advertisement(6, "Exclusive Travel Packages"),
        Advertisement(7, "Flash Sale – Limited Time Only"),
        Advertisement(8, "Gym Membership Discount"),
        Advertisement(9, "Free Home Delivery on Orders Above ₹499"),
        Advertisement(10, "Smartphone Exchange Offer"),
        Advertisement(11, "Kids Toys Winter Sale"),
        Advertisement(12, "Big Bazaar Weekend Offer"),
        Advertisement(13, "Movie Tickets @ ₹99"),
        Advertisement(14, "Festival Special Jewellery Discount"),
        Advertisement(15, "New Restaurant Opening Offer"),
        Advertisement(1, "50% Off on Electronics"),
        Advertisement(2, "Buy 1 Get 1 Free – Pizza Deal"),
        Advertisement(3, "Holiday Sale – Up to 70% Off"),
        Advertisement(4, "New Arrivals: Fashion Trends 2025"),
        Advertisement(5, "Mega Furniture Clearance"),
        Advertisement(6, "Exclusive Travel Packages"),
        Advertisement(7, "Flash Sale – Limited Time Only"),
        Advertisement(8, "Gym Membership Discount"),
        Advertisement(9, "Free Home Delivery on Orders Above ₹499"),
        Advertisement(10, "Smartphone Exchange Offer"),
        Advertisement(11, "Kids Toys Winter Sale"),
        Advertisement(12, "Big Bazaar Weekend Offer"),
        Advertisement(13, "Movie Tickets @ ₹99"),
        Advertisement(14, "Festival Special Jewellery Discount"),
        Advertisement(15, "New Restaurant Opening Offer")
    )

    /*private val cities = arrayListOf(
        City(
            "Mumbai \n Capital of Maharashtra and economical capital of India",
            R.drawable.mumbai,
            20411000
        )
    )
    val advertisements = arrayListOf(
        Advertisement(1, "50% Off on Electronics")
    )*/
    private lateinit var citiesAdapter: CitiesAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddCity.setOnClickListener {
            cities.add(
                City(
                    binding.edtCityTitle.text.toString(),
                    R.drawable.ic_launcher_background,
                    binding.edtCityPopulation.text.toString().toLong()
                    )
            )
            advertisements.add(
                Advertisement(
                    45,
                    "Advertisement for ${binding.edtCityTitle.text.toString()}"
                )
            )
            //citiesAdapter.notifyDataSetChanged()
            citiesAdapter.notifyItemInserted(cities.size)
        }

        binding.recyclerCities.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //recyclerCities.layoutManager = GridLayoutManager(this, 3)
        //recyclerCities.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        citiesAdapter = CitiesAdapter(cities, advertisements)
        binding.recyclerCities.adapter = citiesAdapter


    }
}