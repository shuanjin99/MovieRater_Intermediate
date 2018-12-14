package a174565f.nyp.com.practassignmentintermediate

import android.app.Activity
import android.content.Intent
import android.media.Rating
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.movie_review.*
import kotlinx.android.synthetic.main.rating_page.*

class RatingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rating_page)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rating_mov,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.RateMovieSubmit){
            val bundle:Bundle?=intent.extras
            val movieTitle = bundle!!.getString("movName")
            val movieDesc = bundle!!.getString("movDesc")
            val movieDate = bundle!!.getString("movDate")
            val movieLang = bundle!!.getString("movLang")
            val movieSuitable= bundle!!.getString("movSuitable")
            val ratingTitle = review.text.toString()
            val rating = ratingBar.rating
            var RatemovieIntent = Intent()
            RatemovieIntent.putExtra("movName", movieTitle)
            RatemovieIntent.putExtra("movDesc", movieDesc)
            RatemovieIntent.putExtra("movDate", movieDate)
            RatemovieIntent.putExtra("movLang", movieLang)
            RatemovieIntent.putExtra("movSuitable", movieSuitable)
            RatemovieIntent.putExtra("movRate", rating)
            RatemovieIntent.putExtra("movUserReview",ratingTitle)
            setResult(Activity.RESULT_OK, RatemovieIntent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
