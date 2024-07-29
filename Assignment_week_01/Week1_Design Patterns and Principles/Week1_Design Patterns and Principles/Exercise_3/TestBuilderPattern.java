package Exercise_3;
// TestBuilderPattern.java
public class TestBuilderPattern {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
            .setCPU("Intel i7")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();

        System.out.println(computer);
    }
}
