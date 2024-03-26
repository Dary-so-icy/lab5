package managers;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date>{

    //private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String formatter = "yyyy-MM-dd HH:mm:ss";

    @Override
    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat(formatter).format(v);
        //return v.format(formatter);
    }


    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat(formatter).parse(v);
    }


}
