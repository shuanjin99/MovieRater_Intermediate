package a174565f.nyp.com.practassignmentintermediate

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_landing_page.*
import kotlinx.android.synthetic.main.add_movie_page.*
import kotlinx.android.synthetic.main.movie_review.*

class MovieReview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_review)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        ViewTitle.text = intent.getStringExtra("movName")
        ViewOverview.text = intent.getStringExtra("movDesc")
        ViewDate.text = intent.getStringExtra("movDate")
        ViewLang.text = intent.getStringExtra("movLang")
        ViewSuitable.text = intent.getStringExtra("movSuitable")
        ViewReview.text = "No Reviews yet.\nLong press here to add your review."
//        var movName = AddMovieName.text.toString()
//        var movDesc = AddMovieDesc.text.toString()
//        var movDate = AddReleaseDate.text.toString()
//        var movReview = ViewReview.text.toString()
//        var movLang = findViewById<RadioButton>(AddrbtnLang.checkedRadioButtonId)
//        var movSuitable = AddchkbxNotSuitable
//        val cinema = MovieEntity(movName, movDesc, movReview, movLang, movDate, movSuitable)
//        ViewTitle.text = cinema.TitleName
//        ViewOverview.text = cinema.description
//        ViewReview.text = cinema.comments
//        ViewLang.text = cinema.subtitle
//        ViewDate.text = cinema.RelDate
//        ViewSuitable.text = cinema.explicit
        registerForContextMenu(ViewReview)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.ViewReview)
        {
            menu?.add(1, 1002, 1, "Add Review")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==0){
            if(resultCode==Activity.RESULT_OK){
                var userReview = data!!.getStringExtra("movUserReview")
                var userRate= data!!.getFloatExtra("movRate",0.toFloat())
                ViewReview.text =userReview
                ratingStars.rating= userRate
                ratingStars.visibility= View.VISIBLE
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1002)
        {
            val movieTitle = intent.getStringExtra("movName")
            val movieDesc = intent.getStringExtra("movDesc")
            val movieDate = intent.getStringExtra("movDate")
            val movieLang = intent.getStringExtra("movLang")
            val movieSuitable= intent.getStringExtra("movSuitable")

            var ReviewmovieIntent = Intent(this, RatingPage::class.java)
            ReviewmovieIntent.putExtra("movName", movieTitle)
            ReviewmovieIntent.putExtra("movDesc", movieDesc)
            ReviewmovieIntent.putExtra("movDate", movieDate)
            ReviewmovieIntent.putExtra("movLang", movieLang)
            ReviewmovieIntent.putExtra("movSuitable", movieSuitable)
            startActivityForResult(ReviewmovieIntent, 0)
        }
        return super.onContextItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
