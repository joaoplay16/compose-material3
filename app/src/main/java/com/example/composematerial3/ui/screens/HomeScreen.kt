package com.example.composematerial3.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSearchScreen: () -> Unit = {},
    onBottomSheetScreen: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onSearchScreen) {
            Text("Search Screen")
        }
        Button(onClick = onBottomSheetScreen) {
            Text("Bottom Sheet Screen")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    ComposeMaterial3Theme {
        Surface {
            HomeScreen()
        }
    }
}