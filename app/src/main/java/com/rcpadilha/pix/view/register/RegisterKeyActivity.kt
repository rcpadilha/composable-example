package com.rcpadilha.pix.view.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.rcpadilha.pix.ui.PixTheme

class RegisterKeyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixTheme {
               RegisterKeyView(::onSave)
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun onSave() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, RegisterKeyActivity::class.java)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PixTheme {
        RegisterKeyView {}
    }
}