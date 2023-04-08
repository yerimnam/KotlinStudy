package packages

import packages.pkg1.TestClass2
import packages.pkg1.testFunction2
import packages.pkg2.TestClass3
import packages.pkg2.TestClass4


fun main() {

    val obj1 :packages.pkg1.TestClass1 = packages.pkg1.TestClass1()

    obj1.testMethod1()

    packages.pkg1.testFunction1()

//    val obj2 :TestClass2 : TestClass2()//타입은 생략 가능
    val obj2 : TestClass2 = TestClass2()
    obj2.testMethod2()

    testFunction2()

    val obj3 = TestClass3()
    val obj4 = TestClass4()

    obj3.testMethod3()
    obj4.testMethod4()
}