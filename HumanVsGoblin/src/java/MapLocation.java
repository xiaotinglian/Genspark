public class MapLocation<T, T1> {
    Coordinates c;
    String mapValue;

    public Coordinates getCoordinate() {
        return c;
    }

    public String getMapValue() {
        return mapValue;
    }

    public Coordinates setCoordinate(Coordinates c2) {
        this.c = c2;
        return c;
    }

    public void setMapValue(String mapValue) {
        this.mapValue = mapValue;
    }

    public String replace(Coordinates in, Coordinates out, String value){
        Coordinates oldC = in;
        Coordinates newC = out;
        return "\uD83C\uDF32";
    }
}
