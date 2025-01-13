package estudo.uanderson.javadevdojo.javacore.ZZJcrud.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public final class Producer {
    private final  Integer id;
    private final String name;

}//class
