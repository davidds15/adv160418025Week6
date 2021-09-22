package id.ac.ubaya.infor.advweek6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.infor.advweek6.model.Student
import id.ac.ubaya.infor.advweek6.view.StudentDetailFragmentArgs

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()
    fun fetch(id: String?,name:String?,bod:String?,phone:String?,photoUrl:String?) {
        val student1 = Student(id,name,bod,phone,photoUrl)
        studentLD.value = student1
    }
}