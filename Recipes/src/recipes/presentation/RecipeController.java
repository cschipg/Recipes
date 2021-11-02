package recipes.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import recipes.business.Recipe;
import recipes.business.RecipeService;

import javax.validation.Valid;

@RestController
public class RecipeController {

    final RecipeService recipeService;

    RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/api/recipe/new")
    Object make(@Valid @RequestBody Recipe recipe) {

        Recipe savedRecipe = recipeService.save(recipe);

        return String.format("{\"id\": %d}", savedRecipe.getId());
    }

    @GetMapping("/api/recipe/{id}")
    Recipe get(@PathVariable long id) {

        return recipeService.findRecipeById(id);

    }

    @DeleteMapping("/api/recipe/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable long id) {

        recipeService.deleteById(id);

    }


}
