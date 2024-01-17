package net.pangos.ididit.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is new Settings Fragment. Unfortunately it is not yet available."
    }
    val text: LiveData<String> = _text
}