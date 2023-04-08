package property

fun main() {

    val obj1 = TestClass1(100,200)
    println("obj1.a1 : ${obj1.a1}") //언더바 : getter/setter 둘다 세팅되어 있는 프로퍼티
    println("obj1.a2 : ${obj1.a2}")

    obj1.a1 = 1000
    println("obj1.a1 : ${obj1.a1}")

    println("---------")
    val obj2 = TestClass2()

    obj2.v1 = 100
//    obj2.v2 =100 //val로 선언해서 오류 뜸
    println("obj2.a1 : ${obj2.v1}")
    println("obj2.a2 : ${obj2.v2}")

    obj2.v3 =5000
    println("obj2.v3 : ${obj2.v3}")

}

class TestClass1(var a1:Int,val a2:Int){
    //보조 생성자
    constructor( a1:Int, a2:Int,  a3:Int) :this(a1,a2){}
    //var/val 키워드는 주생성자에만 붙일 수 있고 보조 생성자에는 붙일 수 없다.
    //보조 생성자에서 선언한 변수는 멤버 변수로 추가되지 않는다(주 생성자에서 선언한 것만 추가된다)
}

class TestClass2{
    var v1:Int =0
    val v2:Int = 0
    var v3:Int =100
        //        get()=field //field 는 v3변수를 뜻한다
        get() { //gettter메소드로 구성된다.
            println("get호출")
            return field // v3변수를 뜻해서 v3값을 리턴
        }
        set(value) {//매개변수라서 그냥 맘대로
            println("set 호출")
            field = value //매개변수로 들어오는 것을 field로 만들겠다.
        }

}