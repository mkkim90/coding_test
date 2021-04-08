package chapt13;

public class Child extends Parent {
    private Child() {
    }

    static class Inner {
        private void callPrivateConstructor() {
            new Child();
        }
    }
}
