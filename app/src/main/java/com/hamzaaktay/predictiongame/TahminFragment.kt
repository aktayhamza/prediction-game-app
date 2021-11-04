package com.hamzaaktay.predictiongame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.hamzaaktay.predictiongame.databinding.FragmentTahminBinding


class TahminFragment : Fragment() {

    private var _binding : FragmentTahminBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTahminBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tahminButton.setOnClickListener {
            findNavController().navigate(R.id.action_tahminFragment_to_sonucFragment)
        }

        var hak = 10
        binding.kalanHakTextview.text = "Kalan Hak: $hak"

        val randomSayi = (0..10).random()

        binding.tahminButton.setOnClickListener {



            var tahmin = 0

            if (binding.tahminEditText.text.toString().isEmpty() || binding.tahminEditText.text.toString() == ""){
               Toast.makeText(context, "LUTFEN BIR TAHMINDE BULUNUN!", Toast.LENGTH_SHORT).show()
            } else{
                hak= hak-1
                binding.kalanHakTextview.text = "Kalan Hak: $hak"
                val tahmin = binding.tahminEditText.text.toString().toInt()

                if (tahmin > randomSayi){
                    binding.yardimciTextview.text = "Yardim: Azalt"
                } else if (tahmin< randomSayi){
                    binding.yardimciTextview.text = "Yardim: Artir"
                } else if (tahmin == randomSayi){
                    val gecis = TahminFragmentDirections.actionTahminFragmentToSonucFragment("WIN")
                    findNavController().navigate(gecis)
                }

                if(hak==0){
                    val gecis = TahminFragmentDirections.actionTahminFragmentToSonucFragment("LOSE")
                    findNavController().navigate(gecis)
                }


            }


        }



    }



    override fun onDestroyView() {
        super.onDestroyView()
    }
}