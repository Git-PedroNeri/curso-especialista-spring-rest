import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationMap {
    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();

        map.put("username", "maria");
        map.put("email", "pedro");
        map.put("phone", "paulo");

        Set<String> keys = map.keySet();
        Collection<String> values = map.values();

        String join = String.join(",", values);
//        System.out.println(join);

        for (String chaveDoElemento:keys){
            String valorDoElemento = map.get(chaveDoElemento);
            System.out.println(valorDoElemento);
        }


    }

}
