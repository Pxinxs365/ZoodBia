package org.example.zoodbia.navigation.navcontroller

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.example.zoodbia.navigation.MainNavigation
import org.example.zoodbia.ui.main.AccountScreen
import org.example.zoodbia.ui.main.CartScreen
import org.example.zoodbia.ui.main.ExploreScreen
import org.example.zoodbia.ui.main.FavouriteScreen
import org.example.zoodbia.ui.main.PrimaryTeal
import org.example.zoodbia.ui.main.ShopScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainNavController() {
    val navigator = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigation(navController = navigator)
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                startDestination = MainNavigation.Shop.route,
                navController = navigator,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = MainNavigation.Shop.route) {
                    ShopScreen()
                }
                composable(route = MainNavigation.Explore.route) {
                    ExploreScreen()
                }
                composable(route = MainNavigation.Favourite.route) {
                    FavouriteScreen()
                }
                composable(route = MainNavigation.Cart.route) {
                    CartScreen()
                }
                composable(route = MainNavigation.Account.route) {
                    AccountScreen()
                }
            }
        }

    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomNavigation(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        )
    ) {
        NavigationBar(
            containerColor = Color.White,
            contentColor = Color.White,
            tonalElevation = 8.dp
        ) {
            val items = listOf(
                MainNavigation.Shop,
                MainNavigation.Explore,
                MainNavigation.Favourite,
                MainNavigation.Cart,
                MainNavigation.Account,
            )

            items.forEach {
                NavigationBarItem(label = {
                    Text(
                        text = it.title,
                        fontSize = 12.sp,
                        color = (if (it.route == currentRoute) PrimaryTeal else Color.Black)
                    )
                },
                    colors = NavigationBarItemColors(
                        selectedIconColor = PrimaryTeal,
                        selectedTextColor = PrimaryTeal,
                        selectedIndicatorColor = Color.Transparent,
                        unselectedIconColor = Color.Black,
                        unselectedTextColor = Color.Black,
                        disabledIconColor = Color.Gray,
                        disabledTextColor = Color.Gray
                    ),
                    selected = it.route == currentRoute,
                    icon = {
                        Icon(
                            painterResource(if (it.route == currentRoute) it.selectedIcon else it.unselectedIcon),
                            it.title,
                            modifier = Modifier.width(24.dp).height(24.dp)
                        )
                    },
                    onClick = {
                        if (currentRoute != it.route) {
                            navController.navigate(it.route) {
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    })
            }
        }
    }
}