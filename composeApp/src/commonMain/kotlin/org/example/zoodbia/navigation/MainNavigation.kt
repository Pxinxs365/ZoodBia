package org.example.zoodbia.navigation

import org.jetbrains.compose.resources.DrawableResource
import zoodbia.composeapp.generated.resources.Res
import zoodbia.composeapp.generated.resources.*

sealed class MainNavigation(
    val route: String,
    val title: String,
    val selectedIcon: DrawableResource,
    val unselectedIcon: DrawableResource
) {

    data object Shop : MainNavigation(
        route = "Shop",
        title = "Shop",
        selectedIcon = Res.drawable.store_tab,
        unselectedIcon = Res.drawable.store_tab
    )

    data object Explore : MainNavigation(
        route = "Explore",
        title = "Explore",
        selectedIcon = Res.drawable.explore_tab,
        unselectedIcon = Res.drawable.explore_tab
    )

    data object Favourite : MainNavigation(
        route = "Fav",
        title = "Fav",
        selectedIcon = Res.drawable.fav_tab,
        unselectedIcon = Res.drawable.fav_tab
    )

    data object Cart : MainNavigation(
        route = "Cart",
        title = "Cart",
        selectedIcon = Res.drawable.cart_tab,
        unselectedIcon = Res.drawable.cart_tab
    )

    data object Account : MainNavigation(
        route = "Account",
        title = "Account",
        selectedIcon = Res.drawable.account_tab,
        unselectedIcon = Res.drawable.account_tab
    )
}