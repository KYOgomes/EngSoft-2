import java.util.Random;

// Interface Celsius
interface MedidorCelsiusIF {
    double medirTemperatura();
}

// Medidor Farenheit
class MedidorFarenheit {
    public double getTemperatureFarenheit() {
        return new Random().nextDouble() * 100;
    }
}

// Adaptador: Farenheit -> Celsius
class AdaptadorFarenheitParaCelsiusObjectAdapter implements MedidorCelsiusIF {
    private MedidorFarenheit medidorFarenheit;

    public AdaptadorFarenheitParaCelsiusObjectAdapter(MedidorFarenheit medidorFarenheit) {
        this.medidorFarenheit = medidorFarenheit;
    }

    // Adaptação de Fahrenheit pra Celsius
    public double medirTemperatura() {
        double temperaturaFahrenheit = medidorFarenheit.getTemperatureFarenheit();

        double temperaturaCelsius = (temperaturaFahrenheit - 32) / 1.8;
        return temperaturaCelsius;
    }
}

public class q2a {
    public static void main(String[] args) {
        // Medidor de Fahrenheit da biblioteca adquirida
        MedidorFarenheit medidorFarenheit = new MedidorFarenheit();

        // Adaptador para o medidor de Fahrenheit
        AdaptadorFarenheitParaCelsiusObjectAdapter adaptador = new AdaptadorFarenheitParaCelsiusObjectAdapter(medidorFarenheit);

        // Temperatura em Celsius através do adaptador
        double temperaturaCelsius = adaptador.medirTemperatura();
        System.out.printf("Temperatura medida em Celsius: %.1f", temperaturaCelsius);
    }
}
