package operator

fun main() {
    //단항 연산자 : 항이 하나인 연산자

    // + : 양수 ->양수, 음수 ->음수
    val a1:Int = 10
    val a2:Int = -10

    val r1:Int = +a1
    val r2:Int = +a2

    println("a1: $a1, r1:$r1")
    println("a2: $a2, r2:$r2")

    //- :양수 ->음수 , 음수->양수

    val r3 : Int = -a1
    val r4 : Int = -a2

    println("a1 : $a1,r3:$r3")
    println("a2 : $a2,r4:$r4")

    // !: true->false, false ->true

    val a3:Boolean = true
    val a4 : Boolean = false

    val r5:Boolean =!a3
    val r6: Boolean =!a4


    println("a3 : $a3,r5:$r5")
    println("a4 : $a4,r6:$r6")

}