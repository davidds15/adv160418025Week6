package id.ac.ubaya.infor.advweek6.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import id.ac.ubaya.infor.advweek6.R
import id.ac.ubaya.infor.advweek6.databinding.FragmentStudentDetailBinding
import id.ac.ubaya.infor.advweek6.databinding.StudentListItemBinding
import id.ac.ubaya.infor.advweek6.util.loadImage
import id.ac.ubaya.infor.advweek6.viewmodel.DetailViewModel
import id.ac.ubaya.infor.advweek6.viewmodel.ListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment(),ButtonNotificationClickListener {
    private lateinit var viewModel: DetailViewModel
    private var stuPos=""
    private lateinit var dataBinding:FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
//        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stuPos = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(stuPos)
            dataBinding.listener=this
        observerStudent()
    }
    fun observerStudent(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
                dataBinding.student= it


//            txtID.setText(viewModel.studentLD.value?.id)
//            txtName.setText(viewModel.studentLD.value?.name)
//            txtBoD.setText(viewModel.studentLD.value?.bod)
//            txtPhone.setText(viewModel.studentLD.value?.phone)
//            imageView2.loadImage(viewModel.studentLD.value?.photoUrl, progressBar2)
//            var student = it
//            btnNotif.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds")
//                        MainActivity.showNotification(student.name.toString(),
//                            "A new notification created",
//                            R.drawable.ic_baseline_person_24)
//                    }
//            }

        })
    }

    override fun onButtonNotificationClick(v: View) {
                        Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("Messages", "five seconds")
                        MainActivity.showNotification(v.tag.toString(),
                            "A new notification created",
                            R.drawable.ic_baseline_person_24)
                    }
    }
}