package estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.dominio;

public class Person {
    //Builder
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;

    private Person(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class PersonBuilder {
        private String firstName;
        private String lastName;
        private String userName;
        private String email;

        private PersonBuilder() {
        }

        public static PersonBuilder aPerson() {
            return new PersonBuilder();
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName, userName, email);
        }
    }





/*
    public static final class PersonBuilder {
        private String firstName;
        private String lastName;
        private String userName;
        private String email;

        public PersonBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;//retorna o mesmo objeto e sempre estará trabalhando com o mesmo espaço em memoria
        }

        public PersonBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;//retorna o mesmo objeto
        }

        public PersonBuilder userName(String userName){
            this.userName = userName;
            return this;//retorna o mesmo objeto
        }

        public PersonBuilder email(String email){
            this.email = email;
            return this;//retorna o mesmo objeto
        }

        public Person build(){
            //method que retorna o Objeto de fato
            return new Person(firstName,lastName,userName,email);
        }

    }//PersonBuilder
*/


}//class
