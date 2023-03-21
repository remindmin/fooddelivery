package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeliveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Delivery>> {

    @Override
    public EntityModel<Delivery> process(EntityModel<Delivery> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/pickfood")
                .withRel("pickfood")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "/confirmdelivery"
                )
                .withRel("confirmdelivery")
        );

        return model;
    }
}
