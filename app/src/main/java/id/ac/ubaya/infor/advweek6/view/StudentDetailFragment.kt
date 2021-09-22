package id.ac.ubaya.infor.advweek6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import id.ac.ubaya.infor.advweek6.R
import id.ac.ubaya.infor.advweek6.util.loadImage
import id.ac.ubaya.infor.advweek6.viewmodel.DetailViewModel
import id.ac.ubaya.infor.advweek6.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(StudentDetailFragmentArgs.fromBundle(requireArguments()).id,
            StudentDetailFragmentArgs.fromBundle(requireArguments()).name,StudentDetailFragmentArgs.fromBundle(requireArguments()).bod,
            StudentDetailFragmentArgs.fromBundle(requireArguments()).phone,StudentDetailFragmentArgs.fromBundle(requireArguments()).photoUrl)
        observerStudent()
    }
    fun observerStudent(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            txtID.setText(viewModel.studentLD.value?.id)
            txtName.setText(viewModel.studentLD.value?.name)
            txtBoD.setText(viewModel.studentLD.value?.bod)
            txtPhone.setText(viewModel.studentLD.value?.phone)
            imageView2.loadImage(viewModel.studentLD.value?.photoUrl, progressBar2)
        })
    }
}