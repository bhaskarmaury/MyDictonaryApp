package com.example.mydictonaryapp.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydictonaryapp.model.DictionaryData
import com.example.mydictonaryapp.model.RetrofitInstance
import kotlinx.coroutines.launch

class DictionaryViewModel: ViewModel() {
    var isLoading by mutableStateOf(value = false)
    private set
    var wordData by mutableStateOf<DictionaryData?>(value = null)
        private set
    fun searchWord(word: String){
        if(word.isBlank()) return
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitInstance.api.getWordMeaning(word)
                wordData = response.firstOrNull()
            }catch (e:Exception){
                wordData = null
            }
            isLoading = false

        }
    }
}