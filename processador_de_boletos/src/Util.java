package processador_de_boletos.src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static Boolean isDouble(String valor) {
        Boolean result = true;

        try
        {
          Double.parseDouble(valor);
        }
        catch(NumberFormatException e)
        {
          result = false;
        }

        return result;
    }

    public static Boolean verificaString(String valor) {

        Pattern pattern = Pattern.compile("^[A-Za-z0-9 ]+$");
        Matcher matcher = pattern.matcher(valor);
        Boolean result = matcher.find();

        return result;
    }

    public static Boolean verificaData(String data) {
        Boolean result = true;

        String pattern = "dd-MM-yyyy";

        DateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        try {
            sdf.parse(data);
        } catch (ParseException e) {
            result = false;
        }
        
        return result;
    }
}
