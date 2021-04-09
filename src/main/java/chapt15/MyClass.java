package chapt15;

public class MyClass extends Thread {
    private String name;
    private MyObject myObj;

    public MyClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }

    public void run() {
        if (name.equals("1")) {
            myObj.foo(name);
        } else {
            myObj.bar(name);
        }
    }
}
