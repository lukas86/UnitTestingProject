package testSimple;

import java.util.HashMap;
import java.util.Map;

public class PopulationSearch {

    public int getPopulation(String city) {
        if(city.isEmpty()) {
            throw new NullPointerException("Input should not be empty");
        }

        Map<String, Integer> populationMap = getPopulationStatistic();

        if(!populationMap.containsKey(city)) {
            throw new NullPointerException("Invalid input");
        }
        return populationMap.get(city);
    }

    //user can give empty input
    //input may not be in database

    private Map<String, Integer> getPopulationStatistic() {
        Map<String, Integer> populationMap = new HashMap<>();
        populationMap.put("Bangalore", 200000);
        populationMap.put("Hyderabad", 500000);
        populationMap.put("Pune", 300000);
        populationMap.put("Mumbai", 800000);
        return populationMap;
    }


}
