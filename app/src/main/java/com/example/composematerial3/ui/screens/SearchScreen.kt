package com.example.composematerial3.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(modifier) {

        val history = remember {
            mutableStateListOf(
                "Funny Cats",
                "Furniture",
            )
        }

        var active by remember {
            mutableStateOf(false)
        }

        var query by remember {
            mutableStateOf("")
        }

        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            active = active,
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (query.isNotBlank()) {
                        query = ""
                    } else {
                        active = false
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null
                    )
                }
            },
            query = query,
            onQueryChange = {
                query = it
            },
            onActiveChange = {
                active = it
            },
            onSearch = {
                active = false
                history.add(it)
                query = ""
            }
        ) {
            history.forEach {
                Row(
                    modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = CenterVertically
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = null
                        )
                    }
                    Text(text = it)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSearchScreen() {
    MaterialTheme {
        Surface {
            SearchScreen()
        }
    }
}