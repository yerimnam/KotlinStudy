package Interface

fun main() {

    val obj1 = TestClass1()
    val obj2 = TestClass2()
    // 각 객체를 매개면수로 하는 함수 호출
    testFun1(obj1)
    testFun2(obj2)

    println("-----------")
    val obj3 = TestClass3()
    val obj4 = TestClass4()
    testFun3(obj3)
    testFun4(obj4)

    println("-----------")
    val obj5 = TestClass5()
    testFun3(obj5)
    testFun4(obj5)


}

open abstract class AbstarctClass1 {
    open abstract fun abstractMethod1()
}

open abstract  class AbstaractClass2{
    open abstract  fun abstractMethod2()

}

fun testFun1(obj1: AbstarctClass1){//매개변수가 있는 함수
    obj1.abstractMethod1()
}

fun testFun2(obj2: AbstaractClass2){
    obj2.abstractMethod2()
}


class TestClass1 : AbstarctClass1(){ // AbstarctClass1() 상속받음
    override fun abstractMethod1() {
        println("TestClass1의 abstractMethod1")
    }
}

class TestClass2 : AbstaractClass2(){
    override fun abstractMethod2() {
        println("TestClass2의 abstractMethod2")
    }

}


interface Inter1{
    fun inter1Method1(){
        println("Inter1의 interMethod1입니다.")
    }

    fun inter1Method2()
}

interface Inter2{
    fun inter2Method1(){
        println("Inter2의 interMethod1입니다.")
    }
    fun inter2Method2()
}

fun testFun3(obj1 : Inter1){
    obj1.inter1Method1()
    obj1.inter1Method2()
}

fun testFun4(obj2 : Inter2){
    obj2.inter2Method1()
    obj2.inter2Method2()
}

//인터페이스를 구현한 클래스들

class TestClass3 : Inter1{
    override fun inter1Method2() {
        println("TestClass3의 inter1Method2입니다")
    }

}

class TestClass4 : Inter2{
    override fun inter2Method2() {
        println("TestClass4dml inter2Method2입니다.")
    }
}

class TestClass5 :Inter1,Inter2{
    override fun inter1Method2() {
        println("TestClass5의 inter1Method2입니다.")
    }

    override fun inter2Method2() {
        println("TestClass5의 inter2Method2입니다.")
    }
}