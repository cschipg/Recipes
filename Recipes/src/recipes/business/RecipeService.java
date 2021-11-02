package recipes.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.persistence.RecipeRepository;

@Service
public class RecipeService {

    final RecipeRepository recipeRepository;

    @Autowired
    RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe findRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Can not find this. try again. this is a 404"));
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteById(Long id) {
        Recipe recipe = findRecipeById(id);
        recipeRepository.delete(recipe);
    }


}
