package javab10;



public class Person {
    public String fullname;
    public String email;
    public Integer age;

    public Person(String fullname, String email, Integer age){
        this.fullname = fullname;
        this.email = email;
        this.age =age;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
