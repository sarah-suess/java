public class Recipe {
    private String name;
    private int prepTime;
    private int numServings;
    private Ingredient[] ingredients;

    public Recipe() {
        name = "Lamb Sauce";
        prepTime = 60;
        numServings = 8;
        Ingredient[] hold = new Ingredient[10];
        hold[0] = new Ingredient();
        ingredients = hold;
    }

    public Recipe(String s, int p, int n, Ingredient[] ing) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            name = "Lamb Sauce";
            prepTime = p;
            numServings = n;
            ingredients = ing;
        } else {
            name = s;
            prepTime = p;
            numServings = n;
            ingredients = ing;
        }
        if (ing.length > 10 || ing.length <= 0) {
            Ingredient[] hold = new Ingredient[10];
            hold[0] = new Ingredient();
            ingredients = hold;
        }
    }

    public Ingredient dominantIngredient() {
        double initial = this.ingredients[0].getQuantity();
        double max;
        int index = 0;
        for (int i = 0; i < this.ingredients.length; i++) {
            if (this.ingredients[i].getQuantity() > initial) {
                max = this.ingredients[i].getQuantity();
                initial = max;
                index = i;
            }
        }
        return this.ingredients[index];
    }

    public void scaleRecipe(int scale) {
        this.prepTime = this.prepTime * scale;
        this.numServings = this.numServings * scale;
        for (int i = 0; i < this.ingredients.length; i++) {
            double scaled = this.ingredients[i].getQuantity() * 2;
            this.ingredients[i].setQuantity(scaled);
        }
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && !(name.isEmpty()) && !(name.isBlank())) {
            this.name = name;
        }
    }

    public int getPrepTime() {
        return this.prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getNumServings() {
        return this.numServings;
    }

    public void setNumServings(int numServings) {
        this.numServings = numServings;
    }

    public Ingredient[] getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }
}