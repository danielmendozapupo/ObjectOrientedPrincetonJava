public class Location {
    private final double latitude, longitude;
    private final double radius = 3960;
    //private final char lat_str, long_str;
    private final double x, y, z;


    public Location(double lat,double longit){

        latitude = lat;
        longitude = longit;
         x = radius * Math.cos(latitude);
         y = radius * Math.sqrt(1 - Math.sin(latitude) - Math.cos(latitude)* Math.cos(longitude));
         z = radius * Math.sin(latitude);



        }


    public double distanceTo(Location b){
    // d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
        return radius * Math.acos(Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(b.latitude)) +
                Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(b.latitude)) *
                        Math.cos(Math.toRadians(longitude - b.longitude)));
    }

    public Location generateLocation(){
        //minLat = -90.00
        //maxLat = 90.00
        //latitude =minLat + (double)(Math.random() * ((maxLat - minLat) + 1));
        double lat = -90.0 + (Math.random() * (180.00 +1) );
        // double longitude = minLon + (double)(Math.random() * ((maxLon - minLon) + 1));
        //minLon = 0.00
        //maxLon = 180.00
        double longit =  Math.random() * (180.00 + 1);

        Location b = new Location(lat,longit);
        return b;
    }
    public String toString(){
        return ("Latitude: "+ this.latitude+"\tLongitude: " + this.longitude);
    }

    public static void main(String[] args){
    double latitude = Double.parseDouble(args[0]);
    double longitude = Double.parseDouble(args[1]);
    Location location = new Location(latitude, longitude);
    StdOut.println(location);

    Location loc = location.generateLocation();
    StdOut.printf("Latitude: %.3f\tLongitude: %.4f",loc.latitude, loc.longitude);
    }
}
