import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class Main {
    public static void main(String[] args) {
        //Создаем объект user
        User user = new User(1L, "rasim@gmail.com", "USER", "CONFIRMED");

        //Создаем токен
        String token = JWT.create()
                //берем id пользователя
                .withSubject(user.getId().toString())
                //закидываем допольнительную иформацию
                .withClaim("email", user.getEmail())
                .withClaim("role", user.getRole())
                .withClaim("state", user.getState())
                //подписываем алгоритмом шифрования
                .sign(Algorithm.HMAC256("simple_secret_key"));

        System.out.println(token);
    }
}
