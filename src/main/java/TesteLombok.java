import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TesteLombok {
    private String nome;
    private int idade;
}

class Main {
    public static void main(String[] args) {
        TesteLombok t = TesteLombok.builder().nome("Tulio").idade(26).build();
        System.out.println(t);
    }
}
