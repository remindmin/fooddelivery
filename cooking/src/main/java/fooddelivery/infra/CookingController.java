package fooddelivery.infra;

import fooddelivery.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/cookings")
@Transactional
public class CookingController {

    @Autowired
    CookingRepository cookingRepository;

    @RequestMapping(
        value = "cookings/{id}/acceptorreject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking acceptOrReject(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptOrRejectCommand acceptOrRejectCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/acceptOrReject  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.acceptOrReject(acceptOrRejectCommand);

        cookingRepository.save(cooking);
        return cooking;
    }

    @RequestMapping(
        value = "cookings/{id}/start",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking start(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/start  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.start();

        cookingRepository.save(cooking);
        return cooking;
    }

    @RequestMapping(
        value = "cookings/{id}/end",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cooking end(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cooking/end  called #####");
        Optional<Cooking> optionalCooking = cookingRepository.findById(id);

        optionalCooking.orElseThrow(() -> new Exception("No Entity Found"));
        Cooking cooking = optionalCooking.get();
        cooking.end();

        cookingRepository.save(cooking);
        return cooking;
    }
}
