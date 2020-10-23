package io.office.navigation

import javax.inject.Inject

class RouterImpl @Inject constructor() : Router {

    private var navigator: Navigator? = null

    override fun goto(destination: Destination) {
        navigator?.navigateTo(destination)
    }

    override fun setNavigator(navigator: Navigator?) {
        this.navigator = navigator
    }
}