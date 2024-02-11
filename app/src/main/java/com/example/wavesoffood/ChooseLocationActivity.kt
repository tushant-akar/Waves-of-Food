package com.example.wavesoffood

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.wavesoffood.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflator)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var locationList: Array<String> = arrayOf("Jaipur","Odisha","Bundi","Sikar","Jodhpur","Udaipur","Jaisalmer","Ajmer","Bikaner","Kota","Chittorgarh","Alwar","Mount Abu","Pushkar","Bharatpur","Ranthambore","Bhilwara","Churu","Dungarpur","Hanumangarh","Jhunjhunu","Pali","Sawai Madhopur","Tonk","Baran","Barmer","Dausa","Dholpur","Ganganagar","Jhalawar","Karauli","Nagaur","Rajsamand","Sirohi","Pratapgarh","Banswara")
        var adapter = ArrayAdapter(this, R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}