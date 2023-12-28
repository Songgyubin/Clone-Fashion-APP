package com.gyub.kkangtongdummy.secondwear.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gyub.kkangtongdummy.secondwear.domain.GetCurationItemsUseCase
import com.gyub.kkangtongdummy.secondwear.model.CurationItemUiModel
import com.gyub.kkangtongdummy.secondwear.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 세컨웨어 뷰모델
 *
 * @author   Gyul
 * @created  2023/12/27
 */
@HiltViewModel
class SecondWearViewModel @Inject constructor(
    private val getCurationItemsUseCase: GetCurationItemsUseCase
) : ViewModel() {

    private val _curationItem = MutableStateFlow<List<CurationItemUiModel>>(listOf())
    val curationItem = _curationItem.asStateFlow()

    init {
        fetchCurationItem()
    }

    /**
     * 상품 큐레이션 가져오기
     */
    private fun fetchCurationItem() {
        viewModelScope.launch {
            getCurationItemsUseCase()
                .collect {
                    _curationItem.value = it.toUiModel()
                    Log.d("TAG", " - :${curationItem.value} ")
                }
        }
    }

}