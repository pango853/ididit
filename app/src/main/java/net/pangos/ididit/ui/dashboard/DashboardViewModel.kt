package net.pangos.ididit.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        // [TODO]
        value = "You have X tasks, and you had completed Y. (Under Construction. Now I am building it)"
    }
    val text: LiveData<String> = _text
}