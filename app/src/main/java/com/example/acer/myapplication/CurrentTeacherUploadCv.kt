package com.example.acer.myapplication

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class CurrentTeacherUploadCv : AppCompatActivity() {



    val PDF : Int = 0
    lateinit var uri : Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_teacher_upload_cv)
        val email= findViewById<View>(R.id.email) as TextView
        val id = findViewById<View>(R.id.id) as TextView
        val dateofbirth = findViewById<View>(R.id.dateofbirth) as TextView
        val name = findViewById<View>(R.id.name) as TextView
        val teacher_info = findViewById<View>(R.id.teacher_info) as TextView
        val phone = findViewById<View>(R.id.phone) as TextView
        val uriTxt = findViewById<View>(R.id.uriTxt) as TextView

        val update = findViewById<View>(R.id.update) as Button
        val upplybtn = findViewById<View>(R.id.upplybtn)  as Button
        val upload = findViewById<View>(R.id.upload) as Button //




        // start
        fun upplybtn (view:View) {
            upplybtn.setOnClickListener(View.OnClickListener {
                view: View? ->
                //  })
                var intent = Intent (this,NewTeacherUploadcv::class.java)
                startActivity(intent)
            })
        } //end


        // start
        fun update (view:View) {
            update.setOnClickListener(View.OnClickListener {
                view: View? ->

                var intent = Intent (this,NewTeacherUploadcv::class.java)
                startActivity(intent)
            })
        } // end



        // start
        fun upload(view: View) {
            upload.setOnClickListener(View.OnClickListener {
                view: View? ->  val intent = Intent()
                intent.setType("pdf/*")
                intent.setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(Intent.createChooser(intent, "Select PDF"), PDF)
            }) // end

        }
    }// represent the data
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val uriTxt = findViewById<View>(R.id.uriTxt) as TextView
        if (resultCode == RESULT_OK) {
            if (requestCode == PDF) {
                uri = data!!.data
                uriTxt.text = uri.toString()
                // upload()
            }
        }

        super.onActivityResult(requestCode, resultCode, data)


    }


}

