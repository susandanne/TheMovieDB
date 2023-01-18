package com.example.themoviedb.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.themoviedb.R
import com.example.themoviedb.adapter.Adapterlang
import com.example.themoviedb.databinding.FragmentHomeBinding
import com.example.themoviedb.viewmodel.ViewModel

class HomeFragment : Fragment() {

  lateinit var binding: FragmentHomeBinding
  lateinit var adapterlang: Adapterlang
  lateinit var  viewModel: ViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        viewModel=ViewModelProvider(this)[ViewModel::class.java]
        viewModel.latestmovieVM()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterlang= Adapterlang()
        binding.rv.adapter=adapterlang
        binding.latestMovieVP.adapter=adapterlang
        viewModel.listdataviewmodel.observe(requireActivity()){
         adapterlang.submitData(lifecycle,it)
        }


     viewModel.latestmoviesVMLD.observe(viewLifecycleOwner){
    Glide.with(requireActivity()).load(Util.posterUrlMake(it.poster_path))
        .placeholder(R.drawable.img)
        .into(binding.latestMovie)
}


    }

}