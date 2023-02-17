package lesson21.pattern.chain.of.responsibility;

public class MainChainOfResponsibility {
    public static void main(String[] args) {
        Chain chain = new Chain();

        //Calling chain of responsibility 
        chain.process(90);
        chain.process(-50);
        chain.process(0);
        chain.process(91);
    }
}
