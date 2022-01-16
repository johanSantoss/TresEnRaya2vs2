package cat.copernic.johan.tresenraya2vs2.ajustes

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import cat.copernic.johan.tresenraya2vs2.R

class AjustesFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}