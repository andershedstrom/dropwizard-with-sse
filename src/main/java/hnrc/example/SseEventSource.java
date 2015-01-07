package hnrc.example;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.eclipse.jetty.servlets.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SseEventSource implements EventSource {

    private static final Logger LOG = LoggerFactory.getLogger(SseEventSource.class);

    private Emitter emitter;
    private final String id;

    public SseEventSource() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public void onOpen(final Emitter emitter) throws IOException {
        LOG.info("onOpen");
        this.emitter = emitter;
    }

    @Override
    public void onClose() {
        LOG.info("onClose");
        EventPublisher.removeListener(this);
    }

    public void emitEvent(final String dataToSend) throws IOException {
        LOG.info("emitEvent");
        this.emitter.data(dataToSend);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public boolean equals(final Object obj) {
        if(obj instanceof SseEventSource) {
            final SseEventSource that = (SseEventSource)obj;
            return Objects.equals(this.id, that.id);
        }
        return false;
    }
}
