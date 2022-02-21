package com.example.retrofit_11_daffa.retrofit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofit_11_daffa.R
import com.example.retrofit_11_daffa.retrofit.api.RetrofitClient
import com.example.retrofit_11_daffa.retrofit.model.indonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()
        btnProvince.setOnClickListener{
            Intent(  this@MainActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }

    }
    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object :
            retrofit2.Callback<ArrayList<indonesiaResponse>> {
            override fun onFailure(call: Call<ArrayList<indonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "$(t.message)", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<indonesiaResponse>>,
                response: Response<ArrayList<indonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val hospitalized  = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death= indonesia?.meninggal

                tvPositive.text = positive
                tvRecover.text = recover
                tvHospitalized.text = hospitalized
                tvDeath.text = death
            }
        })
    }
}