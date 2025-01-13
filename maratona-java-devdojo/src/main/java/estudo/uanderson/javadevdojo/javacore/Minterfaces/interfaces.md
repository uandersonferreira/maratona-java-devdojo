### Pontos importantes sobre interfaces em Java:

- **Por padrão**, todos os métodos de uma interface são `public` e `abstract`.
- **Interfaces** são contratos estabelecidos entre classes e devem ser implementadas por classes. Portanto, interfaces **não podem ser privadas**.
- Quando **adicionamos métodos** a interfaces, **todas as classes** que a implementam devem implementar os novos métodos. Para evitar problemas de escalabilidade, utilize métodos concretos com a declaração `default` a partir do Java 8+.
- **Não podemos criar objetos** de interfaces.
- Ao sobrescrever métodos de uma interface, **não podemos utilizar modificadores de acesso** mais restritivos que os da superclasse.
- **Atributos de interfaces** são constantes por padrão (`public static final`), tornando redundante a sua declaração explícita.
- **Métodos estáticos** em interfaces nunca serão sobrescritos, pois pertencem à classe.
