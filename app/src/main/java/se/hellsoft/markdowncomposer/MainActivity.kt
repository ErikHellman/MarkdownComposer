package se.hellsoft.markdowncomposer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Box
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.gesture.doubleTapGestureFilter
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import org.commonmark.node.Document
import org.commonmark.parser.Parser
import se.hellsoft.markdowncomposer.ui.MarkdownComposerTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val parser = Parser.builder().build()
        val root = parser.parse(MIXED_MD) as Document
        setContent {
            val (render, setRender) = remember { mutableStateOf(true) }
            MarkdownComposerTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.doubleTapGestureFilter {
                        setRender(!render)
                    }) {
                    Box(paddingStart = 16.dp, paddingEnd = 16.dp) {
                        ScrollableColumn {
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
            color = MaterialTheme.colors.background) {
            Box {
                MDDocument(root)
            }
        }
    }
}