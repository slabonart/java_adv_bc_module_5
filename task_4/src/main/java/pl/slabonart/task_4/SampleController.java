package pl.slabonart.task_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
class SampleController {
    @GetMapping("/unsafe")
    public String unsafeMethod(String input) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "password");
            Statement statement = connection.createStatement();
            connection.close();
            statement.executeQuery("SELECT * FROM user_data WHERE user_name = '" + input + "'");
            return null;
        } catch (SQLException e) {
            return "Error in SQL Handling";
        }
    }

    @GetMapping("/logic-error")
    public int faultyLogic() {
        int a = 10;
        int b = 0;
        return a / b;
    }

    @PostMapping("/unsafe-deserialization")
    public void unsafeDeserialization(@RequestBody String serializedInput) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(serializedInput.getBytes()));
            Object obj = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/plaintext-password")
    public String plaintextPassword() {
        String password = "hardcodedPassword";
        return password;
    }

    @GetMapping("/overcomplicated")
    public String overcomplicatedMethod() {
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                continue;
            }
        }
        return "Overcomplicated Logic Executed";
    }
}
