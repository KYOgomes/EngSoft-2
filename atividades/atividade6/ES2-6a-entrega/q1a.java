// Pizzaria: A fábrica abstrata. Ela é responsável por criar produtos relacionados às pizzas e calzones.
// Pizzaiolo: As fábricas concretas. Cada pizzaiolo é responsável por criar um tipo específico de pizza ou calzone.
// Pizza e Calzone: Os produtos concretos. São os produtos finais criados pelas fábricas concretas.
// Consumidor: O cliente que utiliza os produtos finais (pizzas ou calzones).

import java.util.Calendar;
import java.util.Date;

// Produto: Pizza
class Pizza {
    private String[] ingredientes;

    public Pizza(String... ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void mostrarIngredientes() {
        System.out.print("Ingredientes: ");
        for (String ingrediente : ingredientes) {
            System.out.print(ingrediente + " ");
        }
        System.out.println();
    }
}

// Produto: Calzone
class Calzone {
    private String[] ingredientes;

    public Calzone(String... ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void mostrarIngredientes() {
        System.out.print("Ingredientes do Calzone: ");
        for (String ingrediente : ingredientes) {
            System.out.print(ingrediente + " ");
        }
        System.out.println();
    }
}

// Fábrica Abstrata: Pizzaria
interface Pizzaria {
    Pizza criarPizza();
    Calzone criarCalzone();
}

// Fábrica Concreta: Pizzaiolo de Calabresa
class PizzaioloCalabresa implements Pizzaria {
    public Pizza criarPizza() {
        return new Pizza("Queijo", "Calabresa", "Tomate");
    }

    public Calzone criarCalzone() {
        return new Calzone("Queijo", "Calabresa", "Tomate");
    }
}

// Fábrica Concreta: Pizzaiolo de Presunto
class PizzaioloPresunto implements Pizzaria {
    public Pizza criarPizza() {
        return new Pizza("Queijo", "Presunto", "Tomate");
    }

    public Calzone criarCalzone() {
        return new Calzone("Queijo", "Presunto", "Tomate");
    }
}

// Cliente: Consumidor
class Consumidor {
    private Pizzaria pizzaria;

    public Consumidor(Pizzaria pizzaria) {
        this.pizzaria = pizzaria;
    }

    public void fazerPedido(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);

        switch (diaDaSemana) {
            case Calendar.MONDAY:
            case Calendar.WEDNESDAY:
            case Calendar.FRIDAY:
                Pizza pizzaCalabresa = pizzaria.criarPizza();
                pizzaCalabresa.mostrarIngredientes();
                break;
            case Calendar.TUESDAY:
            case Calendar.THURSDAY:
            case Calendar.SATURDAY:
                Pizza pizzaPresunto = pizzaria.criarPizza();
                pizzaPresunto.mostrarIngredientes();
                break;
            case Calendar.SUNDAY:
                System.out.println("A pizzaria está fechada aos domingos.");
                break;
            default:
                System.out.println("Data inválida.");
        }
    }
}

public class q1a {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // Pizzaiolos
        Pizzaria pizzaioloCalabresa = new PizzaioloCalabresa();
        Pizzaria pizzaioloPresunto = new PizzaioloPresunto();

        // Consumidor
        Consumidor consumidor = new Consumidor(pizzaioloCalabresa);

        // Diferentes dias
        Date segunda = new Date(2024 - 1900, 4, 20); // Segunda-feira
        Date domingo = new Date(2024 - 1900, 4, 26); // Domingo

        // Pedidos
        consumidor.fazerPedido(segunda);
        consumidor.fazerPedido(domingo);
    }
}
