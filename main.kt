package kiosk

import kotlin.system.exitProcess

fun main() {
    val kiosk = Kiosk()
    kiosk.runKiosk()

    var menuPan = kiosk.menuKiosk()
    val mainBurger = Hamburger()
    val mainIce = Ice()
    val mainDr = Drinks()
    val mainBe = Beer()

    while (true) {
        when (menuPan) {
            1 -> menuPan = mainBurger.choose(kiosk.burgerMenu)
            2 -> menuPan = mainIce.choose(kiosk.iceMenu)
            3 -> menuPan = mainDr.choose(kiosk.drinkMenu)
            4 -> menuPan = mainBe.choose(kiosk.beerMenu)
            9 -> {
                println("\u001B[31m잘못된 입력값입니다. 처음부터 다시 입력해주세요!\u001B[0m")
                menuPan = kiosk.menuKiosk()
            }

            0 -> {
                println("\u001B[31m프로그램이 종료되었습니다.\u001B[0m")
                exitProcess(0)
            }

            else -> {
                println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
                menuPan = kiosk.menuKiosk()
            }
        }
        if (menuPan == 0) {
            menuPan = kiosk.menuKiosk()
        }
        println(menuPan)
    }
}