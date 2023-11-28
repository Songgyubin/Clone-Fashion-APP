/*
 * Copyright ⓒ 2011 HelloMarket Inc. All Rights Reserved.
 */
package com.gyub.kkangtongdummy.secondware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gyub.kkangtongdummy.ui.theme.SecondWareTheme
import com.gyub.kkangtongdummy.ui.theme.White

/**
 * 세컨웨어 앱
 *
 * @author   Gyul
 * @created  2023/11/28
 */
class SecondWare : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondWareTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = White) {
                    Curation()
                }
            }
        }
    }

    @Composable
    fun Curation() {
        Text(text = "SecondWare")
    }
}