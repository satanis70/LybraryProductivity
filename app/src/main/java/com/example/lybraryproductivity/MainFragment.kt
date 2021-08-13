package com.example.lybraryproductivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test.ToastObj


class MainFragment : Fragment() {

    lateinit var navController: NavController
    var editText: EditText? = null
    var buttonSend: Button? = null
    var buttonPick: Button? = null
    var imageView: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        editText = view.findViewById(R.id.editText)
        buttonSend = view.findViewById(R.id.button_open_activity)
        imageView = view.findViewById(R.id.imageView)
        buttonSend?.setOnClickListener {
            if (editText?.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), R.string.edit_text_empty, Toast.LENGTH_LONG).show()
            } else {
                val action = MainFragmentDirections.actionMainFragmentToModuleFragment2(editText?.text.toString(), requireActivity().localClassName)
                navController.navigate(action)
            }
        }

        val registerfor = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback { uri->
                imageView?.setImageURI(uri)
            }
        )

        buttonPick = view.findViewById(R.id.button_pick_image)
        buttonPick?.setOnClickListener {
           ToastObj.pickImage(registerfor)
        }
    }

    override fun onResume() {
        super.onResume()
        if (!ToastObj.toast().isNullOrEmpty()){
            Toast.makeText(requireContext(), ToastObj.toast(), Toast.LENGTH_LONG).show()
        }
    }


}

