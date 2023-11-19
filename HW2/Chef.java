public class Chef {
    private String name;
    private String specialty;
    private Recipe[] recipes;

    public Chef() {
        name = "Gordon Ramsay";
        specialty = "Lamb Sauce";
        Recipe[] hold = new Recipe[10];
        hold[0] = new Recipe();
        recipes = hold;
    }

    public Chef(String s, String spec, Recipe[] r) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            name = "Gordon Ramsay";
        } else {
            name = s.trim();
        }
        if (spec == null || spec.isEmpty() || spec.isBlank()) {
            specialty = "Lamb Sauce";
        } else {
            specialty = spec.trim();
        }

        if (r.length > 10 || r.length <= 0 || r == null) {
            Recipe[] hold = new Recipe[10];
            hold[0] = new Recipe();
            recipes = hold;
        } else {
            recipes = r;
        }
    }

    public void cook(int index) {
        if (index < 0 || index > 10) {
            System.out.println("What is this nonsense? Get out of my kitchen, I won't make that!");
        }
        if (this.recipes.length <= 0) {
            System.out.println("What is this nonsense? Get out of my kitchen, I won't make that!");
        }
        if (this.recipes[index] == null) {
            System.out.println("What is this nonsense? Get out of my kitchen, I won't make that!");
        } else {
            if (this.specialty.equals(this.recipes[index].getName())) {
                System.out.println("Bon Appetit! Using");
                for (int i = 0; i < this.recipes[index].getIngredients().length; i++) {
                    System.out.println(this.recipes[index].getIngredients()[i].getQuantity() + " grams of "
                        + this.recipes[index].getIngredients()[i].getKind());
                }
                System.out.println("I, " + this.name + ", finished cooking "
                    + this.recipes[index].getName() + " after " + ((this.recipes[index].getPrepTime()) / 2)
                       + " minutes(s). This can serve " + this.recipes[index].getNumServings() + " people.");
            } else {
                System.out.println("Bon Appetit! Using");
                for (int i = 0; i < this.recipes[index].getIngredients().length; i++) {
                    System.out.println(this.recipes[index].getIngredients()[i].getQuantity() + " grams of "
                        + this.recipes[index].getIngredients()[i].getKind());
                }
                System.out.println("I, " + this.name + ", finished cooking " + this.recipes[index].getName() + " after "
                    + this.recipes[index].getPrepTime() + " minutes(s). This can serve "
                        + this.recipes[index].getNumServings() + " people.");
            }
        }
    }

    public void cater(int people) {
        int n = 0;
        for (int i = 0; i < this.recipes.length; i++) {
            if (n == 0 && (this.recipes[i].getNumServings() >= people)) {
                n = 7;
                cook(i);
            }
        }
    }
}