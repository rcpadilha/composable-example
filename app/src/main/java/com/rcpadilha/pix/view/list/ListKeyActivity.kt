package com.rcpadilha.pix.view.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.ui.platform.setContent
import com.rcpadilha.pix.ui.PixTheme
import com.rcpadilha.pix.view.register.RegisterKeyActivity

class ListKeyActivity : AppCompatActivity() {

    private val viewModel by viewModels<ListKeyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixTheme {
                ListKeyView(viewModel = viewModel, onNew = ::openNew)
            }
        }

        viewModel.findKeys()
    }

    private fun openNew() {
        startActivity(RegisterKeyActivity.newIntent(this))
    }
}