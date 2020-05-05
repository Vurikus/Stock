package frontend;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, Date> {
    //Field

    //Constructor

    //Function

    @Override
    public Date unmarshal(String v) throws Exception {
        return Date.valueOf(LocalDate.parse(v, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @Override
    public String marshal(Date v) throws Exception {
        return v.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
