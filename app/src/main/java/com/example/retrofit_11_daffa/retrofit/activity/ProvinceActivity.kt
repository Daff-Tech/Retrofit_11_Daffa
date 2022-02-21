package com.example.retrofit_11_daffa.retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_11_daffa.R
import com.example.retrofit_11_daffa.retrofit.adapter.provinceAdapter
import com.example.retrofit_11_daffa.retrofit.api.RetrofitClient
import com.example.retrofit_11_daffa.retrofit.model.provinceResponse
import kotlinx.android.synthetic.main.activity_province.*
import retrofit2.Call
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        showProvince()
    }
    private  fun showProvince(){
        rvProvince.setHasFixedSize(true)
        rvProvince.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvince().enqueue(object : retrofit2.Callback<ArrayList<provinceResponse>>{
            override fun onResponse(call: Call<ArrayList<provinceResponse>>, response: Response<ArrayList<provinceResponse>>) {
                val list = response.body()
                val adapter = list?.let { provinceAdapter(it) }
                rvProvince.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<provinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}