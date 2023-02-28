package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.myapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = activity?.getSharedPreferences("register", AppCompatActivity.MODE_PRIVATE)
        val edit = sharedPref?.edit()

        binding.radioGroup.setOnCheckedChangeListener { _, rdButtonId ->
            if (rdButtonId == binding.radioMale.id) {
                edit?.putString("gender", binding.radioMale.text.toString())
            } else {
                edit?.putString("gender", binding.radioFemale.text.toString())
            }
        }
        binding.btnRegister.setOnClickListener {
            if (binding.edtPassword.text.toString() != binding.edtRepassword.text.toString()) {
                Toast.makeText(activity, "password no match!!", Toast.LENGTH_SHORT).show()
            }
            edit?.putString("fullName", binding.edtFullname.text.toString())
            edit?.putString("userName", binding.edtUsername.text.toString())
            edit?.putString("email", binding.edtEmail.text.toString())
            edit?.putString("password", binding.edtPassword.text.toString())
            edit?.apply()
        }
        binding.btnShowInfo.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace<ShowInfoFragment>(R.id.container)
                .addToBackStack(null)
                .commit()
        }


    }
}