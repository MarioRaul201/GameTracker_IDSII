package com.example.gametracker.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Recommend
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gametracker.ui.friends.homeFriends.view.HomeFriendsView
import com.example.gametracker.ui.home.homeMain.view.HomeMainView
import com.example.gametracker.ui.login.view.LoginView
import com.example.gametracker.ui.profile.homeProfile.view.HomeProfileView
import com.example.gametracker.ui.progress.homeProgress.view.HomeProgressView
import com.example.gametracker.ui.recommendations.homeRecommendations.view.HomeRecommendationsView

sealed class AppRoute(val route: String, val label: String, val icon: ImageVector) {
    object Home : AppRoute("home", "Inicio", Icons.Filled.Home)
    object Friends : AppRoute("friends", "Amigos", Icons.Filled.Group)
    object Progress : AppRoute("progress", "Progreso", Icons.Filled.SportsEsports)
    object Recommendations : AppRoute("recommendations", "Descubrir", Icons.Filled.Recommend)
    object Profile : AppRoute("profile", "Perfil", Icons.Filled.Person)
}

private val TABS = listOf(
    AppRoute.Home,
    AppRoute.Friends,
    AppRoute.Progress,
    AppRoute.Recommendations,
    AppRoute.Profile
)

@Composable
fun AppNavigation() {
    val rootNavController = rememberNavController()

    NavHost(navController = rootNavController, startDestination = "login") {
        composable("login") {
            LoginView(
                onLoginClick = {
                    rootNavController.navigate("tabs") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("tabs") {
            TabsScaffold(
                onLogout = {
                    rootNavController.navigate("login") {
                        popUpTo("tabs") { inclusive = true }
                    }
                }
            )
        }
    }
}


@Composable
private fun TabsScaffold(
    onLogout: () -> Unit
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                TABS.forEach { tab ->
                    NavigationBarItem(
                        selected = currentRoute == tab.route,
                        onClick = {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(tab.icon, contentDescription = tab.label) },
                        label = { Text(tab.label, fontSize = 10.sp) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppRoute.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppRoute.Home.route) {
                HomeMainView(
                    onLogout = onLogout
                )
            }
            composable(AppRoute.Friends.route) { HomeFriendsView() }
            composable(AppRoute.Progress.route) { HomeProgressView() }
            composable(AppRoute.Recommendations.route) { HomeRecommendationsView() }
            composable(AppRoute.Profile.route) { HomeProfileView() }
        }
    }
}
