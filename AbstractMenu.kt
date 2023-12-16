package kiosk

abstract class AbstractMenu {
    abstract fun choose(burgerMenus: ArrayList<AbstractMenu>): Int
    var Number = 0
    var Name = ""
    var Price = 0
    var Content = ""
    val bagList = arrayListOf<String>()
}