package com.example.hw2;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    Map<Integer, String> catchPhrases = new HashMap<>();

    {
        catchPhrases.put(1, "Життя — це те, що з тобою відбувається, поки ти будуєш плани. Джон Леннон");
        catchPhrases.put(2, "Прагніть не до успіху, а до цінностей, які він дає. Альберт Айнштайн");
        catchPhrases.put(3, "Спочатку мрії здаються неможливими, потім неправдоподібними, а потім неминучими. Крістофер Рів");
        catchPhrases.put(4, "Найкраща помста — величезний успіх. Френк Сінатра");
        catchPhrases.put(5, "Талант — це дар, якому неможливо ні навчити, ні навчитися. Іммануїл Кант");
        catchPhrases.put(6, "Єдиний спосіб робити свою роботу добре — це любити її. Якщо ти ще не знайшов свою улюблену справу, продовжуй шукати. Стів Джобс");
        catchPhrases.put(7, "Поки ти тримаєшся за свою «стабільність», хтось поруч втілює в життя твої мрії. Роберт Орбен");
        catchPhrases.put(8, "Успіх — це вміння рухатись від невдачі до невдачі, не втрачаючи ентузіазму. Вінстон Черчилль");
        catchPhrases.put(9, "Успіх — справа виключно випадку. Це вам скаже будь-який невдаха. Ерл Вілсон");
        catchPhrases.put(10, "Не варто хвилюватися. У світі немає нічого страшнішого за нас самих. Туве Янссон");

    }

    private int id = catchPhrases.size();

    //    @GetMapping("/citation")
//    public String getCitation1(@RequestParam Integer id){
//        return catchPhrases.get(id);
//    }


    // get one citation by id
    @GetMapping("/citation/{id}")
    public String getCitation1(@PathVariable Integer id) {

        return catchPhrases.get(id);
    }


    // get all citations
    @GetMapping("/citation")
    public Map<Integer, String> catchPhrases() {

        return catchPhrases;
    }


    //    @GetMapping("/citation")
//    public Collection<String> catchPhrases() {
//        return catchPhrases.values();
//    }

//    @PostMapping("/citation")
//    public String postCitation1(@RequestBody String citation) {
//        catchPhrases.put(++id, citation);
//        return "Your citation under the number: " + id;
//    }


    // add one citation
    @PostMapping("/citation")
    public String postCitation1(@RequestBody Citation citation) {
        catchPhrases.put(++id, citation.getCitation());
        return "Your citation under the number: " + id;

    }

    // add few citations
//    [{
//        "citation": "нова цитата3"
//    },
//    {
//        "citation":   "нова цитата4"
//    }]
    @PostMapping("/citations")
    public String postCitation1(@RequestBody Citation[] citations) {
        String numbers = "Your citations under the numbers: ";
        for (Citation citation : citations) {
            catchPhrases.put(++id,
                    citation.getCitation());
            numbers += id + ", ";
        }

        return numbers;
    }


    // update one citation by id
    @PutMapping("/citation/{id}")
    public String updateCitation(@PathVariable Integer id, @RequestBody Citation citation) {
        catchPhrases.put(id,citation.getCitation());
        return "citation by id: " + id + " was updated";
    }


    // remove one citation by id
    @DeleteMapping("/citation/{id}")
    public String removeCitation(@PathVariable Integer id) {
        catchPhrases.remove(id);
        return "citation by id: " + id + " was removed";
    }


}