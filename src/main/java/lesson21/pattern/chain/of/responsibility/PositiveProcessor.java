package lesson21.pattern.chain.of.responsibility;

public class PositiveProcessor extends AbstractProcessor {

    public PositiveProcessor(AbstractProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(int request) {
        if (request > 0) {
            System.out.println("Last action on PositiveProcessor : " + request);
        } else {
            System.out.print("Transit on PositiveProcessor->");
            super.process(request);
        }
    }
}