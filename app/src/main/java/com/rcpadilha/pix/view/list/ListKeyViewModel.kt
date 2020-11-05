package com.rcpadilha.pix.view.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rcpadilha.pix.dto.PixKeyDto
import com.rcpadilha.pix.dto.PixKeyType
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListKeyViewModel : ViewModel() {

    private var _keys = MutableLiveData<List<PixKeyDto>>(listOf())
    val keys: LiveData<List<PixKeyDto>> = _keys

    fun findKeys() {
        viewModelScope.launch {
            delay(2000L)
            _keys.postValue(
                listOf(
                    PixKeyDto(PixKeyType.EMAIL, "roberto.padilha@db1.com.br"),
                    PixKeyDto(PixKeyType.CPF, "640.038.690-44"),
                    PixKeyDto(PixKeyType.CNPJ, "53.214.292/0001-21"),
                    PixKeyDto(PixKeyType.PHONE, "(46) 98811-3227"),
                    PixKeyDto(PixKeyType.EVP, "f421d271-5331-4ba9-9dd3-e4e90e2af216"),
                    PixKeyDto(PixKeyType.EVP, "729a7fba-2d3d-4d1f-a3b7-6c9378ca19d5"),
                )
            )
        }
    }

}