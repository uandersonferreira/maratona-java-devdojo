package dio.estruturas-de-dados.collections-java;

public class SetImplementation {
    public static void main(String[] args) {
        // Exemplo com HashSet
        Set<Carro2> hashSetCarros = new HashSet<>();
        hashSetCarros.add(new Carro2("Ford"));
        hashSetCarros.add(new Carro2("Chevrolet"));
        hashSetCarros.add(new Carro2("Fiat"));
        hashSetCarros.add(new Carro2("Peugeot"));
        hashSetCarros.add(new Carro2("Zip"));
        hashSetCarros.add(new Carro2("Alfa Romeo"));

        System.out.println("HashSet: " + hashSetCarros);

        // Verificando se um elemento está no conjunto
        System.out.println("Contém 'Ford'? " + hashSetCarros.contains(new Carro2("Ford")));

        // Removendo um elemento do conjunto
        hashSetCarros.remove(new Carro2("Zip"));
        System.out.println("HashSet após remover 'Zip': " + hashSetCarros);

        // Iterando sobre os elementos do HashSet
        System.out.println("Iterando sobre o HashSet:");
        for (Carro2 carro : hashSetCarros) {
            System.out.println(carro);
        }

        // Convertendo o Set para uma lista
        List<Carro2> listaCarros = new ArrayList<>(hashSetCarros);
        System.out.println("Convertido para lista: " + listaCarros);

        // Exemplo com LinkedHashSet
        Set<Carro2> linkedHashSetCarros = new LinkedHashSet<>(hashSetCarros);
        linkedHashSetCarros.add(new Carro2("BMW"));
        System.out.println("\nLinkedHashSet (mantém a ordem de inserção): " + linkedHashSetCarros);

        // Exemplo com TreeSet
        Set<Carro2> treeSetCarros = new TreeSet<>();
        treeSetCarros.add(new Carro2("Ford"));
        treeSetCarros.add(new Carro2("Chevrolet"));
        treeSetCarros.add(new Carro2("Fiat"));
        treeSetCarros.add(new Carro2("Peugeot"));
        treeSetCarros.add(new Carro2("Zip"));
        treeSetCarros.add(new Carro2("Alfa Romeo"));

        System.out.println("\nTreeSet (ordenado): " + treeSetCarros);

        // Tamanho do TreeSet
        System.out.println("Tamanho do TreeSet: " + treeSetCarros.size());

        // Verificando se o TreeSet está vazio
        System.out.println("TreeSet está vazio? " + treeSetCarros.isEmpty());

        // Tentando adicionar um elemento duplicado
        boolean adicionado = treeSetCarros.add(new Carro2("Fiat"));
        System.out.println("Adicionando elemento duplicado 'Fiat': " + adicionado);
        System.out.println("TreeSet após tentativa de adicionar duplicado: " + treeSetCarros);

        // Limpando todos os elementos do TreeSet
        treeSetCarros.clear();
        System.out.println("TreeSet após clear(): " + treeSetCarros);
    }
}