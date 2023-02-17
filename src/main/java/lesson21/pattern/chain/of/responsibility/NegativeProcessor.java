package lesson21.pattern.chain.of.responsibility;

public class NegativeProcessor extends AbstractProcessor {
    public NegativeProcessor(AbstractProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(int request) {
        if (request < 0) {
            System.out.println("Last action on NegativeProcessor : " + request);
        } else {
            System.out.print("Transit on NegativeProcessor->");
            super.process(request);
        }
    }
}