package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //region
    private lateinit var btnShowInfo: Button
    private lateinit var btnregister: Button
    private lateinit var btnHideInfo: Button
    private lateinit var linear: LinearLayout
    private lateinit var edtFullName: EditText
    private lateinit var edtUserName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtRePassword: EditText
    private lateinit var edtFullName2: EditText
    private lateinit var edtUserName2: EditText
    private lateinit var edtEmail2: EditText
    private lateinit var edtPassword2: EditText
    private lateinit var edtGender: EditText
    private lateinit var rdGroup: RadioGroup
    private lateinit var rdButtonMale: RadioButton
    private lateinit var rdButtonFeMale: RadioButton

    //endregion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        val sharedPref = getSharedPreferences("register", MODE_PRIVATE)
        val edit = sharedPref.edit()

        rdGroup.setOnCheckedChangeListener { _, rdButtonId ->
            if (rdButtonId == rdButtonMale.id) {
                edit.putString("gender", rdButtonMale.text.toString())
            } else {
                edit.putString("gender", rdButtonFeMale.text.toString())
            }
        }
        btnregister.setOnClickListener {
            if (edtPassword.text.toString() != edtRePassword.text.toString()) {
                Toast.makeText(this, "password no match!!", Toast.LENGTH_SHORT).show()
            }
            edit.putString("fullName", edtFullName.text.toString())
            edit.putString("userName", edtUserName.text.toString())
            edit.putString("email", edtEmail.text.toString())
            edit.putString("password", edtPassword.text.toString())
            edit.apply()
        }
        btnShowInfo.setOnClickListener {
            edtFullName2.setText(sharedPref.getString("fullName", ""))
            edtUserName2.setText(sharedPref.getString("userName", ""))
            edtEmail2.setText(sharedPref.getString("email", ""))
            edtPassword2.setText(sharedPref.getString("password", ""))
            edtGender.setText(sharedPref.getString("gender", ""))
            linear.visibility = View.VISIBLE
        }

        btnHideInfo.setOnClickListener {
            linear.visibility = View.INVISIBLE
        }
    }

    private fun init() {
        btnShowInfo = findViewById(R.id.btn_show_info)
        linear = findViewById(R.id.linear)
        btnHideInfo = findViewById(R.id.btn_hide)
        btnregister = findViewById(R.id.btn_register)
        edtFullName = findViewById(R.id.edt_fullname)
        edtUserName = findViewById(R.id.edt_username)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        edtRePassword = findViewById(R.id.edt_repassword)
        edtFullName2 = findViewById(R.id.edtFullName)
        edtUserName2 = findViewById(R.id.edtUserName)
        edtEmail2 = findViewById(R.id.edtEmail)
        edtPassword2 = findViewById(R.id.edtPassword)
        edtGender = findViewById(R.id.edtGender)
        rdGroup = findViewById(R.id.radio_group)
        rdButtonMale = findViewById(R.id.radio_male)
        rdButtonFeMale = findViewById(R.id.radio_female)
    }
}