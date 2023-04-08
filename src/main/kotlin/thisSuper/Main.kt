package thisSuper

fun main() {
    var obj1 = TestClass1()
    obj1.testMethod1()

    var obj2 = Subclasss()
    obj2.subMethod1()
}
class TestClass1(var a2:Int){ //주 생성자 정의함
    constructor() : this(100){// 보조 생성자는 주 생성자를 뒤에 무조건 호출해야한다!!

    }

    var a1 = 100
    fun testMethod1(){
        var a1 = 200
        println("a1 : $a1") //메서드에 정의된 변수가 먼저이다.
        println("this.a1 : ${this.a1}") //객체의 멤버변수에 접근하는 것

        fun testMethod2(){
            println("testMethod1 내부의 testMethod2")
        }
        testMethod2()
        this.testMethod2() //클래스에 정의해놓은 메소드 불러옴
    }

    fun testMethod2(){
        println("testMethod2")

    }
}

open class SuperClass(var a2:Int){
    open var a1 = 100

    open fun superMethod1(){
        println("SuperClass 의 superMethod1")
    }

}

class Subclasss : SuperClass(100){
    override var a1 = 1000 //부모클래스에 있는 멤버 변수를 오버라이딩 하겠다 (부모 클래스의 멤버변수에는 open 붙이기)
    fun subMethod1(){
        println("a1 : $a1")
        println("super.a1 : ${super.a1}")

        superMethod1() //오버라이드한 본인의 메소드
        super.superMethod1() //부모 클래스의 메소드 호출
    }

    override fun superMethod1() {
        println("SubClass의 superMethod1")
    }
}

class SubClass2 : SuperClass{
    constructor(a1:Int) : super(a1){ //상속받을 때 부모 생성자를 호출 하지 않으면 보조 생성자로 정의하고 뒤에 :super(부모 생성자 변수)하면 된다.

    }

    constructor(a1:Int,a2: Int) : super(a1){

    }
}