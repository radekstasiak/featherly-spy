package com.example.featherlyspy.ui.recentnearbyobs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.featherlyspy.domain.recentnearbyobs.RecentNearbyObsModel
import com.example.featherlyspy.ui.theme.FeatherlySpyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentNearbyObsActivity : ComponentActivity() {

    private val viewModel by viewModels<RecentNearbyObsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.receiveAction(RecentNearbyObsAction.ViewCreated)
        enableEdgeToEdge()
        setContent {
            FeatherlySpyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecentNearbyObsList(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)

                    )
                }
            }
        }
    }
}


@Composable
fun RecentNearbyObsList(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: RecentNearbyObsViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        LazyColumn(
            modifier = modifier
                .padding(4.dp)
        ) {
            items(
                items = state.recentNearbyObsItems
            ) { model ->
                RecentNearbyObsItem(
                    modifier = modifier,
                    model = model
                )
            }
        }
    }
}

@Preview
@Composable
fun RecentNearbyObsItemPreview(
    modifier: Modifier = Modifier,
) {
    RecentNearbyObsItem(
        model = RecentNearbyObsModel(
            comName = "Common Name",
            sciName = "Scientific Name",
            locId = "Pomerania",
            obsDate = "2024-4-20 19:11"
        )
    )
}

@Composable
fun RecentNearbyObsItem(
    modifier: Modifier = Modifier,
    model: RecentNearbyObsModel
) {
    Row {
        Text(model.comName)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FeatherlySpyTheme {
        RecentNearbyObsList("Android")
    }
}
