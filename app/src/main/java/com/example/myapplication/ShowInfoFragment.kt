package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentShowinfoBinding

class ShowInfoFragment : Fragment(R.layout.fragment_showinfo) {
    private var _binding: FragmentShowinfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShowinfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.edtFullName.setText(
            activity?.getSharedPreferences(
                "register",
                AppCompatActivity.MODE_PRIVATE
            )?.getString("fullName", null)
        )
        binding.edtUserName.setText(
            activity?.getSharedPreferences(
                "register",
                AppCompatActivity.MODE_PRIVATE
            )?.getString("userName", null)
        )
        binding.edtPassword.setText(
            activity?.getSharedPreferences(
                "register",
                AppCompatActivity.MODE_PRIVATE
            )?.getString("email", null)
        )
        binding.edtEmail.setText(
            activity?.getSharedPreferences(
                "register",
                AppCompatActivity.MODE_PRIVATE
            )?.getString("password", null)
        )
        binding.edtGender.setText(
            activity?.getSharedPreferences(
                "register",
                AppCompatActivity.MODE_PRIVATE
            )?.getString("gender", null)
        )
    }
}