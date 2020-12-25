package common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Emoji {
    private static final String PREFIX = "emoji_u";
    private static final String EXT = ".png";
    private static final Pattern UNDERSCORE = Pattern.compile("_");

    private String emojiChar;
    private String emoji;
    private String description;
    private List<String> aliases;
    private List<String> tags;
    private boolean supports_fitzpatrick;
    private boolean supports_gender;

    public Emoji() {
        this.emojiChar = "";
        this.emoji = "";
        this.description = "";
        this.aliases = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.supports_fitzpatrick = false;
        this.supports_gender = false;
    }


    public String getEmojiChar() {
        return emojiChar;
    }

    public void setEmojiChar(String emojiChar) {
        this.emojiChar = emojiChar;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean isSupports_fitzpatrick() {
        return supports_fitzpatrick;
    }

    public void setSupports_fitzpatrick(boolean supports_fitzpatrick) {
        this.supports_fitzpatrick = supports_fitzpatrick;
    }

    public boolean isSupports_gender() {
        return supports_gender;
    }

    public void setSupports_gender(boolean supports_gender) {
        this.supports_gender = supports_gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Emoji emoji = (Emoji) obj;
        return emoji.getEmojiChar().equals(emojiChar);
    }

    @Override
    public int hashCode() {
        return 31 * emojiChar.hashCode();
    }

    public static Emoji fromGemoji(Gemoji gemoji) {
        Emoji emoji = new Emoji();
        emoji.setEmojiChar(gemoji.getEmoji());
        emoji.setEmoji(gemoji.getEmoji());
        emoji.setAliases(gemoji.getAliases());
        emoji.setDescription(gemoji.getDescription());
        emoji.setTags(gemoji.getTags());
        return emoji;
    }


    public static Emoji fromFilename(String filename) {
        Emoji emoji = new Emoji();
        String[] hexStrList = UNDERSCORE.split(filename.substring(PREFIX.length(), filename.length() - EXT.length()));
        StringBuilder builder = new StringBuilder();
        for (String str : hexStrList) {
            builder.appendCodePoint(Integer.parseInt(str, 16));
        }
        emoji.setEmojiChar(builder.toString());
        return emoji;
    }
}
