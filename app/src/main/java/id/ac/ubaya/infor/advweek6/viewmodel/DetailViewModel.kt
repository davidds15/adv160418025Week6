package id.ac.ubaya.infor.advweek6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.infor.advweek6.model.Student
import id.ac.ubaya.infor.advweek6.view.StudentDetailFragmentArgs

class DetailViewModel (application: Application): AndroidViewModel(application) {
    private  val TAG="volleyTag"
    private var queue:RequestQueue?=null
    val studentLD = MutableLiveData<Student>()
    fun fetch(id:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=" + id

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<Student>() { }.type
                val result = Gson().fromJson<Student>(response, Student::class.java)
                studentLD.value = result

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}