import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.*

class HomeTab : Screen {

    @OptIn(InternalVoyagerApi::class)
    @Composable
    override fun Content() {


        TabNavigator(HomeTabItem, tabDisposable = {
            TabDisposable(
                it,
                listOf(HomeTabItem, HomeTabSettings)
            )
        }) {
            Scaffold(
                WindowInsets(0.dp),
                /*topBar = {
                    TopAppBar(title = {
                        Text(it.current.options.title)
                    })
                },*/
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(HomeTabItem)
                        TabNavigationItem(HomeTabSettings)
                    }
                },
                content = {
                    CurrentTab()
                }
            )
        }


    }


    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current

        BottomNavigationItem(
            selected = tabNavigator.current.key == tab.key,
            onClick = { tabNavigator.current = tab },
            icon = {
                Icon(
                    painter = tab.options.icon!!,
                    contentDescription = tab.options.title
                )
            }
        )
    }
}

