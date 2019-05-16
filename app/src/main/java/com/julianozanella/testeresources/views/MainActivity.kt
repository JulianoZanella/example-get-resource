package com.julianozanella.testeresources.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.julianozanella.testeresources.R
import com.julianozanella.testeresources.config.RetrofitConfig
import com.julianozanella.testeresources.models.Anonimous
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "Tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitConfig().getResourceService()
        //passo o valor da chamada no metodo, olhe explicacao no service.
        service.getResources("IwAR1TvwVJtsM36jAJCkLs9YUjnoetHmdA0a3wr4ZrzvAkEqDLolus8axj8MM")
            .enqueue(object : Callback<List<Anonimous>> {
                override fun onFailure(call: Call<List<Anonimous>>, t: Throwable) {
                    Log.d(TAG, "Error: ${t.message}")
                }

                override fun onResponse(call: Call<List<Anonimous>>, response: Response<List<Anonimous>>) {
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            val r = response.body()!!.map { it.resource }//List de Resources
                            //TODO("O que quiser com a lista...")
                            Log.d(TAG, r.first().toString())
                        }
                    }
                }
            })

    }
}
