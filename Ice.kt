package kiosk

class Ice() : AbstractMenu() {
    constructor(Number: Int, Name: String, Price: Int, Content: String) : this() {
        super.Number = Number
        super.Name = Name
        super.Price = Price
        super.Content = Content
    }

    override fun choose(allMenus: ArrayList<AbstractMenu>): Int {
        var menu = Menus()
        return menu.extracted(allMenus)
    }
}