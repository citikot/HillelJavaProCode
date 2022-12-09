package lesson05.builder;

/**
 * @author spasko
 */
public class MainUsePojoAndBuilder {
    public static void main(String[] args) {
        String name = "Hillil";
        String surname = "Academy";
        int old = 3;

        PojoExample pojoExample = new PojoExample(name, surname, old);
        System.out.println("1: " + pojoExample);

        BuilderExample builderExample = BuilderExample.builder()
                .withName(name)
                .withSurname(surname)
                .withOld(old)
                .build();
        System.out.println("2: " + builderExample);
    }
}
