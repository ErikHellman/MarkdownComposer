package se.hellsoft.markdowncomposer

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.commonmark.node.Document
import org.commonmark.parser.Parser
import se.hellsoft.markdowncomposer.ui.MarkdownComposerTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val parser = Parser.builder().build()
        val root = parser.parse(MIXED_MD) as Document
        setContent {
            var render by remember { mutableStateOf(true) }
            MarkdownComposerTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = {
                                render = !render
                            }
                        )
                    }) {
                    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                            if (render) {
                                MDDocument(root)
                            } else {
                                Text(MIXED_MD)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val parser = Parser.builder().build()
    val root = parser.parse(MIXED_MD) as Document
    MarkdownComposerTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Box {
                MDDocument(root)
            }
        }
    }
}