package `class`

fun main() {
    val obj1 :TestClass1 = TestClass1() //객체 생성, 똑같은 형태면 변수명 뒤의 타입은 생략해도됨
    println("obj1 : $obj1")//해당 객체의 주소값 반환  @dfd3711 -> 메모리상의 주소값은 아니고 똑같은 클래스로 많은 객체를 생성하는데
    //JVM이 각각의 객체를 관리하기 위한 일련번호
    val obj2 = TestClass1()
    println("obj2 : $obj2") //같은 클래스로 만들었지만 다른 객체임

    val obj3 = obj1 //obj1과 같은 객체
    println("obj3 : $obj3")

    val obj4 = TestClass2()
    println("obj4 : $obj4")

    val obj5 = TestClass3()
    println("obj5.a1: ${obj5.a1}") //연산자랑 같이 쓸때는 ${}사용
    println("obj5.a2 : ${obj5.a2}")

//    obj5.a1 = 100
    obj5.a2 =100
    println("obj5.a2 : ${obj5.a2}")


    //메서드호출
    obj5.testMethod1()
    obj5.testMethod2()
}

class TestClass1{

}

class TestClass2 //작성되는게 없으면 {}생략 가능 코틀린은 이렇게 클래스에 코드가 없는 경우가 있다.

class TestClass3{

    //멤버 변수
    val a1 = 0 //readonly
    var a2 =0 //can chnage

    //변수가 만들어지면 set/get 메소드가 자동으로 만들어진다.

    //멤버 메서드 ->클래스안에 작성된 함수 = (멤버) 메서드라고 부른다
    fun testMethod1(){
        println("testMethod1")
    }
    fun testMethod2(){
        println("testMethod2")
    }
}