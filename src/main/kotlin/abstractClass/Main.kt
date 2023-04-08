package abstractClass

fun main() {
//    val obj1 = Super1() //추상클래스는 직ㅈ3ㅓㅂ 객체 생성 안됨
//    testFun1(obj1)

    println("-------------")
    val obj2 = Sub1()
    testFun1(obj2)

    val obj3 = Sub2()
    testFun1(obj3)

}

open abstract class Super1 {
    fun method1(){
        println("Super1의 method1입니다.")
    }

    open abstract fun method2()
}

class Sub1 : Super1(){
    override fun method2() {
        println("Sub1의 method2입니다")
    }
}

class Sub2 : Super1(){
    override fun method2() {
        println("Sub2의 method2입니다")
    }
}
fun testFun1(obj1:Super1){//Super1 타입의 매개변수

    obj1.method1()
    obj1.method2()
}
