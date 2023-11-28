@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.gyub.kkangtongdummy.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gyub.kkangtongdummy.R
import com.gyub.kkangtongdummy.ui.theme.Gray05
import com.gyub.kkangtongdummy.ui.theme.Gray13
import com.gyub.kkangtongdummy.ui.theme.KkangTongDummyTheme
import com.gyub.kkangtongdummy.ui.theme.White


/**
 * MainActivity
 *
 * @author   Gyul
 * @created  2023/11/25
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KkangTongDummyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = White) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    val apps = remember {
        listOf(
            AppViewState("세컨웨어", true),
            AppViewState("Comming Soon", false),
            AppViewState("Comming Soon", false),
            AppViewState("Comming Soon", false),
            AppViewState("Comming Soon", false),
            AppViewState("Comming Soon", false),
            AppViewState("Comming Soon", false),
            AppViewState("Comming Soon", false),
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.title_home),
                            color = Color.White,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }

                },
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            Column {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(3.dp),
                ) {
                    items(apps) { appState ->
                        val backGroundColor = if (appState.isEnable) Gray13 else Gray05
                        Button(
                            onClick = {

                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = backGroundColor),
                            modifier = Modifier
                                .size(100.dp)
                                .padding(10.dp)
                        ) {
                            Text(
                                text = appState.appName,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

data class AppViewState(
    val appName: String = "",
    val isEnable: Boolean = false
)