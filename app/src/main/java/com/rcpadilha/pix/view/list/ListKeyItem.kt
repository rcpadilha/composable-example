package com.rcpadilha.pix.view.list

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.rcpadilha.pix.dto.PixKeyDto
import com.rcpadilha.pix.dto.PixKeyType

@Composable
fun ListKeyItem(key: PixKeyDto) {

    Column(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Text(
            text = key.type.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = key.value,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ListKeyItemPreview() {
    ListKeyItem(PixKeyDto(PixKeyType.EVP, "729a7fba-2d3d-4d1f-a3b7-6c9378ca19d5"))
}