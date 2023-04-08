package InnerClass

fun main() {

    val obj1 = Outer1()
    val obj2 = obj1.Inner1() //외부 객체 생성 후 중첩 클래스 객체 생성가능
    obj2.innerMethod2()
    obj1.outerMethod2()

    println("------------------")
    val t1 = TestClass2()
    t1.testMethod1()

    val t2 = TestClass3()
    t2.interMethod1()

    //익명 중첩 클래스 사용하기
    //->추상클래스를 이름이 없는 클래스가 상속받고 객체 생성하면서 바로 메소드오버라이딩함
    val t3 = object : TestClass1() { //추상 클래스(부모)
        override fun testMethod1() {
            println("익명 중첩 클래스의 testMetohd1")
        }

    }
    t3.testMethod1()

    val t4 = object : TestInter1 { //인퍼테이스
        override fun interMethod1() {
            println("익명 중첩클래스의 interMethod1")
        }
    }
    t4.interMethod1()
}

class Outer1{
    val outerMember1 = 100
    fun outerMethod1(){
        println("Outer Method")
    }
    fun outerMethod2(){
//        println("innerMember1 : $innerMember1") //오류
//        innerMethod1() //오류
        val obj3 = Inner1()
        println("obj3.innerMember1 : ${obj3.innermember1}")
        obj3.innerMethod1()
    }
    inner class Inner1{ //중첩 클래스
        val innermember1 =200
        fun innerMethod1(){
            println("Inner Method")
        }

        fun innerMethod2(){
            println("outerMember1 : $outerMember1")
            outerMethod1()
        }
    }


}

abstract class TestClass1{
    abstract fun testMethod1()
}

interface  TestInter1{
    fun interMethod1()
}
class TestClass2 : TestClass1(){
    override fun testMethod1() {
        println("TestClass2의 testMethod1")
    }
}

class TestClass3 : TestInter1{
    override fun interMethod1() {
        println("TestClass3의 Intermethod1")
    }
}