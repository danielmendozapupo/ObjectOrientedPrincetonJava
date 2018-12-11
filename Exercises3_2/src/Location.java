public class Location {
    private double lat, longit;

    public Location(double latitude, double longitude){
        lat = latitude;
        longit = longitude;

    }

    public double distanceTo(double x, double y)
    {
        return Math.toRadians(60 * Math.asin(Math.sin(lat)* Math.sin(x) + Math.cos(lat)*Math.cos(x) * Math.cos(longit -y)));
    }

    public static void main(String[] args){
        double longitud = Double.parseDouble(args[0]);
        double latitud = Double.parseDouble(args[1]);

        double x = Double.parseDouble(args[2]);
        double y = Double.parseDouble(args[3]);

        Location locat = new Location(latitud, longitud);
        StdOut.printf("%.2f",locat.distanceTo(x, y));
    }
}
