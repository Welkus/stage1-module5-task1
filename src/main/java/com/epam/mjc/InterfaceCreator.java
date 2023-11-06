package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream().allMatch(s -> Character.isUpperCase(s.charAt(0)));
        }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {


        return list -> {
            List<Integer> lls = new ArrayList<>();
            lls = list.stream().filter(s -> s%2 ==0).collect(Collectors.toList());
            list.addAll(lls);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {

        return () -> values.stream().filter(s -> Character.isUpperCase(s.charAt(0)) && s.endsWith(".") && s.length() > 2).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {

        return list -> {
            Map<String,Integer> map = new HashMap<>();
            for(String s : list){
                map.put(s,s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {

    return (list,list2) -> {
     List<Integer> ll = new ArrayList<>();
     ll.addAll(list);
     ll.addAll(list2);
     return ll;
    };
    }
}
