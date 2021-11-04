package com.hamzaaktay.predictiongame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hamzaaktay.predictiongame.databinding.FragmentAnaSayfaBinding

class AnaSayfaFragment : Fragment() {

    private var _binding : FragmentAnaSayfaBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnaSayfaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.oynaButton.setOnClickListener {
            findNavController().navigate(R.id.action_anaSayfaFragment_to_tahminFragment)
        }


    }



    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}