package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView


class Visitingcard : AppCompatActivity() {
    private lateinit var name: TextView
    lateinit var degree: TextView;
    lateinit var designation: TextView;
    lateinit var phone: TextView;
    lateinit var email: TextView;
    lateinit var company: TextView;
    lateinit var services: TextView;
    lateinit var address: TextView;
    lateinit var telephone: TextView;
    lateinit var oEmail: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitingcard)
        name=findViewById(R.id.nameText)
        degree=findViewById(R.id.degreeText)
        designation=findViewById(R.id.designationText)
        phone=findViewById(R.id.phoneText)
        email=findViewById(R.id.emailText)
        company=findViewById(R.id.companyText)
        services=findViewById(R.id.services)
        address=findViewById(R.id.address)
        oEmail=findViewById(R.id.oEmail)
        telephone=findViewById(R.id.telephone)

        name.text=intent.getStringExtra("Name")
        degree.text=intent.getStringExtra("degree")
        designation.text=intent.getStringExtra("designation")
        phone.text=intent.getStringExtra("phone")
        email.text=intent.getStringExtra("email")
        company.text=intent.getStringExtra("company")
        services.text=intent.getStringExtra("services")
        address.text=intent.getStringExtra("address")
        oEmail.text=intent.getStringExtra("oEmail")
        telephone.text=intent.getStringExtra("telephone")

    }
}