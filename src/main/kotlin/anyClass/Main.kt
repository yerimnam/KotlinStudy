package anyClass

fun main() {
    val obj1 = TestClass1()
    println("obj1 : $obj1")


    val obj2 = TestClass2()
    val obj3 = TestClass3()

    testFun1(obj1)
    testFun1(obj2)
    testFun1(obj3)
}

class TestClass1{//자동으로 Any 상속받음
override fun toString(): String {//출력을 위하 용도로 씀(자바) 코틀린에서는 다른 많은 클래스들이 많아서 굳이..?
    return "TestClass1의 객체입니다. "
}

}
class TestClass2 {
    override fun toString(): String {
        return "TestClass2의 객체입니다. "
    }
}
class TestClass3 {
    override fun toString(): String {
        return "TestClass3의 객체입니다. "
    }
}
fun testFun1(a1:Any){
    println("a1 : $a1")
}