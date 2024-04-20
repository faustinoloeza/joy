import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class Login : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column {
            Button(onClick = {
                navigator.push(Home())
            }) {
                Text("to Home")
            }
            Button(onClick = {
                navigator.push(HomeTab())
            }) {
                Text("to HomeTAB")
            }
            ListComposable(myList = listOf("Item 1", "Item 2", "Item 3"))
        }
    }

}


@Composable
fun ListComposable(myList: List<String>) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Column {
            for (item in myList) {
                Text("Item: $item")
            }
        }
        Text("Count: ${myList.size}")
    }
}