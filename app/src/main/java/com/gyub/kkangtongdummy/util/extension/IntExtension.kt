/*
 * Copyright ⓒ 2011 HelloMarket Inc. All Rights Reserved.
 */
package com.gyub.kkangtongdummy.util.extension

import android.content.Context
import com.gyub.kkangtongdummy.R
import java.text.DecimalFormat

/**
 * Int 타입 확장 함수
 *
 * @author   Gyul
 * @created  2023/12/27
 */

/**
 * Long 값을 가격 포맷 (###,###)으로 변경하고, 원화 문자열을 더한 가격을 반환
 * @param context 컨텍스트
 * @param allowZero 0 값을 허용할지 여부를 지정(기본값은 false, false <- 설정할 경우 "0" 값은 빈 문자열로 반환)
 * @return 가격 포맷이 적용된 원화 문자열
 */
fun Int.toFormattedPriceString(context: Context, allowZero: Boolean = false): String {
    if (this == 0 && !allowZero) {
        return ""
    }
    val formatter = DecimalFormat("###,###")
    return context.getString(R.string.won, formatter.format(this))
}

/**
 * null이 아니면 해당 값을 반환하고,
 * 그렇지 않으면 default 값을 반환
 */
fun Int?.orDefault(default: Int = 0) = this ?: default