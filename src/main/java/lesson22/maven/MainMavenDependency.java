package lesson22.maven;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class MainMavenDependency {
    public static void main(String[] args) {
        String source = """
                its a some example of
                multiline string""";
        System.out.println("1: " + StringUtils.capitalize(source));
        System.out.println("2: " + SystemUtils.getUserName());
        System.out.println("3: " + RandomUtils.nextInt(111, 222));
    }
}
