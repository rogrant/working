public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;

    TerminalImpl() {
        server = new TerminalServer();
        pinValidator = new PinValidator();
    }
}
