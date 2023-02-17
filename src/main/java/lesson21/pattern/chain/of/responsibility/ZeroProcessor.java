package lesson21.pattern.chain.of.responsibility;

public class ZeroProcessor extends AbstractProcessor {
    public ZeroProcessor(AbstractProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(int request) {
        if (request == 0) {
            System.out.println("Last action on ZeroProcessor : " + request);
        } else {
            System.out.print("Transit on ZeroProcessor->");
            super.process(request);
        }
    }
}