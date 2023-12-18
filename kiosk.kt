package kiosk

open class Kiosk {
    val burgerMenu = ArrayList<AbstractMenu>()
    val iceMenu = ArrayList<AbstractMenu>()
    val drinkMenu = ArrayList<AbstractMenu>()
    val beerMenu = ArrayList<AbstractMenu>()

    fun runKiosk() {
        initKiosk()
    }

    fun menuKiosk(): Int {
        try {
            println("\u001B[35m오신 것을 환영합니다!!\u001B[35m")
            println("\u001B[32m아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\u001B[0m")
            println("\u001B[32m[ Menu ]\u001B[0m")
            println(
                "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" + "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" + "3. Drinks          | 매장에서 직접 만드는 음료\n" + "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" + "0. exit            | 프로그램 종료\n"
            )
            return readln().toInt()
        } catch (e: NumberFormatException) {
            return 9
        }
    }

    fun initKiosk() {
        burgerMenu.add(Hamburger(1, "ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(2, "SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(3, "Shroom Burger", 9400, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"))
        burgerMenu.add(Hamburger(4, "Cheeseburger", 9400, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"))
        burgerMenu.add(Hamburger(5, "Cheeseburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"))
        burgerMenu.add(Hamburger(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        iceMenu.add(Ice(1, "chocolate", 4900, "초콜릿 맛 아이스크림"))
        iceMenu.add(Ice(2, "vanilla", 4900, "바닐라 맛 아이스크림"))
        iceMenu.add(Ice(3, "strawberry", 5400, "딸기 맛 아이스크림"))
        iceMenu.add(Ice(4, "rainbow", 6200, "레인보우 맛 아이스크림"))
        iceMenu.add(Ice(5, "blueberry", 4000, "블루베리 맛 아이스크림"))
        iceMenu.add(Ice(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        drinkMenu.add(Drinks(1, "orange juice", 3900, "상큼한 오렌지 주스"))
        drinkMenu.add(Drinks(2, "ice-tea", 3900, "달콤한 아이스 티"))
        drinkMenu.add(Drinks(3, "tea", 2800, "따뜻한 한잔의 티"))
        drinkMenu.add(Drinks(4, "cola", 3500, "시원함을 느낄 수 있는 콜라"))
        drinkMenu.add(Drinks(5, "coffee", 4800, "온몸이 짜릿해지는 커피 한잔"))
        drinkMenu.add(Drinks(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))

        beerMenu.add(Beer(1, "Pale Ale ", 4900, "풍부한 향의 에일"))
        beerMenu.add(Beer(2, "Larger", 4900, "깔끔함의 극치 라거"))
        beerMenu.add(Beer(3, "Dark Beer", 4800, "매력의 소유자 흑맥주"))
        beerMenu.add(Beer(4, "Cass", 3500, "한국의 대표적인 맥주"))
        beerMenu.add(Beer(5, "Tsingtao", 3800, "중국의 칭따오 맥주"))
        beerMenu.add(Beer(0, "뒤로가기", 0, "다시 메인 메뉴로 이동한다"))
    }
}






