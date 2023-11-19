public class Ingredient {
    private String kind;
    private double quantity;

    public Ingredient() {
        quantity = 0.2;
        kind = "Salt";
    }

    public Ingredient(double q, String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            kind = "Salt";
            quantity = q;
        } else {
            kind = s.trim();
            quantity = q;
        }

        if (quantity <= 0.0) {
            quantity = 0.2;
        }
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        if (kind != null && !(kind.isEmpty()) && !(kind.isBlank())) {
            this.kind = kind;
        }
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        if (quantity <= 0.0) {
            return;
        }
        this.quantity = quantity;
    }

}

