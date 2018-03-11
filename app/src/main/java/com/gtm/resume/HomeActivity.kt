package com.gtm.resume

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_about.*
import kotlinx.android.synthetic.main.content_header.*


/**
 *
 * @author Gowtham kumar
 *
 * Home screen for this application
 *
 */
class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Load display picture
        display_picture.loadImageCenterCrop();

        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)

            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, "gtm516@gmail.com");

            intent.setData(Uri.parse("mailto:"))
            startActivity(Intent.createChooser(intent, "Send an email to gowtham using"))
        }
        test.setOnClickListener {

            layout.visibility = View.GONE;
        }
    }


    fun ImageView.loadImageCenterCrop() {
        val circle = CircleTransformation();
        Picasso.with(this.getContext())
                .load(R.drawable.display_pic_gtm)
                .centerCrop()
                .fit()
                .transform(circle)
                .into(this)
    }
}
