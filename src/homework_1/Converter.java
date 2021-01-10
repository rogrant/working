package homework_1;


public class Converter {
    public static float kelvinFromCelc(float cel)
    {
        return cel + 273.15f;
    }

    public static float fahrenheitFromCelc(float cel)
    {
        return cel*9/5+32;
    }

    public static void main(String[] args) {
        float grad = 0f; // градусов по цельсию

        System.out.println(Float.toString(grad) + " градусов по Цельсию это "
                + Float.toString(kelvinFromCelc(grad)) + " градусов Келвина");

        System.out.println(Float.toString(grad) + " градусов по Цельсию это "
                + Float.toString(Converter.fahrenheitFromCelc(grad)) + " градусов Фаренгейта");
    }
}
