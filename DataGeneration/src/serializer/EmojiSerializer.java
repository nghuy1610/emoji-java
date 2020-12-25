package serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import common.Emoji;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class EmojiSerializer extends StdSerializer<Emoji> {
    private static final String FORMATTER = "%1$02X";

    public EmojiSerializer() {
        super(Emoji.class);
    }


    protected EmojiSerializer(Class<Emoji> t) {
        super(t);
    }

    @Override
    public void serialize(Emoji emoji, JsonGenerator jsonGen, SerializerProvider serializerProvider) throws IOException {
        jsonGen.writeStartObject();
        jsonGen.writeObjectField("aliases", emoji.getAliases());
        jsonGen.writeStringField("description", emoji.getDescription());
        jsonGen.writeStringField("emojiChar", emoji.getEmojiChar().replaceAll("\ufe0f", ""));
        jsonGen.writeBooleanField("supports_fitzpatrick", emoji.isSupports_fitzpatrick());
        jsonGen.writeObjectField("tags", emoji.getTags());
        jsonGen.writeBooleanField("supports_gender", emoji.isSupports_gender());

        byte[] bytes =  emoji.getEmojiChar().getBytes(StandardCharsets.UTF_16);
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i < bytes.length; i+=2) {
            String hex = String.format(FORMATTER, bytes[i]) + String.format(FORMATTER, bytes[i+1]);
            if (!hex.equalsIgnoreCase("fe0f")) {
                builder.append("\\u").append(hex);
            }
        }
        jsonGen.writeStringField("emoji", builder.toString().toLowerCase());
        jsonGen.writeEndObject();

    }
}
