package com.rcpadilha.pix.view.list

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.Dimension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rcpadilha.pix.dto.PixKeyDto
import com.rcpadilha.pix.ui.teal200


@Composable
fun ListKeyView(viewModel: ListKeyViewModel, onNew: () -> Unit) {

    val keys: List<PixKeyDto> by viewModel.keys.observeAsState(listOf())

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (listKeys, buttonNew) = createRefs()

        LazyColumnFor(
            items = keys,
            modifier = Modifier.constrainAs(listKeys) {
                top.linkTo(parent.top, 8.dp)
                start.linkTo(parent.start, 8.dp)
                end.linkTo(parent.end, 8.dp)
                bottom.linkTo(buttonNew.top, 8.dp)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            }
        ) {
            ListKeyItem(key = it)
            Divider()
        }

        Button(
            onClick = onNew,
            modifier = Modifier.constrainAs(buttonNew) {
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
                bottom.linkTo(parent.bottom, 16.dp)
                width = Dimension.fillToConstraints
            },
            backgroundColor = teal200
        ) {
            Text(text = "Nova Chave", color = Color.White)
        }
    }

}