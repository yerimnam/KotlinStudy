package loop

fun main() {
    val a1 = 1..10 //a1은 1~10까지 관리한다

    for(item in a1){ //자바의 foreach문과 비슷한듯..?
        println("a1:$item")
    }

    println("-----------------")
    val a2 = 1..10 step 2
    for(item in a2){
        println("a2 : $item")
    }
    println("------")
//    val a3 = 10..1
    val a3 = 10 downTo 1 //감소하는 값은 downTo
    for(item in a3){
        println("a3 : $item")
    }

    println("--------")

    val a4 = 10 downTo 1 step 2
    for(item in a4){
        println("a4 : $item")
    }

    println("------------------")
    var a5 =0

    while(a5<10){
        println("a5 : $a5")
        a5++
    }

    println("------------")

    var a6 =0
//    var a6 =100
    do{
        println("a6 : $a6")
        a6++
    }while(a6<10)

    for( i in 1..10){
        println("$i 번째: $i")
    }
}

