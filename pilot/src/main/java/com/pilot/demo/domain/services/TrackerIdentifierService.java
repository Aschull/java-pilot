package com.pilot.demo.domain.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pilot.demo.domain.interfaces.TrackerIdentifierInterface;
import com.pilot.demo.infrastructure.rabbitmq.RabbitMQPublisher;

@Service
@Scope("prototype")
public class TrackerIdentifierService implements TrackerIdentifierInterface {
    private String rawMessage;
    private List<String> identified = new ArrayList<>();
    
    @Autowired
    private RabbitMQPublisher publisher;

    public String getRawMessage() {
        return this.rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public List<String> getIdentified() {
        return this.identified;
    }

    public void setIdentified(List<String> identified) {
        this.identified = identified;
    }

    public TrackerIdentifierService(String rawMessage, RabbitMQPublisher publisher) {
        this.rawMessage = rawMessage;
        this.publisher = publisher;
    }

    public List<String> identifier() {

        // setRawMessage("POS;FOX23;001;-0;-0");

        String[] data = getRawMessage().split(";");

        String kind = data[0];
        String model = data[1];
        // String deviceId = data[2];
        // String lat = data[3];
        // String lon = data[4];

        ArrayList<String> identified = new ArrayList<>();
        identified.add(rawMessage);
        identified.add(kind);
        identified.add(model);

        setIdentified(identified);

        return identified;
    }

    public void orchestrator() {
        List<String> data = getIdentified();

        Date dateNow = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String dateTimeNow = formato.format(dateNow);
        
        String rabbitMessage = data.get(0).trim().concat("BREAK").concat(data.get(1)).concat("BREAK").concat(dateTimeNow);
        switch (data.get(2)) {
            case "FOX23":
                MessageHandlerService messageHandler = new MessageHandlerService(rabbitMessage);
                messageHandler.handlerToRabbitMQ(this.publisher);

                break;
            case "RABBIT12":
                break;
        
            default:
                break;
        }
    }
}