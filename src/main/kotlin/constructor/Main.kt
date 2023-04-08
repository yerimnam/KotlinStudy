package constructor

fun main() {
    val obj1 = TestClass1()
    println("obj1 : $obj1")
    println("---------")
    val obj2 = TestClass2()
    println("obj2 : $obj2")
    println("obj2.v1 : ${obj2.v1}")
    println("obj2.v2 : ${obj2.v2}")

    println("-------")
    val obj3 = TestClass2(100,200) //매개변수가 있어서 두개 있는 생성자가 선택된다
    println("obj3.v1 : ${obj3.v1}")
    println("obj3.v2 : ${obj3.v2}")

    println("------------------")
    val obj4 = TestClass3(100,200)
    val obj5 = TestClass4(1000,2000)
    println("obj4.a1: ${obj4.a1}")
    println("obj4.a2: ${obj4.a2}")

    println("obj5.a1: ${obj5.a1}")
    println("obj5.a2: ${obj5.a2}")

    println("--------")
    val obj6 = TestClass5(100,200)
    println("obj6.a1 : ${obj6.a1}")
    println("obj6.a2 : ${obj6.a2}")

    println("----------------")
    val obj7 = TestClass5(100)


}

class TestClass1{

    init {
        println("객체가 생성되면 자동으로 동작되는 부분입니다") //객체 생성시 무조건 작동해야하는 코드 작성 (호출 없이 동작)
    }
}
class TestClass2{
    var v1:Int = 0
    var v2:Int = 0

    constructor(){
        println("매개 변수가 없는 생성자")
    }
    constructor(a1:Int,a2:Int){  //따로 적는건 부생성자
        println("매개 변수가 두개인 생성자")
        v1 = a1
        v2 = a2

    }
}

class TestClass3 constructor(var a1:Int, val a2: Int) //기본생성자의 경우 constructor 생략 가능 ,주 생성자
//생성자를 작성하면 자동으로 멤버 변수,get/set이 작성된다(자바코드로)
class TestClass4 (var a1:Int, val a2:Int)

class TestClass5(var a1:Int,val a2:Int){

    init { //주생성자 먼저 동작 ->init코드 동작
        println("init코드 수행")
        println("a1: $a1")
        println("a2: $a2")
    }

    constructor(a1:Int): this(a1,100){//보조 생성자는 무조건 주 생성자를 호출해야한다 ->this를 쓰면 됨,보조 생성자는 var키워드 사용불가
        println("보조 생성자 호출")
        //값하나만 전달 ->보조 생성자로 동작 ->this의 주생성자 먼저 동작 ->init 코드 동작 ->보조생성자 코드 전달
    } //
}