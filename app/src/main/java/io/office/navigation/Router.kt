package io.office.navigation

interface Router {
    fun goto(destination: Destination)
    fun setNavigator(navigator: Navigator?)
}