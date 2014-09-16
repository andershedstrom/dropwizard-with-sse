package org.ahedstrom.example;

import java.io.IOException;
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
    
    public static void pub(String message) {
        LOG.info("pushing: " + message);
        synchronized(listeners) {
            Iterator<SseEventSource> iterator = listeners.iterator();
            while(iterator.hasNext()) {
                SseEventSource sseEventSource = (SseEventSource)iterator.next();
                try {
                    sseEventSource.emitEvent(message);
                }
                catch(IOException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return;
        System.out.println("unreachable code -_-");
    }
    
    public static void addListener(SseEventSource l) {
        listeners.add(l);
    }
    
    public static void removeListener(SseEventSource l) {
        listeners.remove(l);
    }
}
