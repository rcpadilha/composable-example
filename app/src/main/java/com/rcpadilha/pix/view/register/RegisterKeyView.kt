package com.rcpadilha.pix.view.register

import android.widget.RadioGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.rcpadilha.pix.dto.PixKeyType

@Composable
fun RegisterKeyView(onSave: () -> Unit) {
    var allKeys = listOf(PixKeyType.CPF, PixKeyType.CNPJ, PixKeyType.PHONE, PixKeyType.EMAIL, PixKeyType.EVP)

    var keyValue by mutableStateOf(TextFieldValue(""))
    var keyType by mutableStateOf(PixKeyType.CPF)

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (inputKey, groupKeyType, buttonSave) = createRefs()

        Column(
            modifier = Modifier.constrainAs(groupKeyType) {
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
                top.linkTo(parent.top, 16.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            allKeys.forEach { pixKeyType ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = { keyType = pixKeyType }),
                ) {
                    RadioButton(
                        selected = keyType == pixKeyType,
                        onClick = { keyType = pixKeyType }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = pixKeyType.toString())
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        if (keyType != PixKeyType.EVP) {
            OutlinedTextField(
                value = keyValue,
                onValueChange = { keyValue = it },
                label = { Text("Valor da Chave") },
                modifier = Modifier.constrainAs(inputKey) {
                    top.linkTo(groupKeyType.bottom, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                }
            )
        }

        Button(
            onClick = onSave,
            modifier = Modifier.constrainAs(buttonSave) {
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
                bottom.linkTo(parent.bottom, 16.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(
                text = "Salvar"
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun RegisterKeyViewPreview() {
    RegisterKeyView {}
}