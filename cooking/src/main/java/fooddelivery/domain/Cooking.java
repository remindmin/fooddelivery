package fooddelivery.domain;

import fooddelivery.CookingApplication;
import fooddelivery.domain.Accepted;
import fooddelivery.domain.CookEnded;
import fooddelivery.domain.CookStarted;
import fooddelivery.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String cookStatus;

    @PostPersist
    public void onPostPersist() {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();

        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();

        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

        CookEnded cookEnded = new CookEnded(this);
        cookEnded.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = CookingApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void acceptOrReject(AcceptOrRejectCommand acceptOrRejectCommand) {}

    public void start() {}

    public void end() {}

    public static void cook(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }
}
