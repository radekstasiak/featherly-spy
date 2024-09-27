package com.example.featherlyspy.ui.composeplayground.basicstate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    Column(modifier = modifier.padding(4.dp)) {
        if (count > 0) {
            var showTask by rememberSaveable { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today?",
                    onClose = { showTask = false },
                    onChecked = {},
                    checked = false
                )
            }
            Text("You've had $count glasses.")
        }
        Row(modifier = modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text("Add")
            }
            Button(
                onClick = { count = 0 },
                enabled = count > 0,
                modifier = modifier.padding(start = 8.dp)
            ) {
                Text("Clear water count")
            }
        }

    }
}

@Composable
fun StatelessCounter(
    count: Int,
    onCounterIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(4.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Row(modifier = modifier.padding(top = 8.dp)) {
            Button(
                onClick = onCounterIncrement,
                enabled = count < 10
            ) {
                Text("Add")
            }
        }
    }
}

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier
) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(
        count = count,
        onCounterIncrement = { count++ },
        modifier = modifier
    )
}
