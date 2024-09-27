package com.example.featherlyspy.ui.composeplayground.basicstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.featherlyspy.R
import com.example.featherlyspy.ui.theme.FeatherlySpyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeatherlySpyTheme {
                WellnessScreen()
            }
        }
    }
}
