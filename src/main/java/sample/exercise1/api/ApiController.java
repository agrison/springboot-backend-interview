package sample.exercise1.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.exercise1.domain.Meal;

import java.util.Collections;
import java.util.List;

/**
 * What do you think about this REST API ?
 * What would you change ?
 * How can it be improved ?
 */
@RestController
@RequestMapping("/api/v1.337")
public class ApiController {
    @RequestMapping(method = RequestMethod.GET, path = "/get_All_Meals.json")
    public List<Meal> getAllMeals() {
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get_Vegan_Meals.json")
    public List<Meal> getAllVeganMeals() {
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get_Normal_Meals.json")
    public List<Meal> getAllNormalMeals() {
        return Collections.emptyList();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add_A_New_Meal.json")
    public Meal addMeal(@RequestBody Meal meal) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/update_Meal.json")
    public Meal updateMeal(@RequestBody Meal meal) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete_Meal.json")
    public Meal deleteMeal(@RequestBody Meal meal) {
        return null;
    }
}
