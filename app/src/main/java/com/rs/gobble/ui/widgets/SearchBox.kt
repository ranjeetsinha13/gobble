package com.rs.gobble.ui.widgets

import androidx.compose.Composable
import androidx.compose.State
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.EditorModel
import androidx.ui.core.TextField
import androidx.ui.core.dp
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.layout.FlexRow
import androidx.ui.layout.Padding
import androidx.ui.layout.Row
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Card
import androidx.ui.text.TextStyle

import androidx.ui.tooling.preview.Preview
import com.rs.gobble.R
import com.rs.gobble.ui.VectorImage

@Composable
@Preview
fun searchForm(hintText: String = "") {

    MaterialTheme {
        Row(
            modifier = Spacing(left = 8.dp, right = 8.dp)
        ) {
            Card(
                shape = RoundedCornerShape(10.dp), border = Border((+MaterialTheme.colors()).primaryVariant, 2.dp)
            ) {
                Row {
                    Padding(8.dp) {
                        VectorImage(id = R.drawable.ic_search_24px, tint = Color.DarkGray)
                    }
                    // TODO Find a way to give hint text
                    val state = +state { EditorModel(hintText) }
                    Padding(8.dp) {
                        FlexRow {
                            flexible(1f) {
                                SingleLineEditText(
                                    state,
                                    onImeActionPerformed = {
                                        state.value.text
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SingleLineEditText(
    state: State<EditorModel>,
    onImeActionPerformed: (ImeAction) -> Unit = {
    }
) {

    TextField(
        value = state.value,
        onValueChange = { new ->
            state.value = if (new.text.any { it == '\n' }) {
                state.value
            } else {
                new
            }
        },
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Search,
        textStyle = TextStyle(color = Color.DarkGray),
        onImeActionPerformed = onImeActionPerformed
    )
}
