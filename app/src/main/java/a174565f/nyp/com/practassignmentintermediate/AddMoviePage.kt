package a174565f.nyp.com.practassignmentintermediate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.add_movie_page.*
import kotlinx.android.synthetic.main.movie_review.*

class AddMoviePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_movie_page)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        AddchkbxNotSuitable.setOnClickListener {
            if (AddchkbxNotSuitable.isChecked == false) {
                AddchkbxLL.visibility = View.INVISIBLE
            }

            else
                AddchkbxLL.visibility = View.VISIBLE

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.movieAddition)
        {
            var chkSuitable = ""
            var violence:String = ""
            var Language:String = ""
            var rbtn = findViewById<RadioButton>(AddrbtnLang.checkedRadioButtonId)
            var ckRBTN = rbtn.text.toString()

            var submit = true

            if (AddchkbxNotSuitable.isChecked) {
                chkSuitable = "No"
            }
            else
                chkSuitable = "Yes"

            if (AddchkbxViolence.isChecked){
                violence = AddchkbxViolence.text.toString()
            }

            if (AddchkbxLanguageUsed.isChecked){
                Language = AddchkbxLanguageUsed.text.toString()
            }

            if (AddMovieName?.text.isNullOrEmpty()) {
                AddMovieName.setError("Field Empty")
                submit = false
            }
            else if (AddMovieDesc?.text.isNullOrEmpty()) {
                AddMovieDesc.setError("Field Empty")
                submit = false
            }
            else if (AddReleaseDate?.text.isNullOrEmpty()) {
                AddReleaseDate.setError("Field Empty")
                submit = false
            }
            else
                submit = true

            var AddmovieIntent = Intent(this, MovieReview::class.java)
            AddmovieIntent.putExtra("movName", AddMovieName.text.toString())
            AddmovieIntent.putExtra("movDesc", AddMovieDesc.text.toString())
            AddmovieIntent.putExtra("movDate", AddReleaseDate.text.toString())
            AddmovieIntent.putExtra("movLang", ckRBTN)
            AddmovieIntent.putExtra("movSuitable", chkSuitable)
            startActivity(AddmovieIntent)

            if (submit == true)
        {
            Toast.makeText(this,
                "Title = " + AddMovieName.text +
                        "\nOverview = " + AddMovieDesc.text +
                        "\nRelease Date = " + AddReleaseDate.text +
                        "\nLanguage = ${rbtn.text}" +
                        "\nSuitable for all ages = " + chkSuitable +
                        "\nReason = " + violence + Language
                ,Toast.LENGTH_SHORT).show()
        }

//            var movName = AddMovieName.text.toString()
//            var movDesc = AddMovieDesc.text.toString()
//            var movDate = AddReleaseDate.text.toString()
//            var movReview = ViewReview.text.toString()
//            var movLang = rbtn.text.toString()
//            val cinema = MovieEntity(movName, movDesc, movLang, movDate, chkSuitable, movReview)




//            AddmovieIntent.putExtra("desc", AddMovieDesc.text.toString())
//            AddmovieIntent.putExtra("date", AddReleaseDate.text.toString())
//            AddmovieIntent.putExtra("name", AddMovieName.text.toString())
//            AddmovieIntent.putExtra("name", AddMovieName.text.toString())

        }

        else if (item?.itemId == R.id.clearEntries)
        {
            AddMovieName.text = null
            AddMovieDesc.text = null
            AddrbtnLang.check(R.id.AddrbtnEng)
            AddReleaseDate.text = null
            AddchkbxNotSuitable.isChecked = false
            AddchkbxLanguageUsed.isChecked = false
            AddchkbxLanguageUsed.visibility = View.GONE
            AddchkbxViolence.isChecked = false
            AddchkbxViolence.visibility = View.GONE
//            if (AddchkbxNotSuitable.isChecked())
//            {
//                AddchkbxNotSuitable.isChecked() == false
//            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
