package estudo.uanderson.javadevdojo.javacore.ZZClambdas.domain;

public class Anime {
    private String title;
    private Integer episodes;

    public Anime(String title, Integer episodes) {
        this.title = title;
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", Episodes=" + episodes +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Integer getEpisodes() {
        return episodes;
    }
}//class
