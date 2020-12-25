import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import common.Emoji;
import serializer.EmojiSerializer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        SimpleModule emojiModule = new SimpleModule();
        emojiModule.addSerializer(Emoji.class, new EmojiSerializer());
        MAPPER.registerModule(emojiModule);
        genDataFromImageStorage();
    }

    private static void genDataFromImageStorage() {
        File imgSource = new File ("DataGeneration/resource/emojis");
        File[] files = imgSource.listFiles();
        assert files != null;
        List<Emoji> emojiList = Arrays.stream(files).map(File::getName).map(Emoji::fromFilename).collect(Collectors.toList());
        System.out.println("Emoji size:" + emojiList.size());

        File outputFile = new File("src/main/resources/emojis.json");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(MAPPER.writeValueAsString(emojiList));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
