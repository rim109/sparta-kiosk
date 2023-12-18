package kiosk

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

open class Menus() : AbstractMenu(){
    override fun choose(allMenus: ArrayList<AbstractMenu>): Int {
        var menu = Menus()
        return menu.extracted(allMenus)
    }
// choose을 호출하는 부분이 없고 9~10번까진 흐름이 되진 않지만 이걸 지울 시에 bagList 부분이 호출이 되지 않아서 다시 넣어주었다.. 이번은 이렇게 하되 다른 방법을 고안해봐야겠다.
// 코드 포맷 꾸준히 하기    
    fun extracted(allMenus: ArrayList<AbstractMenu>): Int {
        while (true) {
            try {
                println("\u001B[32m 마실 음료의 메뉴를 골라 숫자를 입력해주세요\u001B[0m")
                for (d in allMenus) {
                    println(d.Number)
                    println(d.Name)
                    println(d.Price)
                    println("-------------------------------------------")
                    println(d.Content)
                    println("-------------------------------------------")
                }
                var Number = readln().toInt()

                if (Number == 0) {
                    println("뒤로 가기를 선택하셨습니다")
                    break
                } else if (Number in (1..5)) {
                    println("${Number} | ${allMenus[Number - 1].Name} | ${allMenus[Number - 1].Price}원 | ${allMenus[Number - 1].Content} | 위 메뉴를 장바구니에 추가하시겠습니까?")
                    println("네 , 아니오")
                    var answer = readln().toString()
                    if (answer == "네") {
                        println("\u001B[32m[ Orders ]\u001B[0m")
                        var bag = "${allMenus[Number - 1].Name} | ${allMenus[Number - 1].Price}"
                        bagList.add(bag)
                        println("${Number} | ${allMenus[Number - 1].Name} | ${allMenus[Number - 1].Price}원 | ${allMenus[Number - 1].Content} |(이/가) 장바구니에 추가되었습니다.")
                        println("----------------------------------------------------------------------------------------------")
                        println("\u001B[32m[ Total ]\u001B[0m ${allMenus[Number - 1].Price}원")

                        println("원하시는 번호를 입력해주세요!")
                        println("1. 지불하기 2. 장바구니 취소")
                        var select = readln().toInt()
                        var bags = "${allMenus[Number - 1].Name} | ${allMenus[Number - 1].Price}"

                        if (select == 2) {
                            bagList.remove(bags)
                            println("취소되었습니다. 감사합니다.")
                            exitProcess(0)
                        } else if (select == 1) {
                            println("지불하기를 선택하셨습니다")
                        } else {
                            println("\u001B[31m잘못된 번호를 입력하셨어요. 처음부터 다시 선택해주세요!\u001B[0m")
                            break
                        }

                        println("지불할 금액을 작성하세요")
                        var myPrice = readln().toInt()
                        myPrice -= allMenus[Number - 1].Price
                        var balance = allMenus[Number - 1].Price
                        var localDateTime: String? =
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))

                        if (myPrice >= Price) {
                            println("\u001B[32m[ Change ]\u001B[0m 거스름돈은 ${myPrice}원 입니다. 감사합니다")
                            println("-------------------------------------------")
                            println("\u001B[43m결제완료\u001B[0m")
                            println(localDateTime.toString())
                        } else {
                            println("총 가격은 ${balance}원 이므로 ${myPrice}원이 부족하여 작성하신 금액으로는 계산할 수 없습니다. 다시 시도해주세요! 감사합니다")
                            exitProcess(0)
                        }

                        println("-------------------------------------------")
                        println("메뉴판을 더 보시겠습니까?!")
                        println("1. 네   2. 아니요")
                        var choice = readln().toInt()
                        try {
                            if (choice == 2) {
                                println("주문해주셔서 감사합니다! 또 찾아와주세요")
                                exitProcess(0)
                            } else 0
                        } catch (e: NumberFormatException) {
                            return 9
                        }
                    } else if (answer == "아니오") {
                        println("다른 메뉴를 선택해주세요.")
                    } else println("\u001B[31m잘못된 입력값을 입력하셨어요. 다시 입력해주세요!\u001B[0m")

                } else println("\u001B[31m잘못된 번호를 입력하셨어요. 다시 입력해주세요!\u001B[0m")
            } catch (e: NumberFormatException) {
                return 9
            }
        }
        return 0
    }
}
