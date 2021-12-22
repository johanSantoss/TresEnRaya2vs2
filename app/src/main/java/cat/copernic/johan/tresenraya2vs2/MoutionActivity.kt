package cat.copernic.johan.tresenraya2vs2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MoutionActivity : AppCompatActivity() {
    private lateinit var moution : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moution)
        moution = findViewById(R.id.imageView)
        moution.setOnClickListener {
            menuGame()
        }
    }

    private fun menuGame(){
        Toast.makeText(this, "success OnClick!", Toast.LENGTH_LONG).show()
    }
}