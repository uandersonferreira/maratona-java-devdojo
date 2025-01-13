package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.domain;

import lombok.Builder;
import lombok.Value;
@Value
@Builder
public final class Producer {
    private final  Integer id;
    private final String name;

}//class
/*
O lombok irá criar automaticamente os methodos:
- Construtor
- Gerar a classe no padrão Builder
- Equals e HasCode
- Gets
- toString


public class Producer {
    private Integer id;
    private String name;

    public Producer() {
    }

    public String toString() {
        return "Producer{id=" + this.id + ", name='" + this.name + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Producer producer = (Producer)o;
            return Objects.equals(this.id, producer.id) && Objects.equals(this.name, producer.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.name});
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static final class ProducerBuilder {
        private Integer id;
        private String name;

        private ProducerBuilder() {
        }

        public static ProducerBuilder builder() {
            return new ProducerBuilder();
        }

        public ProducerBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public ProducerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Producer build() {
            Producer producer = new Producer();
            producer.name = this.name;
            producer.id = this.id;
            return producer;
        }
    }
}

 */