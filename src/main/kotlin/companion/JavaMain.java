package companion;

public class JavaMain {

    public int javaA1 = 100;

    public static int javaA2 = 200;

    public void javaMetohd(){
        System.out.println("JavaMethod1");
    }

    public static void javaMethod2(){
        System.out.println("javaMethod2");
    }

    public static void main(String[] args) {
        TestClass t1 = new TestClass();
        System.out.printf("t1.a1 : %d\n",t1.getA1()); //코틀린 멤버변수 호출
        t1.testFun1(); //코틀린 메소드 호출

        //w정적멤버 호출
        System.out.printf("TestClass.a2 :%d\n ",TestClass.Companion.getA2());
        TestClass.Companion.testFun2();

        //코틀린에서 정적 멤버에 @JVMStatic을 붙였을 경우
        System.out.printf("TestClass.a3 : %d\n",TestClass.getA3());
        TestClass.testFun3();
    }
}
