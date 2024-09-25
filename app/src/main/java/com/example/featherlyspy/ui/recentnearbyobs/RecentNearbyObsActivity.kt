package com.example.featherlyspy.ui.recentnearbyobs

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.featherlyspy.R
import com.example.featherlyspy.ui.OnboardingScreen
import com.example.featherlyspy.ui.theme.FeatherlySpyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentNearbyObsActivity : ComponentActivity() {

    private val viewModel by viewModels<RecentNearbyObsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.receiveAction(RecentNearbyObsAction.ViewCreated)
//        enableEdgeToEdge()
        setContent {
            FeatherlySpyTheme {
                FeatherlySpApp(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )

                )
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = "Hello!")
                Text(text = name, style = MaterialTheme.typography.headlineMedium)
                if (isExpanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )

                }
            }
            IconButton(
                onClick = { isExpanded = !isExpanded },
            ) {
                Icon(
                    imageVector = if (isExpanded) Filled.ExpandLess else Filled.ExpandMore,
                    contentDescription = stringResource(R.string.app_name)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FeatherlySpyTheme {
        Greeting("Android")
    }
}

@Composable
fun FeatherlySpApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier = modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(
                onContinueClicked = { shouldShowOnboarding = false }
            )
        } else {
            Greetings()
        }
    }
}

@Preview(widthDp = 320)
@Composable
fun FeatherlySpAppPreview() {
    FeatherlySpyTheme {
        FeatherlySpApp(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    Surface(
        modifier = modifier,
    ) {
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                Greeting(name = name)
            }

        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    apiLevel = 31,
    name = "GreetingPreviewDark"
)
@Composable
fun GreetingsPreview() {
    FeatherlySpyTheme {
        Greetings()
    }
}

