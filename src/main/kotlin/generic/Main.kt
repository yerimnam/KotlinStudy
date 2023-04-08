package generic

fun main() {
    val t1 = TestClass1<Int>() //여기 객체는 정수현 객체
    t1.testMethod1(100)

    val t2 =  TestClass1<String>() //스트링 타입의 객체
    t2.testMethod1("문자열")
    println("------------------------")
    val t3 = TestClass2<Int>(100)
    t3.testMethod2(200)

    val t4 = TestClass2<String>("문자열1")
    t4.testMethod2("문자열2")

    println("--------------")
    //제네릭은 여러개 설정할 수 있다.
    val t5 = TestClass3<Int,String>()
    t5.testMethod3(100,"문자열")


    val t6 = TestClass4<Int,Double,String,Boolean>(100,11.11)
    t6.testMethod4("문자열",true)


    println("-------------------")
    var t7 : TestClass5<SubClass1> = TestClass5<SubClass1>()
    //서로 상속 관계 있더라도 서로 다른 제네릭 타입의 변수에 값을 담을 수 없다. ->불변성
    //무조건 같은 제네릭 타입의 변수에만 값을 넣을 수 있다.
//    val t8 :TestClass5<SubClass2> = TestClass5<SubClass1>()
//    val t9 :TestClass5<SuperClass1> = TestClass5<SubClass1>()

    //공변성
    // out 키워드, 부모 클래스 참조형의 변수에 담을 수 있다.
    val t10 : TestClass6<SubClass1> = TestClass6<SubClass1>()//자기 자신과 같은 제니릭 타입은 무조건 가능
//    val t11 : TestClass6<SubClass2> = TestClass6<SubClass1>() //자식 클래스 참초졓에 닮을 수 없음
    val t12 :TestClass6<SuperClass1> = TestClass6<SubClass1>() //out을 붙이면 <SubClass1>의 부모 타입임<SuperClass1>의 타입을 가지는 변수에 값을 넣을 수 있다.

    //반 공변성
    //in 키워드, 자식 클래스 참조형의 변수에 담을 수 있다.
    val t13 :TestClass7<SubClass1> = TestClass7<SubClass1>()
    val t14 : TestClass7<SubClass2> = TestClass7<SubClass1>() //자식 클래스 참조형에 담을 수 있다.
//    val t15  : TestClass7<SuperClass1>= TestClass7<SubClass1>()
}

//객체마다 타입이 달라진다.
class TestClass1<T>{  //<T> 제네릭으로 선언 글래스를 만들 때 자료형을 결정하지 않음
    fun testMethod1(a1:T){ //메소드도 int가 된다 (매개변수가 int형이라서)

        println("a1 : $a1")
    }
}

class TestClass2<T>(var a1:T){ //매개변수 1개인 생성자를 호출하여 객체 생성
    fun testMethod2(a2:T){
        println("a1 : $a1")
        println("a2 : $a2")
    }
}

class TestClass3<A,B>{ //생성자 정의 안함 = 객체 생성하면 매개변수 없는 생성자가 자동으로 ㅁ나들어짐

    fun testMethod3(a1:A,a2:B){
        println("a1 : $a1")
        println("a2 : $a2")
    }
}

//주생성자 있는 클래스
class TestClass4<A,B,C,D>(var a1:A, var a2:B){

    fun testMethod4(a3:C,a4:D){
        println("a1 : $a1")
        println("a2 : $a2")
        println("a3 : $a3")
        println("a4 : $a4")
    }
}

open class SuperClass1

open class SubClass1 : SuperClass1()

class SubClass2 : SubClass1()


//불변성
class TestClass5<A>()

//공변성
class TestClass6<out A>()

//반 공변성 ->자식 클래스형 참조 변수에 담게 된다면 자식 클래스에 있는 메소드를 사용할 수 없음 (형변환 이해하면됨)
//->객체를 자식 클래스형 변수에 담아서 쓰는 것은 안전장치가 필요하다.
class TestClass7<in A>()