package com.example.myfirstapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


lateinit var submitBtn : Button;
lateinit var name:EditText;
lateinit var degree:EditText;
lateinit var designation:EditText;
lateinit var phone:EditText;
lateinit var email:EditText;
lateinit var company:EditText;
lateinit var services:EditText;
lateinit var address:EditText;
lateinit var telephone:EditText;
lateinit var oEmail:EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        submitBtn=findViewById(R.id.SubmitBtn)
        name=findViewById(R.id.name)
        degree=findViewById(R.id.Degree)
        designation=findViewById(R.id.Designation)
        phone=findViewById(R.id.Phone)
        email=findViewById(R.id.email)
        company=findViewById(R.id.Company)
        services=findViewById(R.id.Services)
        address=findViewById(R.id.address)
        oEmail=findViewById(R.id.oEmail)
        telephone=findViewById(R.id.telephone)



        submitBtn.setOnClickListener{
            val name_str=name.text.toString()
            val degree_str=degree.text.toString()
            val designation_str=designation.text.toString()
            val phone_str=phone.text.toString()
            val email_str=email.text.toString()
            val company_str=company.text.toString()
            val services_str=services.text.toString()
            val address_str=address.text.toString()
            val oEmail_str=oEmail.text.toString()
            val telephone_str=telephone.text.toString()

            val toast = Toast.makeText(applicationContext, "Text here", Toast.LENGTH_LONG)
            if(name_str=="" ){

                toast.setText("Please Enter Your name")
                toast.show()
                openSoftKeyboard(this,name)
            }
            else if(designation_str==""){
                toast.setText("Please Enter Your designation")
                toast.show()
                openSoftKeyboard(this,designation)

            }
            else if(degree_str==""){
                toast.setText("Please Enter Your Degree")
                toast.show()
                openSoftKeyboard(this,degree)
            }

            else if(phone_str==""){
                toast.setText("Please Enter Your phone No")
                toast.show()
                openSoftKeyboard(this,phone)
            }
            else if(phone_str.length<11){
                toast.setText("Phone No Must Be minimul 11 Digits")
                toast.show()
                openSoftKeyboard(this,phone)
            }

            else if(!isValidEmail(email_str)){
                toast.setText("Please Enter Valid email Address")
                toast.show()
                openSoftKeyboard(this,email)
            }
            else if(company_str==""){
                toast.setText("Please Enter Organization Name")
                toast.show()
                openSoftKeyboard(this,company)
            }
            else if(services_str==""){
                toast.setText("Please Enter Services Your Org. Provide ")
                toast.show()
                openSoftKeyboard(this,services)
            }
            else if(address_str==""){
                toast.setText("Please Enter Office Address")
                toast.show()
                openSoftKeyboard(this,address)
            }
            else if(!isValidEmail(oEmail_str)){
                toast.setText("Please Enter Office Email")
                toast.show()
                openSoftKeyboard(this,oEmail)
            }
            else if(telephone_str==""){
                toast.setText("Please Enter a valid Office Email")
                toast.show()
                openSoftKeyboard(this,telephone)
            }
            else{
                val intent= Intent(this,Visitingcard::class.java)
                intent.putExtra("Name",name_str)
                intent.putExtra("degree",degree_str)
                intent.putExtra("designation",designation_str)
                intent.putExtra("phone",phone_str)
                intent.putExtra("email",email_str)
                intent.putExtra("company",company_str)
                intent.putExtra("services",services_str)
                intent.putExtra("address",address_str)
                intent.putExtra("oEmail",oEmail_str)
                intent.putExtra("telephone",telephone_str)
                startActivity(intent)
            }


        }
//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }


    val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    private fun chooseLibrary() {
        val libraryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    }

   private fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            EMAIL_ADDRESS_PATTERN.matcher(target).matches()

        }
    }
   private fun openSoftKeyboard(context: Context, view: View) {
        view.requestFocus()
        // open the soft keyboard
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}