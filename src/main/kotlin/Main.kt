fun main() {
    println(agoToText(50)) // до минуты
    println(agoToText(30 * 60)) // до часу
    println(agoToText(31 * 60)) // до часу
    println(agoToText(35 * 60)) // до часу
    println(agoToText(2 * 60 * 60)) // до суток
    println(agoToText(5 * 60 * 60)) // до суток
    println(agoToText(21 * 60 * 60)) // до суток
    println(agoToText((1 * 24 + 12) * 60 * 60)) // от суток до двух
    println(agoToText((2 * 24 + 12) * 60 * 60)) // от двух до трех
    println(agoToText((3 * 24 + 12) * 60 * 60)) // больше трех суток
}

fun agoToText(n: Int): String {
    val timeStr: String = when {
        n in 0..60 -> "только что"
        n in 61..60 * 60 ->
            "${n / 60} ${num2PT(n / 60, "минута", "минуты", "минут")} назад"
        n in 60 * 60 + 1..24 * 60 * 60 ->
            "${n / 60 / 60} ${num2PT(n / 60 / 60, "час", "часа", "часов")} назад"
        n in 1 * 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "сегодня"
        n in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "вчера"
        n > 3 * 24 * 60 * 60 -> "давно"
        else -> ""
    }
    return "Был(а) $timeStr"
}

// num2PluralText - "лайк", "лайка", "лайков"

fun num2PT(num: Int, form1: String, form2: String, form3: String): String {
    var number: Int = num % 100
    number = if (number > 19) number % 10 else number
    return when (number) {
        1 -> form1
        2, 3, 4 -> form2
        else -> form3
    }
}