import com.google.gson.Gson;

import java.util.List;


public class Main {

    private static Gson gson;

    private static final String dataPath = "";
    public static void main(String[] args) {
    JsonTools joption = new JsonTools();

        List<User> users = joption.JsonToUser();

        //System.out.println(user.toString());

        users.forEach(user -> {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        });
    }


}
