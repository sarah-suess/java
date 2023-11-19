public class Kitchen {
    public static void main(String[] args) {
        Ingredient one = new Ingredient();
        Ingredient two = new Ingredient(3.0, "   pepper");
        Ingredient three = new Ingredient(4.0, "banana");
        Ingredient four = new Ingredient(3.2, "");
        Ingredient five = new Ingredient(0.0, "   ");

        Ingredient[] ingArr = {one, two, three, four, five};
        Ingredient[] ingEmp = {};
        Ingredient[] ingTen = {one, two, three, four, five, one, two, three, four, five, one};

        Recipe six = new Recipe();
        Recipe seven = new Recipe("bread", 6, 9, ingArr);
        Recipe eight = new Recipe("", 4, 2, ingArr);
        Recipe nine = new Recipe("    pasta   ", 64, 1, ingArr);
        Recipe ten = new Recipe("bread", 6, 9, ingEmp);
        Recipe eleven = new Recipe("bread", 6, 9, ingTen);

        Recipe[] recArr = {six, seven, eight, nine, ten, eleven};
        Recipe[] recEmp = {};
        Recipe[] recTen = {six, seven, eight, nine, ten, eleven, six, seven, eight, nine, ten, eleven};

        Chef c1 = new Chef();
        Chef c2 = new Chef("Sarah", "   pasta", recArr);
        Chef c3 = new Chef("    ", "", recEmp);
        Chef c4 = new Chef("Steve", "salad", recTen);
    }
}