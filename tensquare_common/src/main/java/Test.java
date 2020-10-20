import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import util.JwtUtil;

import java.util.Date;

/**
 * @author chenshuai
 */
public class Test {
    public static void main(String[] args) {

        JwtUtil

        JwtBuilder builder= Jwts.builder()
                .setId("888").setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"itcast");
        System.out.println(builder.compact());
    }
}
