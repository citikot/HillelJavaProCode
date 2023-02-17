package lesson21.pattern.chain.of.responsibility;

public class Chain {
    private AbstractProcessor highLevelProcessor;

    public Chain() {
        AbstractProcessor lastLayerProcessor = new PositiveProcessor(null);
        AbstractProcessor preLastLayerProcessor = new ZeroProcessor(lastLayerProcessor);
        //...
        highLevelProcessor = new NegativeProcessor(preLastLayerProcessor);
    }

    public void process(int request) {
        highLevelProcessor.process(request);
    }

}