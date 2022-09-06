package employee_management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    public static boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) return false;
        return pat.matcher(email).matches();
    }

    public static boolean checkBirthDate(String birthDate) {
        try {
            int bd = Integer.parseInt(birthDate);
            if (1900 < bd && bd < 2022) return true;
        } catch (NumberFormatException e) {
            return false;
        }

        return false;
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
