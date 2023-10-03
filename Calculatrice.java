import java.util.Stack;

public class Calculatrice {
    private Stack<Integer> pile;

    public Calculatrice() {
        this.pile = new Stack<>();
    }

    public int evaluerExpression(String expression) {
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (estNombre(token)) {
                pile.push(Integer.parseInt(token));
            } else if (estOperateur(token)) {
                if (pile.size() < 2) {
                    throw new IllegalArgumentException("Erreur : Opération impossible. La pile ne contient pas suffisamment d'opérandes.");
                }

                int operand2 = pile.pop();
                int operand1 = pile.pop();
                int resultat = appliquerOperation(operand1, operand2, token);
                pile.push(resultat);
            } else {
                throw new IllegalArgumentException("Erreur : Opérateur ou opérande invalide : " + token);
            }
        }

        if (pile.size() != 1) {
            throw new IllegalArgumentException("Erreur : L'expression est mal formée.");
        }

        return pile.pop();
    }

    private boolean estNombre(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean estOperateur(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int appliquerOperation(int operand1, int operand2, String operateur) {
        switch (operateur) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Erreur : Division par zéro.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Erreur : Opérateur non pris en charge : " + operateur);
        }
    }

    public static void main(String[] args) {
        Calculatrice calculatrice = new Calculatrice();
        String expression = "3 4 + 2 *";
        int resultat = calculatrice.evaluerExpression(expression);
        System.out.println("Résultat de l'expression : " + resultat);
    }
}
