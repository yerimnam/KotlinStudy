package lazyInit

fun main() {
    val obj1 = TestClass1()
    println("obj1.a1 :${obj1.a1 }")
    println("obj1.a2 :${obj1.a2 }")

//    println("obj1.a3 : ${obj1.a3}") // 이건 오류 !! 변수를 사용하기 전에는 반드시 값을 넣어야 함 이건 값 세팅 전에 사용함
    obj1.testMethod1() //값을 세팅하는 메소드를 호출한 뒤 변수를 사용하면 잘 동작된다.

    println("obj1.a4: ${obj1.a4}")
}

class TestClass1{
    var a1:Int = 100 //바로 값을 세팅해서 추론가능해서 생략 가능
    var a2 : Int//자료형 지우면 오류됨 : 변수의 값을 세팅하지 않아서 추론이 불가능해서 오류가 됨 ->반드시 자료형 명시해야한다.
    lateinit  var a3 : String //기본 자료형에는 lateinit을 지원하지 않는다 클래스(참조형) 타입만 가능
    val a4:String by lazy { //a4에는 아무런 값이 들어가있지 않다. ->한번도 사용하지 않으면 값이 메모리를 저장할 수 있다.
        println("a4 init")
        "문자열2" // a4변수를 사용할 때 이 값이 a4에 들어간다.

    }
    init{ //init 블럭 쓰면 오류 사라짐 ,객체가 생성되면 자동으로 생성딘다.
        //코드가 동작된 다음에 얻어진 값을 a2에 넣을 수 있다.
        a2 = 200
    }

    fun testMethod1(){
        if(::a3.isInitialized == false){ // :: ->reflection :객체를 사용할 때 객체와 관련된 클래스와 관련된 것을 사용하기 위해 쓴다
            //해당 객체를 사용한 클래스가 무엇인지, 클래스가 사용한 정보를 알 수 있다.
            //a3가 초기화 된적 있는지 확인 가능
            a3 ="문자열"
        }
        println("a3: $a3")
    }
}