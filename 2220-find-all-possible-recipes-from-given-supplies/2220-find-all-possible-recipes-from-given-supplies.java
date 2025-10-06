import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>(); // ingredient -> list of recipes needing it
        Map<String, Integer> inDegree = new HashMap<>();
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));

        // Initialize inDegree for all recipes
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size());

            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>(supplySet);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String item = queue.poll();

            if (!graph.containsKey(item)) continue;

            for (String dependentRecipe : graph.get(item)) {
                inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);

                if (inDegree.get(dependentRecipe) == 0) {
                    queue.offer(dependentRecipe);
                    result.add(dependentRecipe);
                }
            }
        }

        return result;
    }
}
