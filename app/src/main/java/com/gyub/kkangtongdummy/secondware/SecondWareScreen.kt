package com.gyub.kkangtongdummy.secondware

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gyub.kkangtongdummy.R
import com.gyub.kkangtongdummy.ui.theme.SdsBlue05
import com.gyub.kkangtongdummy.ui.theme.SecondWareTheme

/**
 * 세컨웨어 앱
 *
 * @author   Gyul
 * @created  2023/11/28
 */

@Composable
fun SecondWareScreen() {
    SecondWareTheme {
        CurationTitle()
    }
}

@Composable
fun SecondWareMain() {

}

@Composable
fun CurationItemList() {
//    LazyHorizontalGrid(rows = 2, content =) {
//
//    }
}

@Preview
@Composable
fun CurationItemPreview() {
    CurationItemImage()
}

@Composable
fun CurationItemImage() {
    Card {
        Box {
            val itemImageModifier = Modifier
                .width(174.dp)
                .height(154.dp)

            Image(
                modifier = itemImageModifier,
                contentDescription = "curationItemImage",
                painter = painterResource(id = R.drawable.sds_img_sample_item),
                contentScale = ContentScale.Crop
            )
            val wishIconModifier = Modifier.align(Alignment.BottomEnd)

            Image(
                modifier = wishIconModifier
                    .padding(10.dp),
                painter = painterResource(id = R.drawable.sds_ico_heart_wish_normal_18),
                contentDescription = "wishIcon"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurationTitlePreview() {
    CurationTitle()
}

@Composable
fun CurationTitle() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { showToast(context, "링크 이동") },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
    ) {
        Column {
            Text(text = stringResource(R.string.prefix_curation_title))

            Text(text = getStyledText())
        }

        Text(
            text = stringResource(R.string.view_all)
        )
    }
}

@Composable
fun getStyledText(): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(color = SdsBlue05)) {
            append(stringResource(R.string.national_geographic))
        }
        append(" ")
        append(stringResource(R.string.are_you_looking_for))
    }
}

private fun showToast(context: Context, message: String) {
    Toast
        .makeText(context, message, Toast.LENGTH_SHORT)
        .show()
}