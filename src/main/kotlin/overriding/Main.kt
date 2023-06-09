package overriding

fun main() {
    val obj1 : SubClass1 = SubClass1() //자식 객체
    println("obj1.subA1 : ${obj1.subA1}")
    obj1.subMethod1()
    println("obj1.superA1 : ${obj1.superA1}") //부모로부터 상속받은 메소드 (부모 클래스에 정의된 메소드도 자식 객체에서 사용가능)
    obj1.superMethod1()


    println("-------------")
    val obj2 :SuperClass1 = obj1 // obj2 = 자식클래스 형 obj1 = 부모 객체
    // SuperClass1 obj2 = obj1 -> SupcerClass1 obj2  = (SuberClass1) obj2 로 자동 형변환 됨
    //자식클래스 변수를 부모 클래스 변수에 담음 => obj2는 부모 클래스형이므로 자식클래스 메소드 및 변수에는 접근할 수 없다.

    println("obj2.superA1 : ${obj2.superA1}")
    obj2.superMethod1()

//    println("obj2.subA1 : ${obj2.subA1}")
//    obj2.subMethod1()

    println("-----------------")

    val obj3 :SubClass2 = SubClass2()
    obj3.superMethod2()


    val obj4 :SuperClass2 =obj3 // 부모 객체 변수명 = 구현객체
    //자식 클래스에서 오버라이딩한다면 오버라이딩한 메서드가 실행된다
    obj4.superMethod2()

    println("-------------")

    val obj5:SuperClass3 = SuperClass3()
    overridingTest(obj5)

    val obj6:SubClass3 = SubClass3()
    overridingTest(obj6) //상속 받아서 자식 클래스도 매개변수로 넣을 수 있다.
}

open class SuperClass1{ //부모클래스

    var superA1 = 100

    fun superMethod1(){
        println("SuperClass의 superMethod1입니다")
    }
}

class SubClass1 : SuperClass1(){
    var subA1 = 200
    fun subMethod1(){
        println("SubClass1의 subMethod1입니다.")
    }
}

open class SuperClass2{

    open fun superMethod2(){ //메서드에 open을 쓰면 자식 클래스에서 오버라이드할 수 있다.,(재정의 할수 있다.)
        println("SuperClass2의 superMethod2")
    }
}

class SubClass2 : SuperClass2(){
    override fun superMethod2() {
        println("SubClass2의 superMethod2")
    }
}


open class SuperClass3{
    open fun superMethod3(){
        println("SuperClass3의 superMethod3")
    }
}

class SubClass3 :SuperClass3() {
    override fun superMethod3() {
        super.superMethod3()
        println("SubClass3의 superMethod3")
    }

}
fun overridingTest(obj1 : SuperClass3){
    obj1.superMethod3()
}