package com.example.homework_8.ui.aditional

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_8.databinding.FragmentHumanBinding
import com.example.homework_8.ui.model.Human

class HumanFragment : Fragment() {

    private lateinit var binding: FragmentHumanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHumanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: Human? = arguments?.getParcelable<Human>("arg")
        if (data != null) {
            binding.text1.text = "Name = " + data.name
            binding.text2.text = "Birth year = " + data.birthYear
            binding.text3.text = "Eye color = " + data.eyeColor
            binding.text4.text = "Gender = " + data.gender
            binding.text5.text = "Height = " + data.height
            binding.text6.text = "Mass = " + data.mass
            binding.text7.text = "Skin color = " + data.skinColor
            binding.text8.text = "Hair color = " + data.hairColor
            binding.text9.text = "Created = " + data.created
            binding.text10.text = "Edited = " + data.edited

        }
    }

}