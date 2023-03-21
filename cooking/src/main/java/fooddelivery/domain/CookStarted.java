package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String cookStatus;

    public CookStarted(Cooking aggregate) {
        super(aggregate);
    }

    public CookStarted() {
        super();
    }
}
