public class City {

    private final int id;
    private final String name;
    private final String region;
    private final String district;
    private final int population;
    private final String foundation;

    City(String [] args) {
        this.id = Integer.valueOf(args[0]);
        this.name = args[1] ;
        this.region = args[2];
        this.district = args[3];
        this.population = Integer.valueOf(args[4]);
        this.foundation = args[5];

    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }



    @Override
    public String toString() {
        return "City{" + "name=" + "'" + getName() + "'" + ","
                + "region=" + "'" + getRegion() + "'" + ","
                + "district=" + "'" + getDistrict() + "'" + ","
                + "population=" + "'" + getPopulation() + "'" + ","
                + "fundation=" + "'" + getFoundation() + "'";
    }

}
