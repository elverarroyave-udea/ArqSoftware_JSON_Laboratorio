import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonTools {

    Gson gson = new Gson();

    private final String filePath = "src/main/resources/users.json";
    public List<User> JsonToUser(){

        List<User> listUsers = new ArrayList<>();

        try {

            JsonArray usersJson = (JsonArray) new JsonParser().parse(new FileReader(filePath));

            for (JsonElement jsonElement : usersJson) {
                JsonObject userJson = (JsonObject) jsonElement;
                JsonObject jsonAddress = userJson.get("address").getAsJsonObject();
                Address address = new Address(
                        jsonAddress.get("streetAddress").getAsString(),
                        jsonAddress.get("city").getAsString(),
                        jsonAddress.get("postalCode").getAsInt()
                );
                User user = new User(
                        userJson.get("firstName").getAsString(),
                        userJson.get("lastName").getAsString(),
                        userJson.get("age").getAsInt(),
                        address
                );

                listUsers.add(user);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
}
