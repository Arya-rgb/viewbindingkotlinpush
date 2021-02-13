package com.example.viewbindingkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.viewbindingkotlin.databinding.FragmentBlankBinding

class BlankFragment : Fragment(R.layout.fragment_blank) {

    private var fragmentBlankBinding: FragmentBlankBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBlankBinding.bind(view)
        fragmentBlankBinding = binding

        binding.textfragment.text = "ini adalah text viewbinding fragment"
        // implementasi button langsung di fragment, tidak di main activity ..
        // bermanfaat ketika menggunakan bottom navigation/tabbed layout hahay
        binding.buttonfragment.setOnClickListener {
            Toast.makeText(context, "its  from Fragment", Toast.LENGTH_SHORT).show()
        }

    }
    //Because Fragments continue to live after the View has gone,
    // it’s good to remove any references to the binding class instance
    override fun onDestroyView() {
        fragmentBlankBinding = null
        super.onDestroyView()
    }
}