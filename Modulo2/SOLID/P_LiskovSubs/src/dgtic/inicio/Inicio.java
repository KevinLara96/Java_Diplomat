package dgtic.inicio;

import java.sql.Timestamp;
import java.util.Date;

public class Inicio {
    public static void main(String[] args) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());

        System.out.println(date.equals(ts));
        System.out.println(ts.equals(date));
    }
}