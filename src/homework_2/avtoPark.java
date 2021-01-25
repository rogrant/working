import homework_2.doppak.*;

import java.util.*;

public class avtoPark {
    public static void main(String[] arg)
    {
        List<Car> park = new ArrayList<>();
        park.add(new Car("Лада","седан"));
        park.add(new Car("Лада","хэтчбек"));
        park.add(new Car("Мерседес","седан"));
        park.add(new Car("Бмв","кроссовер"));
        park.add(new Car("Форд","хэтчбек"));
        park.add(new Car("Пежо","кроссовер"));
        park.add(new Car("Тойота","седан"));

        Collections.sort(park);
        List<List<Car>> carByType = new ArrayList<>();
        for (Car car : park)
        {
            if(carByType.size()==0 || carByType.get(carByType.size()-1).size()==0 || carByType.get(carByType.size()-1).get(0).getType() != car.getType())
            {
                carByType.add(new ArrayList<>());
            }
            carByType.get(carByType.size()-1).add(car);
        }

        for (List<Car> lst : carByType)
        {
            System.out.println(lst);
        }
    }
}