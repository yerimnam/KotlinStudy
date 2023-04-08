package basicFunction

fun main() { //함수
    test1() //함수 호출
    test2(100,11.11) //a1:개발도구의 기능

    val k1 : Int =100
    val k2 : Double =11.11
    test2(k1,k2)

    test2(500,55.55)

    test2(a2=66.66,a1=600)//자바와 달리 코들린은 매개변수의 순서가 달라도 됨 a2= , a1= 이렇게 지정되어 있어서 but 굳이 순서를 바꿀 필요 없음


    test3(100,11.11)
    test3(200)
    test3(a2=33.33)

    //기본값이 설정되어있지 않은 함수의 경우 매개변수를 생략하면 오류가 뜸
    //기본값이 설정되어 있는 함수만 매개변수 생략 가능
    val r1:Int =test4(100,200)
    val r2:Int = test4(1000,2000)
    println("r1: $r1")
    println("r2: $r2")
    println("------------------")

    test5()
    test6()


    test7()
    test7(100)
    test7(11.11)
    test7(100,200)

    test8()
//    test9() //함수 안에 들어있는 함수를 외부에서 호출하면 오류 !! 함수안에서만 호출 가능

}

fun test1(){
    println("test1 함수 호출")
    println("------------------------")
}

fun test2(a1:Int,a2:Double){
    println("test2 호출")
    println("a1 : $a1")
    println("a2 : $a2" )
    println("-------------")
}

fun test3(a1:Int=0,a2:Double=0.0){
    println("test3 호출")
    println("a1 : $a1")
    println("a2 : $a2" )
    println("-------------")
}


fun test4(a1:Int,a2:Int) :Int{// : 해당함수의 반환 타입
    val result :Int = a1+a2
    return result
}

fun test5() : Unit{ //Unit = void Unit는 생략 가능/반환타입이 없는 함수
    println("test 5호출")
    println("----------")
}

fun test6(){
    println("test 6호출")
    println("----------")
}

fun test7(){
    println("test7 호출 - 매개변수 없음")
    println("-----------------------")
}

fun test7(a1:Int){
    println("test7 호출 - 매개변수 한개(Int)")
    println("-----------------------")

}

fun test7(a1:Double){
    println("test7 호출 - 매개변수 한개(Double)")
    println("-----------------------")

}

fun test7(a1:Int,a2:Int){
    println("test7 호출 - 매개변수 두개")
    println("-----------------------")
}

fun test8(){
    println("test8 호출")

    fun test9(){
        println("test9 호출")
    }
    test9()
}