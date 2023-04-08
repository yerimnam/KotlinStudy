package variable

fun main() {
    //정수 리터럴
    println(100)
    println(10000000000)//자동으로 자바코드로 변환될때 L이 붙어서 안붙여도 됨
    println(10000000000L)//자동으로 자바코드로 변환될때 L이 붙어서 안붙여도 됨
    println(938_492_934_823)//,로 자리수를 구분한것과 같다


//        실수 리터럴
    println(11.11)
    println(22.22)

    //문자 리터럴
    println('A')
    println('가')

    //문자열 리터럴
    println("문자열")

    //논리리터럴
    println(true)
    println(false)

    //Raw String
    println("동해물과 백두산이\n 마르고 닳도록\n 하느님이 보우하사\n 우리나라 만세")
    println("""동해물과 백두산이
        |마르고 닳도록
        |하느님이 보우하사
        |우리나라 만세
    """.trimMargin())

    println("-------------------------------")
//    val a1:Int =100
//    println("a1: ${a1}")
//    println("a1 : $a1") //만약 연산자 없이 변수만 있다고하면 {}생략 가능


    //변수 선언시 자료형을 생략하면 저장하는 값에 따라 결정된다.
    val a2 = 100 //자료형은 생략해도 된다 (반드시 명시해야하는 경우도 있음)
    println("a2 : $a2")

    println("-------------------------------")

    var a3:Int = 100
    val a4:Int = 100

    println("a3 : $a3")
    println("a4 : $a4")

    a3=200
    println("a3 : $a3")

    //val 변수는 값을 다시 저장하지 못한다.
//    a4 = 200

    println("-------------------------------")


    var a5:Int = 100
    var a6:Int ?=null

    println("a5 : $a5")
    println("a6 : $a6")

    var a7:Int ?= a5 //a7은 null값 허용 a5는 null이 아니니 정수값이란 것을 보장함
    println("a7: $a7")

//   var a8:Int = a6!!  // a8은 null을 허용하지 않는 변수 ,a6은 null을 허용하는 변수
    //** !!를 붙이면 null을 허용하는 변수 -> null을 허용하지 않는 변수의 값으로 변환
    //but 실행하면 a6에는 null이 있기 때문에 오류가 발생
    // nullPointerException을 안전하게 처리할 수 있도록 지원한다.

}