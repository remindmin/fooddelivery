package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryConfirmed extends AbstractEvent {

    private Long id;
    private String address;
    private String status;
    private String orderid;

    public DeliveryConfirmed(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryConfirmed() {
        super();
    }
}
