package employee_management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    public static boolean checkEmail(String email) throws EmailException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) return false;
        if (pat.matcher(email).matches()) return true;
        else throw new EmailException("Invalid Email!");
    }

    public static boolean checkBirthDate(String birthDate) throws BirthDayException {
//        try {
//            int bd = Integer.parseInt(birthDate);
//            if (1900 < bd && bd < 2022) return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
        String birthDateFormat = "^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$"
                + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";

        Pattern pat = Pattern.compile(birthDateFormat);
        if (birthDate == null) return false;
        if (pat.matcher(birthDate).matches()) return true;
        else throw new BirthDayException("Invalid Birth Day!");
    }

    public static boolean checkRank(String rank) {
        ArrayList<String> rankList = new ArrayList<>(Arrays.asList("Excellence", "Good", "Fair", "Poor"));
        return rankList.stream().anyMatch(s -> s.equalsIgnoreCase(rank));
    }

    public static boolean checkPhone(String phone) throws PhoneException {

        if (phone.matches("^[0][396][0-9]{8}")) return true;
        else throw new PhoneException("Phone # is invalid!");

    }
}
