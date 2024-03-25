package managers;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAdapter extends XmlAdapter {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//    @Override
//    public String marshal(Date v) throws Exception {
//        return v.toString();
//        //return v.format(formatter);
//    }
//
//    @Override
//    public Date unmarshal(String v) throws Exception {
//        return Date.parse(v, formatter);
//    }


    @Override
    public Object unmarshal(Object o) throws Exception {
        return null;
    }

    @Override
    public Object marshal(Object o) throws Exception {
        return null;
    }
}
