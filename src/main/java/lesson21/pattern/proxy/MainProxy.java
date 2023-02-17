package lesson21.pattern.proxy;

public class MainProxy {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();

        internet.connectTo("pornohub");
        internet.connectTo("wiki");
    }
}
