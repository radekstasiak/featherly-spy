package com.example.featherlyspy.ui.composeplayground.basicstate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.featherlyspy.ui.theme.FeatherlySpyTheme

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()

) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)

        val list = wellnessViewModel.tasks
        WellnessTaskList(
            list = list,
            onCloseTask = { wellnessViewModel.remove(it) },
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(
                    item = task,
                    checked = checked
                )
            }
        )
    }
}

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    onChecked: (Boolean) -> Unit,
    taskName: String,
    checked: Boolean
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            onCheckedChange = onChecked,
            checked = checked
        )
        IconButton(onClick = onClose) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = taskName
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    FeatherlySpyTheme {
        WellnessTaskItem(
            taskName = "task name",
            checked = false,
            onClose = {},
            onChecked = {}
        )
    }
}
