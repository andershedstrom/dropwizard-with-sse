package hnrc.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventPublisher {
    private static final Logger LOG = LoggerFactory.getLogger(EventPublisher.class);
    private static List<SseEventSource> listeners = Collections.synchronizedList(new ArrayList<SseEventSource>());

    public static void pub(final String message) {
        LOG.info("pushing: " + message + " :-O");
        synchronized(listeners) {
            final Iterator<SseEventSource> iterator = listeners.iterator();
            while(iterator.hasNext()) {
                final SseEventSource sseEventSource = iterator.next();
                try {
                    sseEventSource.emitEvent(message);
                }
                catch(final IOException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return;
    }

    public static void addListener(final SseEventSource l) {
        listeners.add(l);
    }

    public static void removeListener(final SseEventSource l) {
        listeners.remove(l);
        // whatever
    }
}
