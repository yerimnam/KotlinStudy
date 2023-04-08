package dataClass

fun main() {

    val obj1 = TestClass1(100,200)
    val obj2  = TestClass2(100,200)

    println("obj1.a1 : ${obj1.a1}")
    println("obj1.a2 : ${obj1.a2}")

    println("obj2.a1 : ${obj2.a1}")
    println("obj2.a2 : ${obj2.a2}")

    //보조 생성자로 객체 생성
    val obj3 = TestClass1(100,200,300)
    val obj4 = TestClass2(100,200,300)
    println("obj3.a1 : ${obj3.a1}")
    println("obj3.a2 : ${obj3.a2}")
    println("obj3.a3 : ${obj3.a3}")

    println("obj4.a1 : ${obj4.a1}")
    println("obj4.a2 : ${obj4.a2}")
    println("obj4.a3 : ${obj4.a3}")

    obj3.testMethod1()
    obj4.testMethod2()

    //-----------------------------메서드
    println("---------------")
    var obj5 = TestClass1(100,200,300)
    var obj6 = TestClass1(100,200,300)
    if(obj5 == obj6){
        println("obj5 와 obj6은 같은 객체 입니다.")
    }else {
        println("obj5 와 obj6은 다른 객체 입니다.")
        //두 객체의 각각 주소값을 비교함 ->주소값이 다르다
    }

    //코틀린은 연산자를 그대로 수정하는게 아니라 관련된 메소드를 호출한다.
    //그래서 위의 내용과 다르다.

    var obj7 = TestClass2(100,200,300)
    var obj8 = TestClass2(100,200,300)
    if(obj7 == obj8){ //equals()를 자동으로 호출하여 그 결과값을 자동으로 반환
        //TestClass1에는 equlas()가 정의 되어 있지 않음-> 그래서 Any를 상속받는데 Any의 equals()는 주소값을 비교
        //data class로 만드면 equlas()오버라이드 되어 있는데  주생성자에 있는 변수로만 값을 비교하는 구조로 되어 있다
        //->두객체가 관리하고 있는 값들이 같은지 비교한다.
        println("obj7과 obj8은 같은 객체입니다.")
    }else {
        println("obj7과 obj8은 다른  객체입니다.")

    }

    println("--------------")
//    val obj9 = obj5.copy() //TestClass1은 일반 클래스라서 copy()가 구현되어 있지 않음
    val obj10 = obj7.copy() //주 생성자에 정의되어 있는 멤버로만 복제 그래서 a3는 복제 되지 않음
    //copy()를 쓸 때는 모든 멤버를 주 생성자로 적의해주어야 한다.
    println("obj10.a1 : ${obj10.a1}")
    println("obj10.a2 : ${obj10.a2}")
    println("obj10.a3 : ${obj10.a3}")

    //복제한 객체는 다른 객체로 취급하기 떄문에 한 곳에 값을 세팅해도 다른 객체는 영향을 받지 않음
    obj10.a1 = 1000
    println("obj7.a1 : ${obj7.a1}")
    println("obj10.a1 : ${obj10.a1}")

    println("-------------------")

    val str1  = obj5.toString()
    val str2 =obj7.toString()
    println("str1 : $str1")//일반 글래스
    println("str2 : $str2")//data class ,주 생성자에 정의한 변수값만 나온다.. ,Any의 toString을 오버라딩함

    println("------------------")

    //자바 디컴파일 확인
    val num1 = obj7.component1() //component1(1은 a1을 반환
    val num2 = obj7.component2()//component2()은 a2을 반환
    println("num1 : $num1")
    println("num2 : $num2")

    //하지만 바로 참조값에서 멤버변수 접근해서 쓰면 된다 굳이..?
//    obj7.a1 이런식으로

    println("-----------")
    var obj11 = TestClass3(100,200,300)
    val num3 = obj11.component1()
    val num4 = obj11.component2()
    val num5 = obj11.component3()

    println("num3 : $num3")
    println("num4 : $num4")
    println("num5 : $num5")

    println("----------------")
    //하지만 component()는 객체분해와 관련이 있다
    //주생성자 기준으로 작성한다.
    val(num10,num11) = obj7
    //obj7 의 a1 =>num10에 a2 => num11에 들어간다.
    //int num10 = obj7.component1();이런식으로 자바 코드로 변환된다
    println("num10 : $num10")
    println("num11 : $num11")

    val (num12,num13,num14) = obj11
    println("num12: $num12")
    println("num13: $num13")
    println("num14: $num14")
}

class TestClass1(var a1: Int, var a2:Int){
    var a3 : Int = 0
    init {
        println("TestClass1의 init")
    }

    constructor(a1:Int,a2:Int,a3:Int) : this(a1,a2){
        this.a3 = a3
    }

    fun testMethod1(){
        println("TestClass1의 testMethod1입니다.")
    }
}
data class TestClass2(var a1 : Int, var a2 : Int){
    var a3: Int =0

    init {
        println("TestClass2의 init")
    }
    constructor(a1:Int,a2: Int,a3:Int) : this(a1, a2){
        this.a3 = a3
    }
    fun testMethod2(){
        println("TestClass2의 testMethod2입니다.")
    }
}

data class TestClass3(var a1:Int, var a2: Int, var a3: Int) //주 생성자에 정의한 멤버 변수 갯수 만큼 component() 가 생성됨