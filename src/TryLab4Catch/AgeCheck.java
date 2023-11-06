package TryLab4Catch;

public class AgeCheck {
    private int age;

    public void setAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120){
            throw new CustomAgeException("Age is hardly possible");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
