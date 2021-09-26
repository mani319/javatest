package com.manikanta.random;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Manikanta Tummalapenta on 18/07/20
 */
public class Test1 {


    public static void main(String[] args) {
        String word = "completed";
        System.out.println(StringUtils.capitalize(word));

        Set<String> customerIds = new HashSet<>();
        customerIds.add("1");
        customerIds.add("2");
        System.out.println(Lists.newArrayList(customerIds));
    }
}

