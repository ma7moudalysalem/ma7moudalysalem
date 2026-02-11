package com.ma7moudalysalem;

import org.yaml.snakeyaml.Yaml;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        String yamlString = "name: Mahmoud Salem\nrole: Software Engineer";
        Map<String, String> data = yaml.load(yamlString);
        System.out.println("Parsed YAML: " + data);
    }
}
