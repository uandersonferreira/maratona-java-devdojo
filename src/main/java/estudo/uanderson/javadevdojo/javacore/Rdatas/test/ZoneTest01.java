package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class ZoneTest01 {
    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(shortIds);
        System.out.println("Zona padrão Do Sistema: "+ZoneId.systemDefault());

        ZoneId zoneIdTokyo = ZoneId.of("Asia/Tokyo");
        System.out.println(zoneIdTokyo);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        ZonedDateTime zonedDateTime1 = now.atZone(zoneIdTokyo);//adicionando uma data a uma determinada Zona
        System.out.println(zonedDateTime1);//Horário Local na Zona de Tokyo utilizando LocalDataTime

        Instant nowInstant = Instant.now();
        System.out.println(nowInstant);
        ZonedDateTime zonedDateTime2 = nowInstant.atZone(zoneIdTokyo);
        System.out.println(zonedDateTime2);

        System.out.println("Min ZoneOffset"+ZoneOffset.MIN);
        System.out.println("Max ZoneOffset"+ZoneOffset.MAX);

        ZoneOffset offsetManaus = ZoneOffset.of("-04:00");
        OffsetDateTime offsetDateTime1 = now.atOffset(offsetManaus);
        System.out.println(offsetDateTime1);
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(now, offsetManaus);
        System.out.println(offsetDateTime2);

        OffsetDateTime offsetDateTime3 = nowInstant.atOffset(offsetManaus);
        System.out.println(offsetDateTime3);

        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate);
        LocalDate localDateEraHeisei = LocalDate.of(2002, 8, 13);
        JapaneseDate heiseiEra = JapaneseDate.from(localDateEraHeisei);
        System.out.println(heiseiEra);
    }
}
//Aula 129


/*
2022-07-18T11:32:51.328955+09:00[Asia/Tokyo]
    +09:00 --> é o offset/ZoneOffset
    [Asia/Tokyo] --> é a Zona


 */
