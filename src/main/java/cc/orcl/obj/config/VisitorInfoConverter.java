package cc.orcl.obj.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.MDC;

public class VisitorInfoConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String path = MDC.get("requestPath");
        String ip = MDC.get("clientIP");
        return String.format("path=%s, ip=%s", path, ip);
    }
}
