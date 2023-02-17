package lesson21.pattern.proxy;

import java.util.List;

public class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites = List.of("xxx", "pornohub", "xvideos");

    @Override
    public void connectTo(String serverhost) {
        if (bannedSites.contains(serverhost.toLowerCase())) {
            System.out.println("Access Denied to " + serverhost);
        } else {
            System.out.println("Access allowed to " + serverhost);
            internet.connectTo(serverhost);
        }
    }

}
