package org.example.zoodbia.navigation

import org.jetbrains.compose.resources.DrawableResource
import zoodbia.composeapp.generated.resources.Res
import zoodbia.composeapp.generated.resources.*

sealed class MainNavigation(
    val route: String,
    val title: String,
    val icon: DrawableResource
) {

    data object Shop : MainNavigation(
        route = "Shop",
        title = "Shop",
        icon = Res.drawable.store_tab
    )

    data object Explore : MainNavigation(
        route = "Explore",
        title = "Explore",
        icon = Res.drawable.explore_tab
    )

    data object Favourite : MainNavigation(
        route = "Fav",
        title = "Fav",
        icon = Res.drawable.fav_tab
    )

    data object Cart : MainNavigation(
        route = "Cart",
        title = "Cart",
        icon = Res.drawable.cart_tab
    )

    data object Account : MainNavigation(
        route = "Account",
        title = "Account",
        icon = Res.drawable.account_tab
    )
}