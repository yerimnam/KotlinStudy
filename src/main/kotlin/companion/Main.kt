package companion

fun main() {
    val obj1 = TestClass()
    println("obj1.a1 : ${obj1.a1}") //멤버변수값 사용
    obj1.testFun1()//메서드(함수)호출

    val obj2 = TestClass()
    println("obj2.a1 : ${obj2.a1}")
    obj2.testFun1()

    obj1.a1 =200
    println("obj1.a1 : ${obj1.a1}") //200
    println("obj2.a1 : ${obj2.a1}")//100
    //각 객체가 달라서 다르게 관리함

    //companion object는 정적 멤버
    //객체를 생성해서 참조값으로 접근하는 것이 금지 /자바는 가능 ,코틀린 불가능
    // 코틀린 -> 객체를 생성하지 않고 바로 사용 : 클래스명. 함수명(), 클래스명.변수명
//    println("obj1.a2: ${obj1.a2}")
//    obj1.testFun2()
    println("TestClass.a2 : ${TestClass.a2}")
    TestClass.testFun2()

    val obj3 = JavaMain() //자바 객체 생성
    println("obj3.javaA1 : ${obj3.javaA1}")
    obj3.javaMetohd()


    println("JavaMain.javaA2 : ${JavaMain.javaA2}")
    JavaMain.javaMethod2()
}
class TestClass{
    var a1 = 100

    companion object{ //정적 멤버임 //객체 생성전 무조건 메모리상에 만들어져 있는 객체
        //companion object 블록 안에 정의된 변수만 사용 가능, 블록 밖의 변수 메소드는 사용 불가
        var a2 = 1000
        @JvmStatic var a3 =2000 //어노테이션을 붙이면 자바쪽에서 사용할때 companion을 안붙여 도 됨

        fun testFun2(){
            println("testFun2")
//            println("a1:$a1")// a1은 객체를 생성해야 접근 가능, a2는 정적멤버라서 객체 생성하기전에 접근 가능
            //->a2 접근 할때 a1 접근하러면 객체 생성이 안되어 있어서 접근 불가

            println("a2 : $a2")
        }
        @JvmStatic fun testFun3(){
            println("testFun3")
        }
    }
    fun testFun1(){ //모두 사용가능
        println("testFun1")
        println("a1 : $a1")
        println("a2: $a2")
        testFun2()
    }
}