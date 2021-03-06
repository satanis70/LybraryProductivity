package com.example.test

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs


class ModuleFragment : Fragment() {
    lateinit var navController: NavController
    val args: ModuleFragmentArgs by navArgs()
    var textView: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_module, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.textView)
        navController = Navigation.findNavController(view)
        val intent: Intent = requireActivity().intent
        val data = intent.getStringExtra("text")
        textView?.text = data
        ToastObj.getInfo("Open")
        Toast.makeText(requireContext(), ToastObj.toast(), Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        ToastObj.getInfo("Close")
    }

}