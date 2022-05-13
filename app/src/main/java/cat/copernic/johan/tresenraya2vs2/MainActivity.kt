package cat.copernic.johan.tresenraya2vs2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var myLevel : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun setLevel(level: Int){
        myLevel = level
    }

    fun getLevel() : Int {
        return myLevel;
    }

    fun setAndGetLevel(level: Int) : Int{
        myLevel = level
        return myLevel;
    }
}