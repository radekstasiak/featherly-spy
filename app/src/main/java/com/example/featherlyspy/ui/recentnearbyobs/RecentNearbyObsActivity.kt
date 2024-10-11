package com.example.featherlyspy.ui.recentnearbyobs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.featherlyspy.R
import com.example.featherlyspy.domain.recentnearbyobs.RecentNearbyObsModel
import com.example.featherlyspy.ui.theme.FeatherlySpyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentNearbyObsActivity : ComponentActivity() {

    private val viewModel by viewModels<RecentNearbyObsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.receiveAction(RecentNearbyObsAction.ViewCreated)
        setContent {
            FeatherlySpyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecentNearbyObsList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun RecentNearbyObsList(
    modifier: Modifier = Modifier,
    viewModel: RecentNearbyObsViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.recent_nearby_obs_list_header),
            style = MaterialTheme.typography.headlineSmall,
            modifier = modifier.padding(bottom = 8.dp)
        )
        LazyColumn(
            modifier = Modifier.testTag("test tag")
        ) {
            items(
                items = state.recentNearbyObsItems
            ) { model ->
                RecentNearbyObsItem(
                    model = model
                )
            }
        }
    }
}

@Composable
fun RecentNearbyObsItem(
    modifier: Modifier = Modifier,
    model: RecentNearbyObsModel
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(bottom = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Column(
                modifier = modifier
                    .weight(1f)
            ) {
                Text(
                    text = model.comName,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = model.sciName,
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier.padding(top = 4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = model.locId,
                            modifier = modifier.size(16.dp)
                        )
                        Text(
                            text = model.locId,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                    Text(
                        text = model.obsDate,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = modifier.padding(start = 4.dp)
                    )
                }
            }
            IconButton(
                onClick = {},
                modifier = modifier
                    .padding()
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = "",

                    )
            }
        }
    }
}


@Preview(showBackground = true)
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

@Preview(showBackground = true)
@Composable
fun RecentNearbyObsListPreview() {
    FeatherlySpyTheme {
        RecentNearbyObsList()
    }
}
