package access

import access.pkgTest.InternalClass2
import access.pkgTest.PublicClass2
import access.pkgTest.TestClass2
import accessModule.PublicClass3
import accessModule.TestClass3


fun main() { //main ->access모듈에 속함
    //TestFile
    //private class는 외부에서 사용이 불가능,상속 불가능
//    val obj1 = PrivateClass1()
    val obj2 = PublicClass1()
    val obj3 = InternalClass1()

    //TestFile2 ->access모듈에 속함
//    val obj4 = PrivateClass2() //private class는 외부에서 사용이 불가능
    val obj5 = PublicClass2()
    val obj6 = InternalClass2()

    //TestFile3 ->Module모듈에 속함
    //private class는 외부에서 사용할 수 없다
//    val obj7 = PrivateClass3()
    val obj8 = PublicClass3()
    //internal class는 다른 모듈에서는 사용할 수 없다
//    val obj9 = InternalClass3()

    //변수의 접근 제한자
    val t1 =TestClass1()
//    println("t1.private1 : ${t1.private1}") //private 멤버는 사용할 수 없다.
    println("t1.public1 : ${t1.public1}")
//    println("t1.protected1 : ${t1.protected1}") //protected는 상속 관계가 아니므로 사용할 수 없다.
    println("t1.internal1 : ${t1.internal1}") //같은 모듈이므로 사용 가능

    //코틀린에서는 패키지가 같냐 다르냐는 아무런 상관이 없다.
    val t2 = TestClass2()
//    println("t2.private2 : ${t2.private2}")//private 멤버는 사용 불가
    println("t2.public2 : ${t2.public2}")
//    println("t2.protected2 : ${t2.protected2}") //protected 멤버는 상속 관계가 아니므로 사용 불가
    println("t2.internal2 : ${t2.internal2}")


    val t3 = TestClass3() //객체 생성
//    println("t3.private3 : ${t3.private3}")//private 멤버는 사용 불가
    println("t3.public3 : ${t3.public3}")
//    println("t3.protected3 : ${t3.protected3}") //해당 멤버는 상속관계가 아니라서 사용 불가
//    println("t3.internal3 : ${t3.internal3}") // 해당 멤버는 같은 모듈이 아니여서 사용 불가

}

class SubClass1 : TestClass1(){

    fun subMethod1(){
//        println("private 1: $private1") //private 멤버 사용 불가
        println("public1 : $public1")
        println("protected1 : $protected1")
        println("internal1: $internal1")
    }
}

class SubClass2 : TestClass2(){
    fun subMethod2(){
//        println("private 2: $private2") //private 멤버 사용 불가
        println("public2 : $public2")
        println("protected2 : $protected2")
        println("internal2: $internal2")
    }
}

class Subclass3 : TestClass3(){
    fun subMethod3(){
//        println("private 3: $private3") //private 멤버 사용 불가
        println("public3 : $public3")
        println("protected3 : $protected3")
//        println("internal3: $internal3") // 같ㅇ느 모듈이 아니기때문에 사용 불가
    }
}