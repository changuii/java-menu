package menu.handler;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RetryHandler {
    public <T> T retryUntilNotException(final Supplier<T> logic,
                                        final Consumer<IllegalArgumentException> exceptionCallback) {
        while (true) {
            try {
                return logic.get();
            } catch (final IllegalArgumentException e) {
                exceptionCallback.accept(e);
            }
        }
    }
}
