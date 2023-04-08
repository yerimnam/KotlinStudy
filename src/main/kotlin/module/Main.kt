package module

import pkg1.TestClass1
import pkg1.TestClass2
import pkh2.TestClass3
import pkh2.TestClass4

fun main() {
    val obj1 = TestClass1()

    val obj2 = TestClass2()
    val obj3 = TestClass3()
    val obj4 = TestClass4()

    obj1.testMethod1()
    obj2.testMethod2()
    obj3.testMethod3()
    obj4.testMethod4()



}