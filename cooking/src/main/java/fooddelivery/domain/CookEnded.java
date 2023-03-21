package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookEnded extends AbstractEvent {

    private Long id;
    private String orderid;
    private String cookStatus;

    public CookEnded(Cooking aggregate) {
        super(aggregate);
    }

    public CookEnded() {
        super();
    }
}
