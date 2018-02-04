package home.work.gwt.common;


import com.google.gwt.i18n.shared.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Utils {

    public static String formatDate(Date date) {
        return Objects.isNull(date) ? "" : DateTimeFormat.getFormat("dd.MM.yyyy").format(date);
    }

}
