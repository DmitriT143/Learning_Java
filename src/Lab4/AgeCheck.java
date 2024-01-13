package Lab4;

import java.io.IOException;

public class AgeCheck {
    private int age;

    public void setAge(int age) throws CustomAgeException, IOException {
        if (age < 0 || age > 120){
            throw new CustomAgeException("Age is hardly possible");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
