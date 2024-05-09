import java.util.Random;

// Interface Celsius
interface MedidorCelsiusIF {
    double medirTemperatura();
}

// Medidor Fahrenheit
class MedidorFarenheit {
    public double getTemperatureFarenheit() {
        return new Random().nextDouble() * 100;
    }
}

// Adaptador: Farenheit -> Celsius
class AdaptadorFarenheitParaCelsiusClassAdapter extends MedidorFarenheit implements MedidorCelsiusIF {
    // Método para medir a temperatura em Celsius
    public double medirTemperatura() {
        double temperaturaFahrenheit = getTemperatureFarenheit();

        double temperaturaCelsius = (temperaturaFahrenheit - 32) / 1.8;
        return temperaturaCelsius;
    }
}

public class q2b {
    public static void main(String[] args) {
        // Adaptador para o medidor de Fahrenheit
        AdaptadorFarenheitParaCelsiusClassAdapter adaptador = new AdaptadorFarenheitParaCelsiusClassAdapter();

        // Temperatura em Celsius através do adaptador
        double temperaturaCelsius = adaptador.medirTemperatura();
        System.out.printf("Temperatura medida em Celsius: %.1f", temperaturaCelsius);
    }
}
