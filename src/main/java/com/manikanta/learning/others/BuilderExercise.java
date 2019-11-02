package com.manikanta.learning.others;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Manikanta Tummalapenta on 30 Oct 2019
 */
class Code
{
    String className;
    Map<String, String> nameTypeMap = new HashMap();

    public Code() {
    }

    public String toStringImpl() {
        StringBuilder str = new StringBuilder()
                .append(String.format("public class %s\n{\n", this.className));
        for (Map.Entry<String, String> entry : nameTypeMap.entrySet()) {
            str.append(String.format("  public %s %s;\n", entry.getValue(), entry.getKey()));
        }
        str.append("}");

        return str.toString();
    }
}

class CodeBuilder
{
    private Code code = new Code();

    public CodeBuilder(String className)
    {
        code.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        code.nameTypeMap.put(name, type);
        return this;
    }

    @Override
    public String toString()
    {
        return code.toStringImpl();
    }
}

public class BuilderExercise {

    private static String preprocess(String text)
    {
        return text.replace("\r\n", "\n").trim();
    }

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);

        // Test case - 1
        CodeBuilder cb1 = new CodeBuilder("Foo");
        assertEquals("public class Foo\n{\n}",
                preprocess(cb1.toString()));

        // Test case - 2
        CodeBuilder cb2 = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        assertEquals("public class Person\n{\n" +
                        "  public String name;\n" +
                        "  public int age;\n}",
                preprocess(cb2.toString()));
    }
}