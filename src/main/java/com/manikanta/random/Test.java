package com.manikanta.random;


import org.apache.commons.collections4.CollectionUtils;
import org.joda.time.LocalDateTime;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Manikanta Tummalapenta on 20 Feb 2019
 */
public class Test {

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (byte arrayByte : arrayBytes) {
            // Please refer to https://stackoverflow.com/questions/25838473/what-does-0xff-do-and-md5-structure
            // for understanding the below implementation
            stringBuffer.append(Integer.toString((arrayByte & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }

    private static String encryptString(String input) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Produces a 160-bit(20-byte) hash value
            byte[] messageDigest = md.digest(input.getBytes());

            return convertByteArrayToHexString(messageDigest);
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        LocalDateTime timeNow = LocalDateTime.now();
        System.out.println("LocalDateTime now: " + timeNow);

        LocalDateTime timePlusOneDay = LocalDateTime.now().plusDays(1);
        System.out.println("LocalDateTime after 1 day: " + timePlusOneDay);


        String negNum = "-6";
        String posNum = "+6";
        System.out.println("Negative number to Long: " + Long.parseLong(negNum));
        System.out.println("Positive number to Long: " + Long.parseLong(posNum));


        long timeUnit = TimeUnit.DAYS.toSeconds(-2);
        System.out.println("Days to seconds: " + timeUnit);

        long millisToSec = TimeUnit.MILLISECONDS.toSeconds(-2010);
        System.out.println("Millis to seconds: " + millisToSec);

        System.out.println(null + "1234");

        Integer numberOfDigits = 14;
        Long documentId = 1L;
        String formatter = "%0"+numberOfDigits+"d";
        String finalDocId = String.format(formatter,documentId);
        System.out.println("DocumentId: " + finalDocId);

        String oldDocId = "C1000000000000044";
        if (oldDocId.length() == 17) {
            String updatedDocumentId = oldDocId.substring(0, 2) + oldDocId.substring(2 + 1);
            System.out.println("Old: " + oldDocId + " New: " + updatedDocumentId);

            if (updatedDocumentId.length() == 16) {
                System.out.println("Updated length to 16. Hola!");
            }
        }

        Map<Long, List<Long>> returnedOrderLineMap = new HashMap<>();
        System.out.println("Sample : " + returnedOrderLineMap.get(1L));

        String sampleLogin = "sfloadtest-4757c335.1959.4b31.9d04.7a829904fd2fTjX96qA0kh";
        String app = "scmloadtest, sfloadtest";
        Set<String> strings = StringUtils.commaDelimitedListToSet(app);
        for (String prefix : strings) {
            if (sampleLogin.contains(prefix)) {
                System.out.println("Yola1!");
            }
        }

        String app2 = "scmloadtest,sfloadtest";
        Set<String> strings2 = StringUtils.commaDelimitedListToSet(app2);
        for (String prefix : strings2) {
            if (sampleLogin.contains(prefix)) {
                System.out.println("Yola2!");
            }
        }

        Long reasonId = 4L;
        Set<String> eligibleReasons = new HashSet<>(6);
        Set<String> rawSetOfReasons = new HashSet<>(6);
        rawSetOfReasons.add("4 ");
        rawSetOfReasons.add(" 35");
        rawSetOfReasons.add(" 37 ");
        System.out.println(rawSetOfReasons.contains(reasonId.toString()));
        for (String reasonCode: rawSetOfReasons) {
            eligibleReasons.add(reasonCode.trim());
        }
        System.out.println(eligibleReasons);
        System.out.println(eligibleReasons.contains(reasonId.toString()));

        List<Integer> intList = new ArrayList<>();
        for (Integer i : intList) {
            System.out.println(i);
        }

        String packetId = "5072017576";
        String documentName = "customerInvoice";
        List<String> orderLineList = Arrays.asList("4172677702", "4172677704");
        Collections.sort(orderLineList);

        String linesIds = String.join("-", orderLineList);
        linesIds = linesIds + "_" + packetId + "_" + documentName;
        System.out.println(linesIds);
//        System.out.println(linesIds.hashCode());
        System.out.println(encryptString(linesIds));

        String listOfReasons = " ";
        List<String> cancellationIdsForGoodwillCouponList = Arrays.asList(listOfReasons.split(","));
        System.out.println("Reasons: " + cancellationIdsForGoodwillCouponList);
        System.out.println("Check whether 14 is in list: " + cancellationIdsForGoodwillCouponList.contains("14"));

        Boolean trueValue = new Boolean("true");
        System.out.println("Test1: " + trueValue);

//        Date nullTime = null;
//        System.out.println("Time in ms: " + nullTime.getTime());

        Set<Long> a = new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
        Set<Long> b = new HashSet<>(Arrays.asList(3L, 4L, 5L, 6L, 7L));

        System.out.println("a-b=" + CollectionUtils.removeAll(a, b));
        System.out.println("a, b after a-b: " + a + b);
        System.out.println("b-a=" + CollectionUtils.removeAll(b, a));
        System.out.println("a, b after b-a: " + a + b);

        List<Integer> nodes = new ArrayList<>();

        int a1 = 0;
        int a2 = 1;
        AtomicInteger atomicInteger1 = new AtomicInteger(2);
        AtomicInteger atomicInteger2 = new AtomicInteger(3);
        System.out.println(atomicInteger1.addAndGet(a1 + a2));
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.set(a1 + a2);
        System.out.println(atomicInteger1);


        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        pq.poll();

        final String IRN_TOPIC_FORMAT = "irn_%s";
        System.out.println(String.format(IRN_TOPIC_FORMAT, "invoiceNum"));

        List<Integer> newList = null;
        for (Integer in : nullSafeCollection(newList)) {
            System.out.println("Just loop" + in);
        }

        boolean b1 = true;
        if (b1 = false) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }

        int ab = 99;
        System.out.println((long) ab);

        AtomicInteger integer = new AtomicInteger(0);
        System.out.println("-------- Print Evens ----------");
        printEvent(0);
    }

    public static void printEvent(int i) {
        if (i > 100) {
            return;
        }
        System.out.println(i);
        printEvent(i+2);
    }

    public static <T> List<T> nullSafeCollection(Collection<T> c){
        return c != null?new ArrayList<T>(c):new ArrayList<T>();
    }


}
