package com.gyub.kkangtongdummy.secondwear.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gyub.kkangtongdummy.R
import com.gyub.kkangtongdummy.secondwear.model.CurationItemUiModel
import com.gyub.kkangtongdummy.ui.theme.SdsBlue05
import com.gyub.kkangtongdummy.ui.theme.SecondWearTheme
import com.gyub.kkangtongdummy.util.extension.toFormattedPriceString

/**
 * 세컨웨어 앱
 *
 * @author   Gyul
 * @created  2023/11/28
 */
@Composable
fun SecondWearScreen() {
    SecondWearTheme {
        Surface {
            CurationItemGroup()
        }
    }
}

@Composable
fun SecondWearMain() {

}

@Preview
@Composable
fun CurationItemGroupPreview() {
    CurationItemGroup()
}

@Composable
fun CurationItemGroup() {
    Column {
        CurationTitle(
            Modifier
                .padding(start = 20.dp, bottom = 10.dp)
        )
        CurationItemList()
    }
}

@Preview
@Composable
fun CurationItemListPreview() {
    CurationItemList()
}

@Composable
fun CurationItemList(
    secondWearViewModel: SecondWearViewModel = hiltViewModel()
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(curationCardItemHeight * 2 + 14.dp)
    ) {
        items(secondWearViewModel.curationItem.value.items) {
            CurationCardItem(it)
        }
    }
}

@Composable
fun CurationCardItem(
    item: CurationItemUiModel.ItemUiModel
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(Color.White)
            .width(132.dp)
    ) {
        Box {
            val itemImageModifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .height(132.dp)

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
        Text(
            text = item.title, modifier = Modifier
                .background(Color.White)
                .padding(start = 4.dp)
                .fillMaxWidth()
        )
        Text(
            text = item.price.toFormattedPriceString(context), modifier = Modifier
                .background(Color.White)
                .padding(start = 4.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun CurationTitle(modifier: Modifier) {
    val context = LocalContext.current

    Row(
        modifier = modifier
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

val curationCardItemHeight = 172.dp