package cat.copernic.johan.tresenraya2vs2.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {
    // nivel dificultad
    private val _level = MutableLiveData(0)
    val level: LiveData<Int> get() = _level

    fun setLevel (level : Int){
        _level.value = level
    }
}