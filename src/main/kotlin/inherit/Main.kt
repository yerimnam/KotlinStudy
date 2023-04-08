package inherit

fun main() {

    val s1 = SubClass1()
    println("s1.subMember1 : ${s1.subMember1}")//멤버 필드 호출
    s1.subMember1() //메서드 호출

    println("s1.superMember1 : ${s1.superMemeber1}")
    s1.superMethod1()
}
open class SuperClass1{//부모 클래스 //매개변수 있는 생성자를 선언하지 않아서 상속받으면 자동으로 매개변수 없는 기본 생성자가 만들어진다 (자바의 개념)

    var superMemeber1 = 100
    fun superMethod1(){
        println("SuperClass1의 메서드 입니다.")
    }
}

class SubClass1 : SuperClass1(){//반드시 부모 생성자를 호출해줘야 한다.
//    constructor():super() //방법2) 이렇게 따로 해줘도 됨
//만약 매개변수 있는 생성자를 선언했다면 안에 매개변수 넣어줘야 함.
val subMember1 =200
    fun subMember1(){
        println("SubClass1의 메서드 입니다.")
    }

}

open class SuperClass2(val a1:Int)//주 생성자 선언(val,val붙이면 됨)

//상속 방법1)
class SubClass2 : SuperClass2(100)//매개변수 있는 생성자를 선언했기때문에 매개변수 없는 기본 생성자는 추가되지 않아서 매개변수를 넣어줘야 한다.
//상속하려면 부모 클래스가 가지고 있는 생성자를 호출해주어야만 상속이 이루어진다.

//상속 방법2)
class SubClass3 : SuperClass2{
    constructor() : super(100)
}